package com.reactnativefacetec.ZoomProcessors;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

import com.facetec.zoom.sdk.ZoomCancelButtonCustomization;
import com.facetec.zoom.sdk.ZoomCustomization;
import com.facetec.zoom.sdk.ZoomGuidanceCustomization;
import com.facetec.zoom.sdk.ZoomSDK;
import com.reactnativefacetec.R;

public class ThemeHelpers {
  Context context;
  public ThemeHelpers(Context context) {
    this.context = context;
  }

  public void setAppTheme(String theme) {
        ZoomGlobalState.currentCustomization = getCustomizationForTheme(theme);
        ZoomCustomization currentLowLightCustomization = getLowLightCustomizationForTheme(theme);

        ZoomSDK.setCustomization(ZoomGlobalState.currentCustomization);
        ZoomSDK.setLowLightCustomization(currentLowLightCustomization);
    }

    public ZoomCustomization getCustomizationForTheme(String theme) {
        ZoomCustomization currentCustomization = new ZoomCustomization();

        int[] retryScreenSlideshowImages = new int[]{R.drawable.zoom_ideal_1, R.drawable.zoom_ideal_2, R.drawable.zoom_ideal_3, R.drawable.zoom_ideal_4, R.drawable.zoom_ideal_5};

            int primaryColor = Color.parseColor("#1797E3"); // white
            int backgroundColor = Color.parseColor("#FFFFFF"); // navy
            int numio = Color.parseColor("#42C560");
            int buttonText = Color.parseColor("#414141");

      // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = backgroundColor;
            currentCustomization.getOverlayCustomization().showBrandingImage = true;
            currentCustomization.getOverlayCustomization().brandingImage = R.color.zoom_hint_white;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
            currentCustomization.getGuidanceCustomization().headerTextSize = 24;
            currentCustomization.getGuidanceCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().subtextFont = ResourcesCompat.getFont(context, R.font.nunito_regular);
            currentCustomization.getGuidanceCustomization().subtextTextSize = 14;
            currentCustomization.getGuidanceCustomization().subtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().buttonFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
            currentCustomization.getGuidanceCustomization().buttonTextSize = 16;
            currentCustomization.getGuidanceCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = buttonText;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = numio;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = buttonText;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#4D1D174F");
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = numio;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = numio;
          currentCustomization.getGuidanceCustomization().buttonCornerRadius = 30;

          currentCustomization.getGuidanceCustomization().buttonBorderWidth = 1;
//            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 2;
            currentCustomization.getGuidanceCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DFFFFFF");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = numio;

          currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 2;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = false;
            currentCustomization.getGuidanceCustomization().enableRetryScreenBulletedInstructions = false;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_white_navy;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentCustomization.getIdScanCustomization().headerFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
            currentCustomization.getIdScanCustomization().headerTextSize = 24;
            currentCustomization.getIdScanCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().subtextFont = ResourcesCompat.getFont(context, R.font.nunito_regular);
            currentCustomization.getIdScanCustomization().subtextTextSize = 14;
            currentCustomization.getIdScanCustomization().subtextTextSpacing = 0f;
            currentCustomization.getIdScanCustomization().buttonFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
            currentCustomization.getIdScanCustomization().buttonTextSize = 20;
            currentCustomization.getIdScanCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = buttonText;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = numio;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = buttonText;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = numio;
            currentCustomization.getIdScanCustomization().buttonBorderColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 1;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 30;
            currentCustomization.getIdScanCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
           currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_white;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_white;

      // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = ResourcesCompat.getFont(context, R.font.nunito_bold);
            currentCustomization.getResultScreenCustomization().messageTextSize = 18;
            currentCustomization.getResultScreenCustomization().messageTextSpacing = 0.05f;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_white;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1000;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = R.drawable.reticle_white;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = R.drawable.reticle_white;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = true;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33FFFFFF");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
            currentCustomization.getFeedbackCustomization().textSize = 18;
            currentCustomization.getFeedbackCustomization().textSpacing = 0.05f;
            currentCustomization.getFeedbackCustomization().cornerRadius = 2;
            currentCustomization.getFeedbackCustomization().elevation = 0;
            currentCustomization.getFeedbackCustomization().relativeWidth = 1.0f;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = numio;
            currentCustomization.getFrameCustomization().borderWidth = 0;
            currentCustomization.getFrameCustomization().cornerRadius = 0;
            currentCustomization.getFrameCustomization().elevation = 0;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BFFFFFFF");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BFFFFFFF");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_navy;
            currentCustomization.getCancelButtonCustomization().setLocation(ZoomCancelButtonCustomization.ButtonLocation.TOP_LEFT);
        return currentCustomization;
    }

     ZoomCustomization getLowLightCustomizationForTheme(String theme) {
        ZoomCustomization currentLowLightCustomization = getCustomizationForTheme(theme);

        int[] retryScreenSlideshowImages = new int[]{R.drawable.zoom_ideal_1, R.drawable.zoom_ideal_2, R.drawable.zoom_ideal_3, R.drawable.zoom_ideal_4, R.drawable.zoom_ideal_5};

            int primaryColor = Color.WHITE;
            int backgroundColor = Color.WHITE; // navy
            int numio = Color.parseColor("#42C560"); // navy

            // Overlay Customization
            currentLowLightCustomization.getOverlayCustomization().brandingImage = R.drawable.sample_bank_logo;
            // Guidance Customization
            currentLowLightCustomization.getGuidanceCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextNormalColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextHighlightColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BF1D174F");
            currentLowLightCustomization.getGuidanceCustomization().buttonTextDisabledColor = numio;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBorderColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4D1D174F");
            currentLowLightCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = numio;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenImageBorderColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            // ID Scan Customization
            currentLowLightCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentLowLightCustomization.getIdScanCustomization().captureScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().selectionScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextNormalColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundNormalColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextHighlightColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BF1D174F");
            currentLowLightCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.parseColor("#4DFFFFFF");
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBorderColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_navy;
            currentLowLightCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_navy;
            // Result Screen Customization
            currentLowLightCustomization.getResultScreenCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().activityIndicatorColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_navy;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = R.drawable.reticle_navy;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = R.drawable.reticle_navy;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressFillColor = backgroundColor;
            // Feedback Customization
            currentLowLightCustomization.getFeedbackCustomization().backgroundColors = backgroundColor;
            currentLowLightCustomization.getFeedbackCustomization().textColor = primaryColor;
            // Frame Customization
            currentLowLightCustomization.getFrameCustomization().borderColor = backgroundColor;
            // Oval Customization
            currentLowLightCustomization.getOvalCustomization().strokeColor = backgroundColor;
            currentLowLightCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BF1D174F");
            currentLowLightCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BF1D174F");
            // Cancel Button Customization
            currentLowLightCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_navy;

        return currentLowLightCustomization;
    }
}
