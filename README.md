# react-native-facetec

facetec module bridge

## Installation

```sh
npm install react-native-facetec
```

## Usage

```js
import Facetec from "react-native-facetec";


init(
    () => {
    console.log('init success');
    },
    () => console.log('init fail')
);

enroll(
    (resp) => {
        console.log('enroll ' + resp);
    },
    (error) => console.log('enroll ' + error)
);

livenessCheck(
    (resp) => {
        console.log('livenessCheck ' + resp);
    },
    (error) => console.log('livenessCheck ' + error)
)

authenticateUser(
    (resp) => {
        console.log('authenticateUser ' + resp);
    },
    (error) => console.log('authenticateUser ' + error)
)
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
