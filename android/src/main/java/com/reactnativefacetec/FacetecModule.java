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
import com.facetec.sdk.FaceTecSDK;
import com.reactnativefacetec.ZoomProcessors.AuthenticateProcessor;
import com.reactnativefacetec.ZoomProcessors.EnrollmentProcessor;
import com.reactnativefacetec.ZoomProcessors.LivenessCheckProcessor;
import com.reactnativefacetec.ZoomProcessors.NetworkingHelpers;
import com.reactnativefacetec.ZoomProcessors.PhotoIDMatchProcessor;
import com.reactnativefacetec.ZoomProcessors.Processor;
import com.reactnativefacetec.ZoomProcessors.ThemeHelpers;
import com.reactnativefacetec.ZoomProcessors.ZoomGlobalState;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import okhttp3.Call;

public class FacetecModule extends ReactContextBaseJavaModule {
  public static final String REACT_CLASS = "Facetec";
  private static ReactApplicationContext reactContext = null;
  public Processor latestProcessor;
  String sesstionToken;

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

    FaceTecSDK.initializeInProductionMode(
      reactContext,
      ZoomGlobalState.ProductionKeyText,
      ZoomGlobalState.DeviceLicenseKeyIdentifier,
      ZoomGlobalState.PublicFaceMapEncryptionKey, new FaceTecSDK.InitializeCallback() {
        @Override
        public void onCompletion(boolean b) {
          WritableMap params = Arguments.createMap();
          try{
            params.putString("initState", b+"");
          }catch (Exception e){
            e.printStackTrace();
          }
          if(b){
            params.putBoolean("successful", true);
            onSuccess.invoke(params);
          }
          else{
            onFail.invoke(params);
            params.putBoolean("successful", false);
          }
        }
      }
    );
  }

  @ReactMethod
  public void Enroll(String id, Callback onSuccess, Callback onFail) {
    okhttp3.Request request = new okhttp3.Request.Builder()
      .header("X-Device-Key", ZoomGlobalState.DeviceLicenseKeyIdentifier)
      .url(ZoomGlobalState.ZoomServerBaseURL + "/session-token")
      .get()
      .build();

    NetworkingHelpers.getApiClient().newCall(request).enqueue(new okhttp3.Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
        Log.d("FaceTecSDKSampleApp", "Exception raised while attempting HTTPS call.");
        // If this comes from HTTPS cancel call, don't set the sub code to NETWORK_ERROR.
        if(!e.getMessage().equals(NetworkingHelpers.OK_HTTP_RESPONSE_CANCELED)) {
          onFail.invoke("Exception raised while attempting HTTPS call");
        }
      }

      @Override
      public void onResponse(Call call, okhttp3.Response response) throws IOException {
        String responseString = response.body().string();
        response.body().close();
        try {
          JSONObject responseJSON = new JSONObject(responseString);
          if(responseJSON.has("sessionToken")) {
            sesstionToken = responseJSON.getString("sessionToken");
            latestProcessor = new EnrollmentProcessor(id, responseJSON.getString("sessionToken"), getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
          }
          else {
            onFail.invoke("sessionToken invalid");
          }
        }
        catch(JSONException e) {
          e.printStackTrace();
          Log.d("FaceTecSDKSampleApp", "Exception raised while attempting to parse JSON result.");
          onFail.invoke("Exception raised while attempting to parse JSON result.");
        }
      }
    });
    this.onSuccess = onSuccess;
    this.onFail = onFail;
  }

  @ReactMethod
  public void AuthenticateUser(String id, Callback onSuccess, Callback onFail) {
    this.onSuccess = onSuccess;
    this.onFail = onFail;

    okhttp3.Request request = new okhttp3.Request.Builder()
            .header("X-Device-Key", ZoomGlobalState.DeviceLicenseKeyIdentifier)
            .url(ZoomGlobalState.ZoomServerBaseURL + "/session-token")
            .get()
            .build();

    NetworkingHelpers.getApiClient().newCall(request).enqueue(new okhttp3.Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
        Log.d("FaceTecSDKSampleApp", "Exception raised while attempting HTTPS call.");
        // If this comes from HTTPS cancel call, don't set the sub code to NETWORK_ERROR.
        if(!e.getMessage().equals(NetworkingHelpers.OK_HTTP_RESPONSE_CANCELED)) {
          onFail.invoke("Exception raised while attempting HTTPS call");
        }
      }

      @Override
      public void onResponse(Call call, okhttp3.Response response) throws IOException {
        String responseString = response.body().string();
        response.body().close();
        try {
          JSONObject responseJSON = new JSONObject(responseString);
          if(responseJSON.has("sessionToken")) {
            sesstionToken = responseJSON.getString("sessionToken");
            latestProcessor  = new AuthenticateProcessor( sesstionToken, id, getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
          }
          else {
            onFail.invoke("sessionToken invalid");
          }
        }
        catch(JSONException e) {
          e.printStackTrace();
          Log.d("FaceTecSDKSampleApp", "Exception raised while attempting to parse JSON result.");
          onFail.invoke("Exception raised while attempting to parse JSON result.");
        }
      }
    });
  }

  @ReactMethod
  public void LivenessCheck(Callback onSuccess, Callback onFail) {
    this.onSuccess = onSuccess;
    this.onFail = onFail;
    latestProcessor = new LivenessCheckProcessor(sesstionToken,getCurrentActivity());
  }

  @ReactMethod
  public void CheckId(String id, Callback onSuccess, Callback onFail) {
    this.onSuccess = onSuccess;
    this.onFail = onFail;
    okhttp3.Request request = new okhttp3.Request.Builder()
            .header("X-Device-Key", ZoomGlobalState.DeviceLicenseKeyIdentifier)
            .url(ZoomGlobalState.ZoomServerBaseURL + "/session-token")
            .get()
            .build();

    NetworkingHelpers.getApiClient().newCall(request).enqueue(new okhttp3.Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
        Log.d("FaceTecSDKSampleApp", "Exception raised while attempting HTTPS call.");
        // If this comes from HTTPS cancel call, don't set the sub code to NETWORK_ERROR.
        if(!e.getMessage().equals(NetworkingHelpers.OK_HTTP_RESPONSE_CANCELED)) {
          onFail.invoke("Exception raised while attempting HTTPS call");
        }
      }

      @Override
      public void onResponse(Call call, okhttp3.Response response) throws IOException {
        String responseString = response.body().string();
        response.body().close();
        try {
          JSONObject responseJSON = new JSONObject(responseString);
          if(responseJSON.has("sessionToken")) {
            sesstionToken = responseJSON.getString("sessionToken");
            latestProcessor = new PhotoIDMatchProcessor(id, sesstionToken,  getCurrentActivity(), sessionTokenErrorCallback, sessionTokenSuccessCallback);
          }
          else {
            onFail.invoke("sessionToken invalid");
          }
        }
        catch(JSONException e) {
          e.printStackTrace();
          Log.d("FaceTecSDKSampleApp", "Exception raised while attempting to parse JSON result.");
          onFail.invoke("Exception raised while attempting to parse JSON result.");
        }
      }
    });
  }

  Processor.SessionTokenErrorCallback sessionTokenErrorCallback = new Processor.SessionTokenErrorCallback() {
    @Override
    public void onError(String msg) {
//      try{
//        onFail.invoke(msg);
//      }catch (Exception e){
//        e.printStackTrace();
//      }
    }
  };

  Processor.SessionTokenSuccessCallback sessionTokenSuccessCallback = new Processor.SessionTokenSuccessCallback() {
    @Override
    public void onSuccess(String msg) {
      onSuccess.invoke(msg);
    }
  };
}
