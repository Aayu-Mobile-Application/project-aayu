import React, { useState } from 'react';
import { render } from "react-dom";
//import { Router, Route, Switch } from "react-router";
import{
    View,
    Text,
    StyleSheet,
    SafeAreaView,
    TouchableOpacity,
    Image,
    Button,
    FlatList,
    Touchable

} from "react-native";
import { colours,images,appIcons,cntSizes,appFonts } from "../constants";
import { LinearGradient } from 'expo-linear-gradient';
//import  {signInWithGoogleAsync} from './AppLoginScreen';


const Help = ({navigation}) => {

    //declaring a new state variable , useState to use inside function component to handle local state
    //const [names,setNames] = useState();

    //const {param1} = route.params
    return (
        <View style={styles.container}>
            <View style={{ height: "40.25%" }}>
                <View style={{
                    flex: 1,
                    borderBottomLeftRadius: 49.5,
                    borderBottomRightRadius: 49.5,
                    backgroundColor: colours.green,
                    
                }}>
                    <View style={{ marginTop: cntSizes.paddingObj * 2.2, marginHorizontal: cntSizes.paddingObj }}>
                        <View style={{ flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' }}>
                            <Text style={{ color: colours.white, ...appFonts.h2, }}>Aayu Help</Text>
                        </View>
                        {/* <View style={{ marginTop: cntSizes.baseSpc }}>
                            <FlatList
                                horizontal
                                showsHorizontalScrollIndicator={false}
                                data={scannablePlants}
                                keyExtractor={itemAvl => itemAvl.idPlt.toString()}
                                renderItem={({ item, index }) => renderscannablePlants(item, index)}
                            />
                        </View> */}
                        <Image
                  
                  style={{
                      height: '78%', width: "100.20%" ,
                      marginTop: cntSizes.paddingObj/1.2,
                      borderRadius: 15.2
                  }}  source={images.bannerHlp}
                  resizeMode="cover"
              />
                    </View>
                </View>
            </View>
 </View>

 
    );
};

//styles for main screen
const styles = StyleSheet.create({
    container:{
    flex:1,
    }
})

export default Help;