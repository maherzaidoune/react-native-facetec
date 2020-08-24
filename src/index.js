import { NativeModules } from 'react-native';
const { Facetec } = NativeModules;

// type Props = {
//   onSuccess?: (any) => void,
//   onFail?: (any) => void,
// };

export function init(action = null, onSuccess, onFail) {
  if (action) {
    Facetec.Init(action, onSuccess, onFail);
  } else {
    Facetec.Init(onSuccess, onFail);
  }
}

export function authenticateUser(id, onSuccess, onFail) {
  Facetec.AuthenticateUser(id, onSuccess, onFail);
}

export function enroll(id, onSuccess, onFail) {
  Facetec.Enroll(id, onSuccess, onFail);
}

export function livenessCheck(onSuccess, onFail) {
  Facetec.LivenessCheck(onSuccess, onFail);
}

export function CheckId(onSuccess, onFail) {
  Facetec.CheckId(onSuccess, onFail);
}

export default { init, enroll, authenticateUser, livenessCheck, CheckId };
