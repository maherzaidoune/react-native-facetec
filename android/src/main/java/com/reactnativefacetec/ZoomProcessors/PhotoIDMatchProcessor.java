// Demonstrates performing a ZoOm Session, proving Liveness, then scanning the ID and performing a Photo ID Match

// The FaceTec Device SDKs will cancel from the Progress Screen if onProgress() is not called for
// 60 seconds. This provides a failsafe for users getting stuck in the process because of a networking
// issue. If you would like to force users to stay on the Progress Screen for longer than 60 seconds,
// you can write code in the FaceMap or ID Scan Processor to call onProgress() via your own custom logic.
package com.reactnativefacetec.ZoomProcessors;

import android.content.Context;

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

import org.json.JSONObject;

import static java.util.UUID.randomUUID;

public class PhotoIDMatchProcessor extends Processor implements ZoomFaceMapProcessor, ZoomIDScanProcessor {
    ZoomFaceMapResultCallback zoomFaceMapResultCallback;
    ZoomSessionResult latestZoomSessionResult;

    ZoomIDScanResultCallback zoomIDScanResultCallback;
    ZoomIDScanResult latestZoomIDScanResult;
    private boolean _isSuccess = false;

    public PhotoIDMatchProcessor(final Context context, final SessionTokenErrorCallback sessionTokenErrorCallback) {
        // For demonstration purposes, generate a new uuid for each Photo ID Match.  Enroll this in the DB and compare against the ID after it is scanned.
        ZoomGlobalState.randomUsername = "android_sample_app_" + randomUUID();
        ZoomGlobalState.isRandomUsernameEnrolled = false;

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

        // Cancel last request in flight.  This handles case where processing is is taking place but cancellation or Context Switch occurs.
        // Our handling here ends the latest in flight request and simply re-does the normal logic, which will cancel out.
        NetworkingHelpers.cancelPendingRequests();

        // cancellation, timeout, etc.
        if(zoomIDScanResult.getZoomIDScanStatus() != ZoomIDScanStatus.SUCCESS) {
            zoomIDScanResultCallback.cancel();
            this.zoomIDScanResultCallback = null;
            return;
        }

        if(zoomIDScanResult.getIDScanMetrics() == null) {
            zoomIDScanResultCallback.cancel();
            this.zoomIDScanResultCallback = null;
            return;
        }

        if(zoomIDScanResult.getIDScanMetrics().getIDScan() == null) {
            zoomIDScanResultCallback.cancel();
            this.zoomIDScanResultCallback = null;
            return;
        }

        // Create and parse request to ZoOm Server.
        NetworkingHelpers.getPhotoIDMatchResponseFromZoomServer(zoomIDScanResult, zoomIDScanResultCallback, new FaceTecManagedAPICallback() {
            @Override
            public void onResponse(JSONObject responseJSON) {
                IDScanUXNextStep nextStep = ServerResultHelpers.getPhotoIDMatchNextStep(responseJSON);
                if (nextStep == IDScanUXNextStep.Succeed) {
                    _isSuccess = true;
                    // Dynamically set the success message.
                    ZoomCustomization.overrideResultScreenSuccessMessage = "Your 3D Face\nMatched Your ID";
                    zoomIDScanResultCallback.succeed();
                }
                else if (nextStep == IDScanUXNextStep.Retry) {
                    zoomIDScanResultCallback.retry(ZoomIDScanRetryMode.FRONT);
                }
                else if (nextStep == IDScanUXNextStep.RetryInvalidId) {
                    zoomIDScanResultCallback.retry(ZoomIDScanRetryMode.FRONT, "Photo ID\nNot Fully Visible");
                }
                else {
                    zoomIDScanResultCallback.cancel();
                }
            }
        });
    }
}
