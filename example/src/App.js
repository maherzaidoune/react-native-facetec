import React from 'react';
import {
  SafeAreaView,
  StatusBar,
  TouchableOpacity,
  View,
  Text,
  InteractionManager,
} from 'react-native';
import {
  init,
  enroll,
  authenticateUser,
  livenessCheck,
} from 'react-native-facetec';

export default class App extends React.Component {
  componentDidMount() {
    InteractionManager.runAfterInteractions(() => {
      // const eventEmitter = new NativeEventEmitter(NativeModules.Facetec);
      // this.initialize = eventEmitter.addListener('initialize', (event) => {
      //   console.log(event);
      // });
      setTimeout(() => {
        init(
          () => {
            console.log('init ');
          },
          () => console.log('init ')
        );
      }, 500);
    });
  }
  render() {
    return (
      <View>
        <StatusBar barStyle="dark-content" />
        <SafeAreaView
          style={{
            alignItems: 'center',
            justifyContent: 'center',
          }}
        >
          <TouchableOpacity
            onPress={() =>
              init(
                (params) => {
                  console.log('init ' + params);
                },
                (error) => console.log('init ' + error)
              )
            }
            style={{
              backgroundColor: '#5F6FED',
              padding: 10,
              paddingStart: 20,
              paddingEnd: 20,
              marginTop: 10,
            }}
          >
            <Text style={{ color: '#fff' }}>Init</Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() =>
              enroll(
                (params) => {
                  console.log('init ' + params);
                },
                (error) => console.log('init ' + error)
              )
            }
            style={{
              backgroundColor: '#5F6FED',
              padding: 10,
              paddingStart: 20,
              paddingEnd: 20,
              marginTop: 10,
            }}
          >
            <Text style={{ color: '#fff' }}>Enroll user</Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() =>
              livenessCheck(
                (params) => {
                  console.log('init ' + params);
                },
                (error) => console.log('init ' + error)
              )
            }
            style={{
              backgroundColor: '#5F6FED',
              padding: 10,
              paddingStart: 20,
              paddingEnd: 20,
              marginTop: 10,
            }}
          >
            <Text style={{ color: '#fff' }}>Liveness</Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() =>
              authenticateUser(
                (params) => {
                  console.log('init ' + params);
                },
                (error) => console.log('init ' + error)
              )
            }
            style={{
              backgroundColor: '#5F6FED',
              padding: 10,
              paddingStart: 20,
              paddingEnd: 20,
              marginTop: 10,
            }}
          >
            <Text style={{ color: '#fff' }}>Face matching</Text>
          </TouchableOpacity>
          {/* <TouchableOpacity
            onPress={() => enroll()}
            style={{
              backgroundColor: '#5F6FED',
              padding: 10,
              paddingStart: 20,
              paddingEnd: 20,
              marginTop: 10,
            }}>
            <Text style={{color: '#fff'}}>Enroll user</Text>
          </TouchableOpacity> */}
        </SafeAreaView>
      </View>
    );
  }
}
