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



//navigation buttons
const NavigBtnDesgnItems=({bckColor,icnImg,icnLabel,onPress}) =>{
    return(
        <TouchableOpacity
            style={{
                alignItems: 'center',
                justifyContent: 'center',
                flex: 1, }}
            onPress={onPress}
        >
            <View style={[styles.shadow, { width: 200, height: 80 }]}>
                <LinearGradient
                    style={[{ alignItems: 'center',flex: 1 , justifyContent: 'center', borderRadius: 15, marginTop: cntSizes.paddingObj/8 }]}
                    colors={bckColor}
                    start={{ x: 0, y: 0 }}
                    end={{ x: 0, y: 1 }}
                >
                   < Text style={{ color: colours.white, ...appFonts.h1, marginLeft: cntSizes.paddingObj * 0.4 }}>Start Quiz</Text>
                </LinearGradient>
            </View>
            <Text style={{...appFonts.bdy3,color: colours.green,marginTop:cntSizes.baseSpc/4}}>{icnLabel}</Text>
        </TouchableOpacity>
    )
}



const AppQuiz = ({navigation,route}) => {

    //declaring a new state variable , useState to use inside function component to handle local state
    //const [names,setNames] = useState();

    //const {param1} = route.params;
    return (
        <View style={styles.container}>
            <View style={{ height: "40.25%"}}>
                <View style={{
                    flex: 1,
                    borderBottomLeftRadius: 49.5,
                    borderBottomRightRadius: 49.5,
                    backgroundColor: colours.white,
                    
                }}>
                    <View style={{ marginTop: cntSizes.paddingObj , marginHorizontal: cntSizes.paddingObj }}>
                        <View style={{ flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' }}>
                        <TouchableOpacity
                style={{
                    //icon aligns
                    alignItems: "center",
                    flexDirection: "row",
                    //back icon margins
                    paddingHorizontal: cntSizes.paddingObj ,
                    marginTop: cntSizes.paddingObj*2.2
                }}
                //set on action to back btn
                onPress={() => {navigation.navigate("HomeScreen")}}
            >
                <Image
                    style={{
                        height: 50.24,
                        //back icon  color
                        tintColor: colours.green,
                        width: 50.24,
                    }} source={appIcons.bckArrw}
                    //import from icons
                    resizeMode="contain"

                />
                {/* login text */}
                < Text style={{ color: colours.white, ...appFonts.h2, marginLeft: cntSizes.paddingObj * 0.4 }}>Log In</Text>
            </TouchableOpacity>
                            <Text style={{ color: colours.black, ...appFonts.h2, }}> Aayu Quiz</Text>
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
                      marginTop: cntSizes.paddingObj*2,
                      borderRadius: 15.2
                  }}  source={images.quizBanner}
                  resizeMode="cover"
              />
                    </View>
                </View>
            </View>
        

         {/* //navigation btns */}
         
         <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj*4, paddingHorizontal: cntSizes.paddingObj }}> 
                
         {/* //responsive icons in the home screen */}
             <NavigBtnDesgnItems
                 icnImg={appIcons.air}
                 // appppDesgn
                 //icnLabel="Scan"
                 onPress={()=>{navigation.navigate("AppQuizHolder")}}
                 bckColor={["#00996D",'#00e673']}
             /> 
         </View> 

        
         <View style={{ height: "40.25%" }}>
                <View style={{
                    flex: 1,
                    borderTopLeftRadius: 49.5,
                    borderTopRightRadius: 49.5,
                    backgroundColor: colours.green,
                    marginBottom: cntSizes.paddingObj /12,
                    
                }}>
                    <View style={{ marginBottom: cntSizes.paddingObj * 4, marginHorizontal: cntSizes.paddingObj }}>
                        <View style={{ flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' }}>
                        <Text style={{ color: colours.white, ...appFonts.h2, marginTop: cntSizes.paddingObj *2 }}></Text>

                    </View>
                <Image
                  
                  style={{
                      height: '70%', width: "100.20%" ,
                      marginTop: cntSizes.paddingObj/2,
                      borderRadius: 15.2
                  }}  source={images.quizBanner2}
                  resizeMode="cover"
              />
                  
                        {/* <View style={{ marginTop: cntSizes.baseSpc }}>
                            <FlatList
                                horizontal
                                showsHorizontalScrollIndicator={false}
                                data={scannablePlants}
                                keyExtractor={itemAvl => itemAvl.idPlt.toString()}
                                renderItem={({ item, index }) => renderscannablePlants(item, index)}
                            />
                        </View> */}
                        {/* <Image
                  
                  style={{
                      height: '78%', width: "100.20%" ,
                      marginBottom: cntSizes.paddingObj/1.2,
                      borderRadius: 15.2
                  }}  source={images.hmeBanner2}
                  resizeMode="cover"
              /> */}
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
    },

    shadow:{
        shadowColor:'#000',
        shadowOffset:{
            width:0.2,
            height:2
        },
        shadowOpacity:0.3,
        elevation:6,
        shadowRadius:2.86
    }
})

export default AppQuiz;

