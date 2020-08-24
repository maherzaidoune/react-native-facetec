package com.reactnativefacetec;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facetec.zoom.sdk.ZoomCustomization;
import com.facetec.zoom.sdk.ZoomGuidanceCustomization;
import com.facetec.zoom.sdk.ZoomSDK;
import com.reactnativefacetec.ZoomProcessors.AuthenticateProcessor;
import com.reactnativefacetec.ZoomProcessors.EnrollmentProcessor;
import com.reactnativefacetec.ZoomProcessors.LivenessCheckProcessor;
import com.reactnativefacetec.ZoomProcessors.Processor;
import com.reactnativefacetec.ZoomProcessors.ThemeHelpers;
import com.reactnativefacetec.ZoomProcessors.ZoomGlobalState;
import com.reactnativefacetec.ZoomProcessors.PhotoIDMatchProcessor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FacetecModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "Facetec";
    private static ReactApplicationContext reactContext = null;
    public Processor latestProcessor;

  Callback onSuccess;
  Callback onFail;

    public FacetecModule(ReactApplicationContext context) {
        // Pass in the context to the constructor and save it so you can emit events
        // https://facebook.github.io/react-native/docs/native-modules-android.html#the-toast-module
        super(context);
        reactContext = context;
        ThemeHelpers themeHelpers = new ThemeHelpers(context);
        themeHelpers.setAppTheme("Sample Bank");
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
    public void Init(Callback onSuccess, Callback onFail) {
    this.onSuccess = onSuccess;
    this.onFail = onFail;

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
          if(successful){
            params.putBoolean("successful", true);
            onSuccess.invoke(params);
          }
          else{
            onFail.invoke(params);
            params.putBoolean("successful", false);
          }
          //emitDeviceEvent("initialize", params);
        }
      }
    );
  }

    @ReactMethod
    public void Init(String action, Callback onSuccess, Callback onFail) {
      this.onSuccess = onSuccess;
      this.onFail = onFail;
//      Locale locale;
//
//      if(action.equals("RECOVER")){
//        locale = new Locale("en");
//      }else{
//        locale = new Locale("fr");
//      }
//      Configuration config = new Configuration(reactContext.getResources().getConfiguration());
//      config.setLocale(locale);
//
//      reactContext.getBaseContext().getResources().updateConfiguration(config,
//      reactContext.getBaseContext().getResources().getDisplayMetrics());
//
//      Log.i("Init", "Init local = " + reactContext.getResources().getConfiguration().locale.getLanguage());
//      Log.i("Init", "Init string = " + reactContext.getResources().getString(R.string.zoom_instructions_header_ready));
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
                        if(successful){
                          params.putBoolean("successful", true);
                          onSuccess.invoke(params);
                        }
                        else{
                          onFail.invoke(params);
                          params.putBoolean("successful", false);
                        }
                        //emitDeviceEvent("initialize", params);
                    }
                }
        );
    }

    @ReactMethod
    public void Enroll(String id, Callback onSuccess, Callback onFail) {
        this.onSuccess = onSuccess;
        this.onFail = onFail;
        latestProcessor = new EnrollmentProcessor(id, getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
    }

    @ReactMethod
    public void AuthenticateUser(String id, Callback onSuccess, Callback onFail) {
        this.onSuccess = onSuccess;
        this.onFail = onFail;
        latestProcessor  = new AuthenticateProcessor(id, getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
    }

    @ReactMethod
    public void LivenessCheck(Callback onSuccess, Callback onFail) {
        this.onSuccess = onSuccess;
        this.onFail = onFail;
        latestProcessor = new LivenessCheckProcessor( getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
    }

  @ReactMethod
  public void CheckId(Callback onSuccess, Callback onFail) {
    this.onSuccess = onSuccess;
    this.onFail = onFail;
    latestProcessor = new PhotoIDMatchProcessor( getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
  }

    Processor.SessionTokenErrorCallback sessionTokenErrorCallback = new Processor.SessionTokenErrorCallback() {
        @Override
        public void onError(String msg) {
            onFail.invoke(msg);
        }
    };

    Processor.SessionTokenSuccessCallback sessionTokenSuccessCallback = new Processor.SessionTokenSuccessCallback() {
        @Override
        public void onSuccess(String msg) {
            onSuccess.invoke(msg);
        }
    };
}
