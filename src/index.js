import { NativeModules } from 'react-native';
const { Facetec } = NativeModules;

// type Props = {
//   onSuccess?: (any) => void,
//   onFail?: (any) => void,
// };

export function init(onSuccess, onFail) {
  Facetec.Init(onSuccess, onFail);

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

export function CheckId(id, onSuccess, onFail) {
  Facetec.CheckId(id, onSuccess, onFail);
}

export default { init, enroll, authenticateUser, livenessCheck, CheckId };
