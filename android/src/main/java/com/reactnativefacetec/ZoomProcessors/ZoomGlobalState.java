package com.reactnativefacetec.ZoomProcessors;


import com.facetec.sdk.FaceTecCustomization;

public class ZoomGlobalState {
  // Replace string below with your license key from https://dev.zoomlogin.com/zoomsdk/#/account
  public static String DeviceLicenseKeyIdentifier ="dbAJm57lOvJ0ViuYtpWOIsUhsGxMTv3c";

  // "https://api.zoomauth.com/api/v2/biometrics" for FaceTec Managed Testing API.
  // "http://localhost:8080" if running ZoOm Server SDK (Dockerized) locally.
  // Otherwise, your webservice URL.
  public static String ZoomServerBaseURL = "https://scan.numio.one";

  // The customer-controlled public key used during encryption of FaceMap data.
  // Please see https://dev.zoomlogin.com/zoomsdk/#/licensing-and-encryption-keys for more information.
  public static String PublicFaceMapEncryptionKey =
    "-----BEGIN PUBLIC KEY-----\n" +
      "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3N+du5DlZCuJQkLlj4Hk\n" +
      "xXKsnGa/weUO5juAzBVg3NpQ1i/2b+w0LeQviudSeFhgaId5JD327BHgqgsrNNVH\n" +
      "x6MtmlEMNvpfWFmuFUUcySVx4WU1QqeI20hxaCLCc6Kwcq5Z1ntaDQkyU8/e83VX\n" +
      "On1zofh1iD2pNdNUgbFrwABs+x+rpNXhWRcqTgJmPE40U0pLoBrajIUtsOO2vLpi\n" +
      "RetJuNbYMUjJmlnjnYjk435J9yDl0nmKWAB7u4BBbAUUiAkcKqEHuPUUpPkLI6NZ\n" +
      "yBuXCHCvxUOtVxCoOD/ITqN7ftjmSOI4NAYDRZtgWHuH8JshbgzOm9atIQhW+3qO\n" +
      "0wIDAQAB\n" +
      "-----END PUBLIC KEY-----";

  public static String ProductionKeyText =
    "appId      = \"com.numio.pay,com.facetec.sampleapp,com.example.reactnativefacetec\"\n" +
      "expiryDate = 2021-01-10\n" +
      "key        = 003046022100dade3062e2353404aae1d5cc71ec8a58de990501a2599b86817274041a727cfd0221008dd96c4d4cd890e8f70e0915a0860f7dac516b8a666deabcd15f41d13dd5a78c\n";


  // Used for bookkeeping around demonstrating enrollment/authentication functionality of ZoOm.
  public static String randomUsername = "";
  public static boolean isRandomUsernameEnrolled = false;

  public static FaceTecCustomization retrieveConfigurationWizardCustomization() {
    return new FaceTecCustomization();
  }

  public static FaceTecCustomization currentCustomization = retrieveConfigurationWizardCustomization();
  // This app can modify the customization to demonstrate different look/feel preferences for ZoOm.
}
