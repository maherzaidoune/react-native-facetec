import { NativeModules } from 'react-native';

type FacetecType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Facetec } = NativeModules;

export default Facetec as FacetecType;
