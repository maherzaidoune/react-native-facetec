package com.reactnativefacetec.ZoomProcessors;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;

import com.facetec.zoom.sdk.ZoomCancelButtonCustomization;
import com.facetec.zoom.sdk.ZoomCustomization;
import com.facetec.zoom.sdk.ZoomSDK;
import com.reactnativefacetec.R;

public class ThemeHelpers {

    public static void setAppTheme(String theme) {
        ZoomGlobalState.currentCustomization = getCustomizationForTheme(theme);
        ZoomCustomization currentLowLightCustomization = getLowLightCustomizationForTheme(theme);

        ZoomSDK.setCustomization(ZoomGlobalState.currentCustomization);
        ZoomSDK.setLowLightCustomization(currentLowLightCustomization);
    }

    public static ZoomCustomization getCustomizationForTheme(String theme) {
        ZoomCustomization currentCustomization = new ZoomCustomization();

        int[] retryScreenSlideshowImages = new int[]{R.drawable.zoom_ideal_1, R.drawable.zoom_ideal_2, R.drawable.zoom_ideal_3, R.drawable.zoom_ideal_4, R.drawable.zoom_ideal_5};

        if(theme.equals("FaceTec Theme")) {
            currentCustomization = new ZoomCustomization();
        }
        else if(theme.equals("Pseudo-Fullscreen")) {
            int primaryColor = Color.parseColor("#2B2B2B"); // black
            int secondaryColor = Color.parseColor("#3BC371"); // green
            int backgroundColor = Color.parseColor("#EEF6F8"); // white

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = backgroundColor;
            currentCustomization.getOverlayCustomization().showBrandingImage = false;
            currentCustomization.getOverlayCustomization().brandingImage = 0;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().headerTextSize = 26;
            currentCustomization.getGuidanceCustomization().headerTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().subtextTextSize = 14;
            currentCustomization.getGuidanceCustomization().subtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextSize = 20;
            currentCustomization.getGuidanceCustomization().buttonTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#565656");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 0;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 30;
            currentCustomization.getGuidanceCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#00EEF6F8");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 10;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 2000;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().enableRetryScreenBulletedInstructions = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_shutter_black;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = Color.parseColor("#565656");
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().headerTextSize = 26;
            currentCustomization.getIdScanCustomization().headerTextSpacing = 0;
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().subtextTextSize = 14;
            currentCustomization.getIdScanCustomization().subtextTextSpacing = 0f;
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextSize = 20;
            currentCustomization.getIdScanCustomization().buttonTextSpacing = 0f;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#565656");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 0;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 30;
            currentCustomization.getIdScanCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.zoom_active_torch;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.zoom_inactive_torch;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().messageTextSize = 20;
            currentCustomization.getResultScreenCustomization().messageTextSpacing = 0f;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 800;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.pseudo_fullscreen_animated_activity_indicator;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage =0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.pseudo_fullscreen_animated_success;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_animated_unsuccess;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.pseudo_fullscreen_static_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.pseudo_fullscreen_static_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = true;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#332B2B2B");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().textSize = 20;
            currentCustomization.getFeedbackCustomization().textSpacing = 0f;
            currentCustomization.getFeedbackCustomization().cornerRadius = 5;
            currentCustomization.getFeedbackCustomization().elevation = 10;
            currentCustomization.getFeedbackCustomization().relativeWidth = 1.0f;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 0;
            currentCustomization.getFrameCustomization().cornerRadius = 0;
            currentCustomization.getFrameCustomization().elevation = 0;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BF3BC371");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BF3BC371");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_black;
            currentCustomization.getCancelButtonCustomization().setLocation(ZoomCancelButtonCustomization.ButtonLocation.CUSTOM);
            currentCustomization.getCancelButtonCustomization().setCustomLocation(new Rect(20, 30, 25, 25));

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().readyScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextSize = 26;
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentCustomization.getGuidanceCustomization().readyScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextSize = 12;
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = Color.parseColor("#565656");
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().retryScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextSize = 26;
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentCustomization.getGuidanceCustomization().retryScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextSize = 14;
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = Color.parseColor("#565656");
        }
        else if(theme.equals("Well-Rounded")) {
            int primaryColor = Color.parseColor("#09B5A3"); // green
            int backgroundColor = Color.WHITE;

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = false;
            currentCustomization.getOverlayCustomization().brandingImage = 0;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().headerTextSize = 24;
            currentCustomization.getGuidanceCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().subtextTextSize = 14;
            currentCustomization.getGuidanceCustomization().subtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextSize = 20;
            currentCustomization.getGuidanceCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#31DDCC");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#D7D7D7");
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = Color.parseColor("#008D7B");
            currentCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 0;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 30;
            currentCustomization.getGuidanceCustomization().buttonRelativeWidth = 0.75f;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4D09B5A3");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 10;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = new int[0];
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().enableRetryScreenBulletedInstructions = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_green;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().headerTextSize = 24;
            currentCustomization.getIdScanCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().subtextTextSize = 14;
            currentCustomization.getIdScanCustomization().subtextTextSpacing = 0f;
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextSize = 20;
            currentCustomization.getIdScanCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#31DDCC");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.parseColor("#D7D7D7");
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = Color.parseColor("#008D7B");
            currentCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 0;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 30;
            currentCustomization.getIdScanCustomization().buttonRelativeWidth = 0.75f;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.zoom_active_torch;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.zoom_inactive_torch;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().messageTextSize = 18;
            currentCustomization.getResultScreenCustomization().messageTextSpacing = 0.05f;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1000;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.well_rounded_animated_activity_indicator;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.well_rounded_animated_success;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.well_rounded_animated_unsuccess;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.well_rounded_static_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.well_rounded_static_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = false;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 2.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().textSize = 18;
            currentCustomization.getFeedbackCustomization().textSpacing = 0.05f;
            currentCustomization.getFeedbackCustomization().cornerRadius = 5;
            currentCustomization.getFeedbackCustomization().elevation = 5;
            currentCustomization.getFeedbackCustomization().relativeWidth = 0.75f;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 20;
            currentCustomization.getFrameCustomization().elevation = 10;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = primaryColor;
            currentCustomization.getOvalCustomization().progressColor2 = primaryColor;
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_round_green;
            currentCustomization.getCancelButtonCustomization().setLocation(ZoomCancelButtonCustomization.ButtonLocation.TOP_LEFT);
        }
        else if(theme.equals("Bitcoin Exchange")) {
            int primaryColor = Color.parseColor("#F79634"); // orange
            int secondaryColor = Color.parseColor("#FFFF1E"); // yellow
            int backgroundColor = Color.parseColor("#424242"); // dark grey

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = true;
            currentCustomization.getOverlayCustomization().brandingImage = R.drawable.bitcoin_exchange_logo;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().headerTextSize = 24;
            currentCustomization.getGuidanceCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().subtextTextSize = 14;
            currentCustomization.getGuidanceCustomization().subtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextSize = 20;
            currentCustomization.getGuidanceCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 0;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DF79634");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 5;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = new int[0];
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().enableRetryScreenBulletedInstructions = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_orange;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().headerTextSize = 24;
            currentCustomization.getIdScanCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().subtextTextSize = 14;
            currentCustomization.getIdScanCustomization().subtextTextSpacing = 0f;
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextSize = 20;
            currentCustomization.getIdScanCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 0;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 5;
            currentCustomization.getIdScanCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 8;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 8;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_orange;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_orange;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().messageTextSize = 18;
            currentCustomization.getResultScreenCustomization().messageTextSpacing = 0.05f;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_orange;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1500;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = primaryColor;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = backgroundColor;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = true;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().textSize = 18;
            currentCustomization.getFeedbackCustomization().textSpacing = 0.05f;
            currentCustomization.getFeedbackCustomization().cornerRadius = 5;
            currentCustomization.getFeedbackCustomization().elevation = 10;
            currentCustomization.getFeedbackCustomization().relativeWidth = 1.0f;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 5;
            currentCustomization.getFrameCustomization().elevation = 10;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = secondaryColor;
            currentCustomization.getOvalCustomization().progressColor2 = secondaryColor;
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_orange;
            currentCustomization.getCancelButtonCustomization().setLocation(ZoomCancelButtonCustomization.ButtonLocation.TOP_LEFT);

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentCustomization.getGuidanceCustomization().readyScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextSize = 22;
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentCustomization.getGuidanceCustomization().readyScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextSize = 12;
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = secondaryColor;
            // Retry Screen Header
            currentCustomization.getGuidanceCustomization().retryScreenHeaderFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextSize = 22;
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentCustomization.getGuidanceCustomization().retryScreenSubtextFont = Typeface.create("sans-serif", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextSize = 12;
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = secondaryColor;

        }
        else if(theme.equals("eKYC")) {
            int primaryColor = Color.parseColor("#ED1C24"); // red
            int secondaryColor = Color.BLACK;
            int backgroundColor = Color.WHITE;

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = true;
            currentCustomization.getOverlayCustomization().brandingImage = R.drawable.ekyc_logo;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = secondaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().headerTextSize = 24;
            currentCustomization.getGuidanceCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().subtextTextSize = 14;
            currentCustomization.getGuidanceCustomization().subtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextSize = 20;
            currentCustomization.getGuidanceCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#4DED1C24");
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = Color.TRANSPARENT;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 8;
            currentCustomization.getGuidanceCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DED1C24");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 3;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenImageBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().retryScreenImageCornerRadius = 3;
            currentCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowImages = retryScreenSlideshowImages;
            currentCustomization.getGuidanceCustomization().retryScreenSlideshowInterval = 1500;
            currentCustomization.getGuidanceCustomization().enableRetryScreenSlideshowShuffle = true;
            currentCustomization.getGuidanceCustomization().enableRetryScreenBulletedInstructions = true;
            currentCustomization.getGuidanceCustomization().cameraPermissionsScreenImage = R.drawable.camera_red;
            // ID Scan Customization
            currentCustomization.getIdScanCustomization().showSelectionScreenBrandingImage = false;
            currentCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentCustomization.getIdScanCustomization().selectionScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenBackgroundColors = backgroundColor;
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = secondaryColor;
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().headerTextSize = 24;
            currentCustomization.getIdScanCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().subtextTextSize = 14;
            currentCustomization.getIdScanCustomization().subtextTextSpacing = 0f;
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextSize = 20;
            currentCustomization.getIdScanCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.parseColor("#4DED1C24");
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = Color.TRANSPARENT;
            currentCustomization.getIdScanCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 2;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 8;
            currentCustomization.getIdScanCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderWidth = 0;
            currentCustomization.getIdScanCustomization().reviewScreenTextBackgroundCornerRadius = 2;
            currentCustomization.getIdScanCustomization().captureScreenBackgroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureFrameStrokeWidth = 2;
            currentCustomization.getIdScanCustomization().captureFrameCornerRadius = 12;
            currentCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.zoom_active_torch;
            currentCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.zoom_inactive_torch;
            // Result Screen Customization
            currentCustomization.getResultScreenCustomization().backgroundColors = backgroundColor;
            currentCustomization.getResultScreenCustomization().foregroundColor = secondaryColor;
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().messageTextSize = 18;
            currentCustomization.getResultScreenCustomization().messageTextSpacing = 0.05f;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = 0;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1500;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = R.drawable.ekyc_animated_activity_indicator;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
            currentCustomization.getResultScreenCustomization().resultAnimationForegroundColor = Color.TRANSPARENT;
            currentCustomization.getResultScreenCustomization().resultAnimationSuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationUnsuccessBackgroundImage = 0;
            currentCustomization.getResultScreenCustomization().customResultAnimationSuccess = R.drawable.ekyc_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = R.drawable.ekyc_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = R.drawable.ekyc_static_success_vector_drawable;
            currentCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = R.drawable.ekyc_static_unsuccess_vector_drawable;
            currentCustomization.getResultScreenCustomization().showUploadProgressBar = false;
            currentCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            currentCustomization.getResultScreenCustomization().animationRelativeScale = 1.0f;
            // Feedback Customization
            currentCustomization.getFeedbackCustomization().backgroundColors = secondaryColor;
            currentCustomization.getFeedbackCustomization().textColor = backgroundColor;
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().textSize = 18;
            currentCustomization.getFeedbackCustomization().textSpacing = 0.05f;
            currentCustomization.getFeedbackCustomization().cornerRadius = 3;
            currentCustomization.getFeedbackCustomization().elevation = 10;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 8;
            currentCustomization.getFrameCustomization().elevation = 10;
            currentCustomization.getFeedbackCustomization().relativeWidth = 1.0f;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BFED1C24");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BFED1C24");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_box_red;
            currentCustomization.getCancelButtonCustomization().setLocation(ZoomCancelButtonCustomization.ButtonLocation.TOP_RIGHT);
        }
        else if(theme.equals("Sample Bank")) {
            int primaryColor = Color.parseColor("#FFFFFF"); // white
            int backgroundColor = Color.parseColor("#1D174F"); // navy

            // Overlay Customization
            currentCustomization.getOverlayCustomization().backgroundColor = Color.TRANSPARENT;
            currentCustomization.getOverlayCustomization().showBrandingImage = true;
            currentCustomization.getOverlayCustomization().brandingImage = R.drawable.sample_bank_logo;
            // Guidance Customization
            currentCustomization.getGuidanceCustomization().backgroundColors = backgroundColor;
            currentCustomization.getGuidanceCustomization().foregroundColor = primaryColor;
            currentCustomization.getGuidanceCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().headerTextSize = 24;
            currentCustomization.getGuidanceCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getGuidanceCustomization().subtextTextSize = 14;
            currentCustomization.getGuidanceCustomization().subtextTextSpacing = 0f;
            currentCustomization.getGuidanceCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getGuidanceCustomization().buttonTextSize = 20;
            currentCustomization.getGuidanceCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getGuidanceCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
            currentCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#4D1D174F");
            currentCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getGuidanceCustomization().buttonBorderWidth = 2;
            currentCustomization.getGuidanceCustomization().buttonCornerRadius = 2;
            currentCustomization.getGuidanceCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DFFFFFF");
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = backgroundColor;
            currentCustomization.getGuidanceCustomization().readyScreenTextBackgroundCornerRadius = 2;
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
            currentCustomization.getIdScanCustomization().captureScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().reviewScreenForegroundColor = backgroundColor;
            currentCustomization.getIdScanCustomization().selectionScreenForegroundColor = primaryColor;
            currentCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = primaryColor;
            currentCustomization.getIdScanCustomization().headerFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().headerTextSize = 24;
            currentCustomization.getIdScanCustomization().headerTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().subtextFont = Typeface.create("sans-serif-light", Typeface.NORMAL);
            currentCustomization.getIdScanCustomization().subtextTextSize = 14;
            currentCustomization.getIdScanCustomization().subtextTextSpacing = 0f;
            currentCustomization.getIdScanCustomization().buttonFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getIdScanCustomization().buttonTextSize = 20;
            currentCustomization.getIdScanCustomization().buttonTextSpacing = 0.05f;
            currentCustomization.getIdScanCustomization().buttonTextNormalColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonTextHighlightColor = backgroundColor;
            currentCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BFFFFFFF");
            currentCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.parseColor("#4D1D174F");
            currentCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderColor = primaryColor;
            currentCustomization.getIdScanCustomization().buttonBorderWidth = 2;
            currentCustomization.getIdScanCustomization().buttonCornerRadius = 2;
            currentCustomization.getIdScanCustomization().buttonRelativeWidth = 1.0f;
            currentCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = primaryColor;
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
            currentCustomization.getResultScreenCustomization().messageFont  = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getResultScreenCustomization().messageTextSize = 18;
            currentCustomization.getResultScreenCustomization().messageTextSpacing = 0.05f;
            currentCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_white;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorRotationInterval = 1000;
            currentCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = Color.TRANSPARENT;
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
            currentCustomization.getFeedbackCustomization().textFont = Typeface.create("sans-serif", Typeface.BOLD);
            currentCustomization.getFeedbackCustomization().textSize = 18;
            currentCustomization.getFeedbackCustomization().textSpacing = 0.05f;
            currentCustomization.getFeedbackCustomization().cornerRadius = 2;
            currentCustomization.getFeedbackCustomization().elevation = 0;
            currentCustomization.getFeedbackCustomization().relativeWidth = 1.0f;
            // Frame Customization
            currentCustomization.getFrameCustomization().backgroundColor = backgroundColor;
            currentCustomization.getFrameCustomization().borderColor = primaryColor;
            currentCustomization.getFrameCustomization().borderWidth = 2;
            currentCustomization.getFrameCustomization().cornerRadius = 2;
            currentCustomization.getFrameCustomization().elevation = 0;
            // Oval Customization
            currentCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentCustomization.getOvalCustomization().progressColor1 = Color.parseColor("#BFFFFFFF");
            currentCustomization.getOvalCustomization().progressColor2 = Color.parseColor("#BFFFFFFF");
            // Cancel Button Customization
            currentCustomization.getCancelButtonCustomization().customImage = R.drawable.cancel_white;
            currentCustomization.getCancelButtonCustomization().setLocation(ZoomCancelButtonCustomization.ButtonLocation.TOP_LEFT);
        }

