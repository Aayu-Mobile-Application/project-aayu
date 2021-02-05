import * as React from 'react';
import MapView, { PROVIDER_GOOGLE, Marker, Callout } from 'react-native-maps';
import { StyleSheet, Dimensions, Text } from 'react-native';

const Map = () => {
    return (
        <MapView
        provider={PROVIDER_GOOGLE}
        style={styles.map}
        loadingEnabled={true}
        region={{
            latitude: 7.8731,
            longitude: 80.7718,
            latitudeDelta: 0.0043,
            longitudeDelta: 0.0034
        }}
        > 

        <Marker coordinate={{latitude:6.927079, longitude:79.861244,}}
        image={require('../assets/plant_icon.png')}
        > 
        <Callout>
            <Text>වෙදපාන</Text>
        </Callout>

        </Marker>

        <Marker coordinate={{ latitude:6.124593, longitude:81.101074,}}
        image={require('../assets/plant_icon.png')}
        >
        
        <Callout>
            <Text>Mango</Text>
        </Callout>

        </Marker>

        </MapView>
    )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  map: {
    width: Dimensions.get('window').width,
    height: Dimensions.get('window').height,
  },
});

export default Map