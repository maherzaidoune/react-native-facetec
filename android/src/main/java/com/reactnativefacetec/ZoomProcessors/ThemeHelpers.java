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

       int primaryColor = Color.parseColor("#1797E3"); // white
       int backgroundColor = Color.parseColor("#FFFFFF"); // navy
       int numio = Color.parseColor("#42C560");
       int buttonText = Color.parseColor("#414141");
       int[] retryScreenSlideshowImages = new int[]{R.drawable.zoom_ideal_1, R.drawable.zoom_ideal_2, R.drawable.zoom_ideal_3, R.drawable.zoom_ideal_4, R.drawable.zoom_ideal_5};

       // Overlay Customization
       currentLowLightCustomization.getOverlayCustomization().backgroundColor = backgroundColor;
       currentLowLightCustomization.getOverlayCustomization().showBrandingImage = true;
       currentLowLightCustomization.getOverlayCustomization().brandingImage = R.color.zoom_hint_white;
       // Guidance Customization
       currentLowLightCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
       currentLowLightCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
       currentLowLightCustomization.getGuidanceCustomization().headerFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
       currentLowLightCustomization.getGuidanceCustomization().headerTextSize = 24;
       currentLowLightCustomization.getGuidanceCustomization().headerTextSpacing = 0.05f;
       currentLowLightCustomization.getGuidanceCustomization().subtextFont = ResourcesCompat.getFont(context, R.font.nunito_regular);
       currentLowLightCustomization.getGuidanceCustomization().subtextTextSize = 14;
       currentLowLightCustomization.getGuidanceCustomization().subtextTextSpacing = 0f;
       currentLowLightCustomization.getGuidanceCustomization().buttonFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
       currentLowLightCustomization.getGuidanceCustomization().buttonTextSize = 16;
       currentLowLightCustomization.getGuidanceCustomization().buttonTextSpacing = 0.05f;
       currentLowLightCustomization.getGuidanceCustomization().buttonTextNormalColor = buttonText;
       currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = numio;
       currentLowLightCustomization.getGuidanceCustomization().buttonTextHighlightColor = buttonText;
       currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
       currentLowLightCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#4D1D174F");
       currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = numio;
       currentLowLightCustomization.getGuidanceCustomization().buttonBorderColor = numio;
       currentLowLightCustomization.getGuidanceCustomization().buttonCornerRadius = 30;

       currentLowLightCustomization.getGuidanceCustomization().buttonBorderWidth = 1;
//            currentLowLightCustomization.getGuidanceCustomization().buttonCornerRadius = 2;
       currentLowLightCustomization.getGuidanceCustomization().buttonRelativeWidth = 1.0f;
       currentLowLightCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DFFFFFF");
       currentLowLightCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
       currentLowLightCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 2;
       currentLowLightCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = numio;

       currentLowLightCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
       currentLowLightCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
       currentLowLightCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 2;
       currentLowLightCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
       currentLowLightCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
       currentLowLightCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
       currentLowLightCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = false;
       currentLowLightCustomization.getGuidanceCustomization().enableRetryScreenBulletedInstructions = false;
       currentLowLightCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_white_navy;
       // ID Scan Customization
       currentLowLightCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
       currentLowLightCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
       currentLowLightCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
       currentLowLightCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
       currentLowLightCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
       currentLowLightCustomization.getIdScanCustomization().headerFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
       currentLowLightCustomization.getIdScanCustomization().headerTextSize = 24;
       currentLowLightCustomization.getIdScanCustomization().headerTextSpacing = 0.05f;
       currentLowLightCustomization.getIdScanCustomization().subtextFont = ResourcesCompat.getFont(context, R.font.nunito_regular);
       currentLowLightCustomization.getIdScanCustomization().subtextTextSize = 14;
       currentLowLightCustomization.getIdScanCustomization().subtextTextSpacing = 0f;
       currentLowLightCustomization.getIdScanCustomization().buttonFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
       currentLowLightCustomization.getIdScanCustomization().buttonTextSize = 20;
       currentLowLightCustomization.getIdScanCustomization().buttonTextSpacing = 0.05f;
       currentLowLightCustomization.getIdScanCustomization().buttonTextNormalColor = buttonText;
       currentLowLightCustomization.getIdScanCustomization().buttonBackgroundNormalColor = numio;
       currentLowLightCustomization.getIdScanCustomization().buttonTextHighlightColor = buttonText;
       currentLowLightCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
       currentLowLightCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = numio;
       currentLowLightCustomization.getIdScanCustomization().buttonBorderColor = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().buttonBorderWidth = 1;
       currentLowLightCustomization.getIdScanCustomization().buttonCornerRadius = 30;
       currentLowLightCustomization.getIdScanCustomization().buttonRelativeWidth = 1.0f;
       currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
       currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
       currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 2;
       currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
       currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
       currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 2;
       currentLowLightCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
       currentLowLightCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
       currentLowLightCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
       currentLowLightCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
       currentLowLightCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_white;
       currentLowLightCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_white;

       // Result Screen Customization
       currentLowLightCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
       currentLowLightCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
       currentLowLightCustomization.getResultScreenCustomization().messageFont  = ResourcesCompat.getFont(context, R.font.nunito_bold);
       currentLowLightCustomization.getResultScreenCustomization().messageTextSize = 18;
       currentLowLightCustomization.getResultScreenCustomization().messageTextSpacing = 0.05f;
       currentLowLightCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
       currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_white;
       currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1000;
       currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
       currentLowLightCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = backgroundColor;
       currentLowLightCustomization.getResultScreenCustomization().resultAnimationForegroundColor = primaryColor;
       currentLowLightCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = R.drawable.reticle_white;
       currentLowLightCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = R.drawable.reticle_white;
       currentLowLightCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
       currentLowLightCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
       currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
       currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
       currentLowLightCustomization.getResultScreenCustomization().showUploadProgressBar = true;
       currentLowLightCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33FFFFFF");
       currentLowLightCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
       currentLowLightCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
       // Feedback Customization
       currentLowLightCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
       currentLowLightCustomization.getFeedbackCustomization().textColor = backgroundColor;
       currentLowLightCustomization.getFeedbackCustomization().textFont = ResourcesCompat.getFont(context, R.font.nunito_bold);
       currentLowLightCustomization.getFeedbackCustomization().textSize = 18;
       currentLowLightCustomization.getFeedbackCustomization().textSpacing = 0.05f;
       currentLowLightCustomization.getFeedbackCustomization().cornerRadius = 2;
       currentLowLightCustomization.getFeedbackCustomization().elevation = 0;
       currentLowLightCustomization.getFeedbackCustomization().relativeWidth = 1.0f;
       // Frame Customization
       currentLowLightCustomization.getFrameCustomization().backgroundColor = backgroundColor;
       currentLowLightCustomization.getFrameCustomization().borderColor = numio;
       currentLowLightCustomization.getFrameCustomization().borderWidth = 0;
       currentLowLightCustomization.getFrameCustomization().cornerRadius = 0;
       currentLowLightCustomization.getFrameCustomization().elevation = 0;
       // Oval Customization
       currentLowLightCustomization.getOvalCustomization().strokeColor = primaryColor;
       currentLowLightCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BFFFFFFF");
       currentLowLightCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BFFFFFFF");
       // Cancel Button Customization
       currentLowLightCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_navy;
       currentLowLightCustomization.getCancelButtonCustomization().setLocation(ZoomCancelButtonCustomization.ButtonLocation.TOP_LEFT);

            currentLowLightCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_navy;

        return currentLowLightCustomization;
    }
}
