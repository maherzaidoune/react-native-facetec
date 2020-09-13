import React from 'react';
import {
  SafeAreaView,
  StatusBar,
  TouchableOpacity,
  View,
  Text,
  InteractionManager,
  Image
} from 'react-native';
import {
  init,
  enroll,
  authenticateUser,
  livenessCheck,
  CheckId,
} from 'react-native-facetec';

export default class App extends React.Component {


  constructor(props){
    super(props)
    this.state={
      img: ''
    }
  }
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
                  console.log('init ', params);
                },
                (error) => console.log('init error ', error)
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
                'maher',
                (params) => {
                  console.log('enroll ', params);
                },
                (error) => console.log('enroll ', error)
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
                  console.log('livenessCheck ', params);
                },
                (error) => console.log('livenessCheck error ', error)
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
                'maher',
                (params) => {
                  console.log('authenticateUser ', params);
                },
                (error) => console.log('authenticateUser error', error)
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
          <TouchableOpacity
            onPress={() =>
              CheckId(
                'maher',
                (params) => {
                  console.log('PhotoIDMatch ', params);
                  let data = JSON.parse(params);
                  this.setState({
                    img: data.FrontImagesCompressedBase64
                  })
                },
                (error) => console.log('PhotoIDMatch error', error)
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
            <Text style={{ color: '#fff' }}>PhotoID Match</Text>
          </TouchableOpacity>

          <Image source={{uri: 'data:image/jpeg;base64,' + this.state.img}} style={{
            width: 100,
            height: 100
          }} />
        </SafeAreaView>
      </View>
    );
  }
}
