// Demonstrates performing a ZoOm Session, proving Liveness, then scanning the ID and performing a Photo ID Match

// The FaceTec Device SDKs will cancel from the Progress Screen if onProgress() is not called for
// 60 seconds. This provides a failsafe for users getting stuck in the process because of a networking
// issue. If you would like to force users to stay on the Progress Screen for longer than 60 seconds,
// you can write code in the FaceMap or ID Scan Processor to call onProgress() via your own custom logic.
package com.reactnativefacetec.ZoomProcessors;

import android.content.Context;
import android.util.Log;

import com.facetec.zoom.sdk.ZoomCustomization;
import com.facetec.zoom.sdk.ZoomFaceMapProcessor;
import com.facetec.zoom.sdk.ZoomFaceMapResultCallback;
import com.facetec.zoom.sdk.ZoomIDScanProcessor;
import com.facetec.zoom.sdk.ZoomIDScanResult;
import com.facetec.zoom.sdk.ZoomIDScanResultCallback;
import com.facetec.zoom.sdk.ZoomIDScanRetryMode;
import com.facetec.zoom.sdk.ZoomIDScanStatus;
import com.facetec.zoom.sdk.ZoomSessionActivity;
import com.facetec.zoom.sdk.ZoomSessionResult;
import com.facetec.zoom.sdk.ZoomSessionStatus;

import org.json.JSONException;
import org.json.JSONObject;

import static java.util.UUID.randomUUID;

public class PhotoIDMatchProcessor extends Processor implements ZoomFaceMapProcessor, ZoomIDScanProcessor {
    ZoomFaceMapResultCallback zoomFaceMapResultCallback;
    ZoomSessionResult latestZoomSessionResult;

    ZoomIDScanResultCallback zoomIDScanResultCallback;
    ZoomIDScanResult latestZoomIDScanResult;
    private boolean _isSuccess = false;
    SessionTokenSuccessCallback sessionTokenSuccessCallback;
    SessionTokenErrorCallback sessionTokenErrorCallback;
    String id;


  public PhotoIDMatchProcessor(String id, final Context context, final SessionTokenErrorCallback sessionTokenErrorCallback, SessionTokenSuccessCallback sessionTokenSuccessCallback) {
        // For demonstration purposes, generate a new uuid for each Photo ID Match.  Enroll this in the DB and compare against the ID after it is scanned.
        ZoomGlobalState.randomUsername = "android_sample_app_" + randomUUID();
        ZoomGlobalState.isRandomUsernameEnrolled = false;
        this.sessionTokenSuccessCallback = sessionTokenSuccessCallback;
        this.sessionTokenErrorCallback = sessionTokenErrorCallback;
        this.id = id;

        NetworkingHelpers.getSessionToken(new NetworkingHelpers.SessionTokenCallback() {
            @Override
            public void onResponse(String sessionToken) {
                // Launch the ZoOm Session.
                ZoomSessionActivity.createAndLaunchZoomSession(context, PhotoIDMatchProcessor.this, PhotoIDMatchProcessor.this, sessionToken);
            }

            @Override
            public void onError() {
                sessionTokenErrorCallback.onError("PhotoIDMatchProcessor");
            }
        });
    }

    public boolean isSuccess() {
        return _isSuccess;
    }

    // Required function that handles calling ZoOm Server to get result and decides how to continue.
    public void processZoomSessionResultWhileZoomWaits(final ZoomSessionResult zoomSessionResult, final ZoomFaceMapResultCallback zoomFaceMapResultCallback) {
        this.latestZoomSessionResult = zoomSessionResult;
        this.zoomFaceMapResultCallback = zoomFaceMapResultCallback;

        // Cancel last request in flight.  This handles case where processing is is taking place but cancellation or Context Switch occurs.
        // Our handling here ends the latest in flight request and simply re-does the normal logic, which will cancel out.
        NetworkingHelpers.cancelPendingRequests();

        // cancellation, timeout, etc.
        if (zoomSessionResult.getStatus() != ZoomSessionStatus.SESSION_COMPLETED_SUCCESSFULLY) {
            zoomFaceMapResultCallback.cancel();
            this.zoomFaceMapResultCallback = null;
            return;
        }

        // Create and parse request to ZoOm Server.  Note here that for Photo ID Match, onFaceMapResultSucceed sends you to the next phase (ID Scan) rather than completing.
        NetworkingHelpers.getEnrollmentResponseFromZoomServer(zoomSessionResult, this.zoomFaceMapResultCallback, new FaceTecManagedAPICallback() {
            @Override
            public void onResponse(JSONObject responseJSON) {
                UXNextStep nextStep = ServerResultHelpers.getEnrollmentNextStep(responseJSON);
                if (nextStep == UXNextStep.Succeed) {
                    // Dynamically set the success message.
                    ZoomCustomization.overrideResultScreenSuccessMessage = "Liveness\nConfirmed";
                    zoomFaceMapResultCallback.succeed();
                }
                else if (nextStep == UXNextStep.Retry) {
                    zoomFaceMapResultCallback.retry();
                }
                else {
                    zoomFaceMapResultCallback.cancel();
                }
            }
        });

    }

