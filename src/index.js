import { NativeModules } from 'react-native';
const { Facetec } = NativeModules;

export function init() {
  Facetec.Init();
}

export function authenticateUser() {
  Facetec.AuthenticateUser();
}

export function enroll() {
  Facetec.Enroll();
}

export function livenessCheck() {
  Facetec.LivenessCheck();
}

export default { init, enroll, authenticateUser, livenessCheck };
