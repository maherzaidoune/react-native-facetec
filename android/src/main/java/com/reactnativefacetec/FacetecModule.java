package com.reactnativefacetec;

import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facetec.zoom.sdk.ZoomSDK;
import com.reactnativefacetec.ZoomProcessors.AuthenticateProcessor;
import com.reactnativefacetec.ZoomProcessors.EnrollmentProcessor;
import com.reactnativefacetec.ZoomProcessors.LivenessCheckProcessor;
import com.reactnativefacetec.ZoomProcessors.Processor;
import com.reactnativefacetec.ZoomProcessors.ZoomGlobalState;

import java.util.HashMap;
import java.util.Map;

public class FacetecModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "Facetec";
    private static ReactApplicationContext reactContext = null;
    public Processor latestProcessor;


    public FacetecModule(ReactApplicationContext context) {
        // Pass in the context to the constructor and save it so you can emit events
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        super(context);

        reactContext = context;
    }

    @Override
    public String getName() {
        // Tell React the name of the module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        return REACT_CLASS;
    }

    @Override
    public Map<String, Object> getConstants() {
        // Export any constants to be used in your native module
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        final Map<String, Object> constants = new HashMap<>();
        constants.put("EXAMPLE_CONSTANT", "example");

        return constants;
    }

    private static void emitDeviceEvent(String eventName, @Nullable WritableMap eventData) {
        // A method for emitting from the native side to JS
        // https://facebook.github.io/react-native/docs/native-modules-android.html#sending-events-to-javascript
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, eventData);
    }

    @ReactMethod
    public void Init() {
        ZoomSDK.initialize(
                reactContext,
                ZoomGlobalState.DeviceLicenseKeyIdentifier,
                ZoomGlobalState.PublicFaceMapEncryptionKey,
                new ZoomSDK.InitializeCallback() {
                    @Override
                    public void onCompletion(final boolean successful) {
                        WritableMap params = Arguments.createMap();
                        try{
                            params.putString("initState", ZoomSDK.getStatus(getCurrentActivity()).toString());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        if(successful)
                            params.putBoolean("successful", true);
                        else
                            params.putBoolean("successful", false);
                        emitDeviceEvent("initialize", params);
                        getCurrentActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(reactContext, "init " + successful, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
        );
    }

    @ReactMethod
    public void Enroll() {
        latestProcessor = new EnrollmentProcessor(getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
    }

    @ReactMethod
    public void AuthenticateUser() {
        if(!ZoomGlobalState.isRandomUsernameEnrolled){
            Toast.makeText(reactContext, "Please enroll first before trying authentication." , Toast.LENGTH_SHORT).show();
            return;
        }
        latestProcessor  = new AuthenticateProcessor(getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
    }

    @ReactMethod
    public void LivenessCheck() {
        latestProcessor = new LivenessCheckProcessor( getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
    }

    Processor.SessionTokenErrorCallback sessionTokenErrorCallback = new Processor.SessionTokenErrorCallback() {
        @Override
        public void onError(String msg) {
            getCurrentActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(reactContext, "Error " + msg , Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    Processor.SessionTokenSuccessCallback sessionTokenSuccessCallback = new Processor.SessionTokenSuccessCallback() {
        @Override
        public void onSuccess(String msg) {
            getCurrentActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(reactContext, "Success " + msg , Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
}