    // Required function that handles calling ZoOm Server to get result and decides how to continue.
    public void processZoomIDScanResultWhileZoomWaits(ZoomIDScanResult zoomIDScanResult, final ZoomIDScanResultCallback zoomIDScanResultCallback) {
        this.latestZoomIDScanResult = zoomIDScanResult;
        this.zoomIDScanResultCallback = zoomIDScanResultCallback;

        Log.i("PhotoIDMatchProcessor", "zoomIDScanResult == zoomIDScanResult Not " + zoomIDScanResult);
      // Cancel last request in flight.  This handles case where processing is is taking place but cancellation or Context Switch occurs.
        // Our handling here ends the latest in flight request and simply re-does the normal logic, which will cancel out.
        NetworkingHelpers.cancelPendingRequests();

        // cancellation, timeout, etc.
        if(zoomIDScanResult.getZoomIDScanStatus() != ZoomIDScanStatus.SUCCESS) {
          Log.i("PhotoIDMatchProcessor", "PhotoIDMatchProcessor == Not suceess");
            zoomIDScanResultCallback.cancel();
            this.zoomIDScanResultCallback = null;
            return;
        }

        if(zoomIDScanResult.getIDScanMetrics() == null) {
          Log.i("PhotoIDMatchProcessor", "PhotoIDMatchProcessor metrics == Null");
          zoomIDScanResultCallback.cancel();
            this.zoomIDScanResultCallback = null;
            return;
        }

        if(zoomIDScanResult.getIDScanMetrics().getIDScan() == null) {
          Log.i("PhotoIDMatchProcessor", "PhotoIDMatchProcessor id == Null");
          zoomIDScanResultCallback.cancel();
            this.zoomIDScanResultCallback = null;
            return;
        }

        // Create and parse request to ZoOm Server.
        NetworkingHelpers.getPhotoIDMatchResponseFromZoomServer(id, zoomIDScanResult, zoomIDScanResultCallback, new FaceTecManagedAPICallback() {
            @Override
            public void onResponse(JSONObject responseJSON) {
              Log.i("PhotoIDMatchProcessor", "PhotoIDMatchProcessor == responseJSON Not " + responseJSON.toString());

              IDScanUXNextStep nextStep = ServerResultHelpers.getPhotoIDMatchNextStep(responseJSON);
                if (nextStep == IDScanUXNextStep.Succeed) {
                    _isSuccess = true;
                    // Dynamically set the success message.
                    ZoomCustomization.overrideResultScreenSuccessMessage = "Your 3D Face\nMatched Your ID";
                    zoomIDScanResultCallback.succeed();
                  Log.i("PhotoIDMatchProcessor", "PhotoIDMatchProcessor == success " + responseJSON.toString());
                  JSONObject obj = new JSONObject();
                  try {

                    obj.put("responseJSON", responseJSON.getJSONObject("data").toString());
                    obj.put("FrontImagesCompressedBase64", zoomIDScanResult.getIDScanMetrics().getFrontImagesCompressedBase64().get(0));
                    if(zoomIDScanResult.getIDScanMetrics().getBackImagesCompressedBase64() != null && zoomIDScanResult.getIDScanMetrics().getBackImagesCompressedBase64().size() > 0){
                        obj.put("BackImagesCompressedBase64", zoomIDScanResult.getIDScanMetrics().getBackImagesCompressedBase64().get(0));
                    }


                    sessionTokenSuccessCallback.onSuccess(obj.toString());
                  } catch (JSONException e) {
                      sessionTokenSuccessCallback.onSuccess(responseJSON.toString());
                      try{
                        obj.put("responseJSON", responseJSON.toString());
                        if(zoomIDScanResult.getIDScanMetrics().getFrontImagesCompressedBase64() != null && zoomIDScanResult.getIDScanMetrics().getFrontImagesCompressedBase64().size() > 0){
                            obj.put("FrontImagesCompressedBase64", zoomIDScanResult.getIDScanMetrics().getFrontImagesCompressedBase64().get(0));
                        }
                          if(zoomIDScanResult.getIDScanMetrics().getBackImagesCompressedBase64() != null && zoomIDScanResult.getIDScanMetrics().getBackImagesCompressedBase64().size() > 0){
                              obj.put("BackImagesCompressedBase64", zoomIDScanResult.getIDScanMetrics().getBackImagesCompressedBase64().get(0));
                          }

                      }catch (Exception e1){
                        e1.printStackTrace();
                      }
                      e.printStackTrace();
                    }
                }
                else if (nextStep == IDScanUXNextStep.Retry) {
//                  sessionTokenErrorCallback.onError(responseJSON.toString());
                  zoomIDScanResultCallback.retry(ZoomIDScanRetryMode.FRONT);
                }
                else if (nextStep == IDScanUXNextStep.RetryInvalidId) {
//                  sessionTokenErrorCallback.onError(responseJSON.toString());
                  zoomIDScanResultCallback.retry(ZoomIDScanRetryMode.FRONT, "Photo ID\nNot Fully Visible");
                }
                else {
                  JSONObject obj = new JSONObject();
                    try{
                      obj.put("responseJSON", responseJSON.toString());
                      obj.put("FrontImagesCompressedBase64", zoomIDScanResult.getIDScanMetrics().getFrontImagesCompressedBase64());
                      obj.put("BackImagesCompressedBase64", zoomIDScanResult.getIDScanMetrics().getBackImagesCompressedBase64());
                      sessionTokenErrorCallback.onError(obj.toString());

                    }catch (Exception w){
                      w.printStackTrace();
                      sessionTokenErrorCallback.onError(responseJSON.toString());
                    }

                  zoomIDScanResultCallback.cancel();
                }
            }
        });
    }
}