        return currentCustomization;
    }

    static ZoomCustomization getLowLightCustomizationForTheme(String theme) {
        ZoomCustomization currentLowLightCustomization = getCustomizationForTheme(theme);

        int[] retryScreenSlideshowImages = new int[]{R.drawable.zoom_ideal_1, R.drawable.zoom_ideal_2, R.drawable.zoom_ideal_3, R.drawable.zoom_ideal_4, R.drawable.zoom_ideal_5};

        if(theme.equals("FaceTec Theme")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Pseudo-Fullscreen")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Well-Rounded")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Bitcoin Exchange")) {
            int primaryColor = Color.parseColor("#F79634"); // orange
            int secondaryColor = Color.parseColor("#FFFF1E"); // yellow
            int backgroundColor = Color.parseColor("#424242"); // dark grey

            // Overlay Customization
            currentLowLightCustomization.getOverlayCustomization().brandingImage = R.drawable.bitcoin_exchange_logo;
            // Guidance Customization
            currentLowLightCustomization.getGuidanceCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextNormalColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextHighlightColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4DF79634");
            currentLowLightCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = Color.WHITE;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenImageBorderColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenOvalStrokeColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().retryScreenSlideshowImages = new int[0];
            // ID Scan Customization
            currentLowLightCustomization.getIdScanCustomization().selectionScreenBrandingImage = 0;
            currentLowLightCustomization.getIdScanCustomization().captureScreenForegroundColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenForegroundColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().selectionScreenForegroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenFocusMessageTextColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextNormalColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundNormalColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextHighlightColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundHighlightColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonTextDisabledColor = Color.WHITE;
            currentLowLightCustomization.getIdScanCustomization().buttonBackgroundDisabledColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().buttonBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundColor = backgroundColor;
            currentLowLightCustomization.getIdScanCustomization().reviewScreenTextBackgroundBorderColor = Color.TRANSPARENT;
            currentLowLightCustomization.getIdScanCustomization().captureFrameStrokeColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().activeTorchButtonImage = R.drawable.torch_active_orange;
            currentLowLightCustomization.getIdScanCustomization().inactiveTorchButtonImage = R.drawable.torch_inactive_orange;
            // Result Screen Customization
            currentLowLightCustomization.getResultScreenCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getResultScreenCustomization().activityIndicatorColor = primaryColor;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorImage = R.drawable.activity_indicator_orange;
            currentLowLightCustomization.getResultScreenCustomization().customActivityIndicatorAnimation = 0;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationBackgroundColor = primaryColor;
            currentLowLightCustomization.getResultScreenCustomization().resultAnimationForegroundColor = Color.WHITE;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationSuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().customStaticResultAnimationUnsuccess = 0;
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressTrackColor = Color.parseColor("#33000000");
            currentLowLightCustomization.getResultScreenCustomization().uploadProgressFillColor = primaryColor;
            // Feedback Customization
            currentLowLightCustomization.getFeedbackCustomization().backgroundColors = primaryColor;
            currentLowLightCustomization.getFeedbackCustomization().textColor = Color.WHITE;
            // Frame Customization
            currentLowLightCustomization.getFrameCustomization().borderColor = backgroundColor;
            // Oval Customization
            currentLowLightCustomization.getOvalCustomization().strokeColor = primaryColor;
            currentLowLightCustomization.getOvalCustomization().progressColor1 = secondaryColor;
            currentLowLightCustomization.getOvalCustomization().progressColor2 = secondaryColor;
            // Cancel Button Customization
            currentLowLightCustomization.getCancelButtonCustomization().customImage = R.drawable.single_chevron_left_orange;

            // Guidance Customization -- Text Style Overrides
            // Ready Screen Header
            currentLowLightCustomization.getGuidanceCustomization().readyScreenHeaderTextColor = primaryColor;
            // Ready Screen Subtext
            currentLowLightCustomization.getGuidanceCustomization().readyScreenSubtextTextColor = backgroundColor;
            // Retry Screen Header
            currentLowLightCustomization.getGuidanceCustomization().retryScreenHeaderTextColor = primaryColor;
            // Retry Screen Subtext
            currentLowLightCustomization.getGuidanceCustomization().retryScreenSubtextTextColor = backgroundColor;
        }
        else if(theme.equals("eKYC")) {
            currentLowLightCustomization = null;
        }
        else if(theme.equals("Sample Bank")) {
            int primaryColor = Color.WHITE;
            int backgroundColor = Color.parseColor("#1D174F"); // navy

            // Overlay Customization
            currentLowLightCustomization.getOverlayCustomization().brandingImage = R.drawable.sample_bank_logo;
            // Guidance Customization
            currentLowLightCustomization.getGuidanceCustomization().foregroundColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextNormalColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundNormalColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonTextHighlightColor = primaryColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundHighlightColor = Color.parseColor("#BF1D174F");
            currentLowLightCustomization.getGuidanceCustomization().buttonTextDisabledColor = Color.parseColor("#4DFFFFFF");
            currentLowLightCustomization.getGuidanceCustomization().buttonBackgroundDisabledColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().buttonBorderColor = backgroundColor;
            currentLowLightCustomization.getGuidanceCustomization().readyScreenOvalFillColor = Color.parseColor("#4D1D174F");
            currentLowLightCustomization.getGuidanceCustomization().readyScreenTextBackgroundColor = primaryColor;
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
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundColor = primaryColor;
            currentLowLightCustomization.getIdScanCustomization().captureScreenTextBackgroundBorderColor = backgroundColor;
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
        }

        return currentLowLightCustomization;
    }
}
