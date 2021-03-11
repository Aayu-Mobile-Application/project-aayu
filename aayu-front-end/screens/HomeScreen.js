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





const HomeScreen = ({navigation,route}) => {

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
                            <Text style={{ color: colours.white, ...appFonts.h2, }}>Hello {route.params.paramKey}</Text>
                            {/* <Text style={{ color: colours.white, ...appFonts.h2, }}>Welcome Aayu {route.params.Uname1}</Text> */}
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
                  }}  source={images.hmeBanner2}
                  resizeMode="cover"
              />
                    </View>
                </View>
            </View>
        

         {/* //navigation btns */}
            
         <View style={{ flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between',paddingHorizontal: cntSizes.paddingObj }}>
                            <Text style={{ color: colours.green, ...appFonts.h2, }}>Features</Text>
                        </View>
         <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj/2, paddingHorizontal: cntSizes.paddingObj }}> 
        
         {/* //responsive icons in the home screen */}
             <NavigBtnDesgnItems
                 icnImg={appIcons.air}
                 // appppDesgn
                 icnLabel="Scan"
                 onPress={()=>{navigation.navigate("Type")}}
                 bckColor={["#00996D",'#00e673']}
             /> 
             <NavigBtnDesgnItems
                 icnImg={appIcons.pltInfo}
                 // appppDesgn
                 icnLabel="Plant Info"
                 onPress={()=>{navigation.navigate("PlantInfo")}}
                 bckColor={["#00996D",'#00e673']}
             />  

             <NavigBtnDesgnItems
                 icnImg={appIcons.map}
                 // appppDesgn
                 icnLabel="Map"
                 onPress={()=>{navigation.navigate("MapView")}}
                 bckColor={["#00996D",'#00e673']}
             />  

         </View> 


         {/* second row */}
         <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj, paddingHorizontal: cntSizes.paddingObj }}> 
         
         {/* //responsive icons in the home screen */}
             <NavigBtnDesgnItems
                 icnImg={appIcons.quiz}
                 // appppDesgn
                 icnLabel="Quiz"
                 onPress={()=>{navigation.navigate("AppQuiz")}}
                 bckColor={["#00996D",'#00e673']}
             /> 
             <NavigBtnDesgnItems
                 icnImg={appIcons.abt}
                 // appppDesgn
                 icnLabel="About"
                 onPress={()=>{navigation.navigate("PlantInfo")}}
                 bckColor={["#00996D",'#00e673']}
             />  

             <NavigBtnDesgnItems
                 icnImg={appIcons.help}
                 // appppDesgn
                 icnLabel="Help"
                 onPress={()=>{navigation.navigate("Help")}}
                 bckColor={["#00996D",'#00e673']}
             />  

         </View> 
 </View>

 
    );
};

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
            <View style={[styles.shadow, { width: 80, height: 80 }]}>
                <LinearGradient
                    style={[{ alignItems: 'center',flex: 1 , justifyContent: 'center', borderRadius: 15, marginTop: cntSizes.paddingObj/8 }]}
                    colors={bckColor}
                    start={{ x: 0, y: 0 }}
                    end={{ x: 0, y: 1 }}
                >
                    <Image
                        source={icnImg}
                        resizeMode="cover"
                        style={{
                            
                            width: 50,
                            height: 50,
                            tintColor: colours.white
                        }}
                    />
                </LinearGradient>
            </View>
            <Text style={{...appFonts.bdy3,color: colours.green,marginTop:cntSizes.baseSpc/4}}>{icnLabel}</Text>
        </TouchableOpacity>
    )
}





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

export default HomeScreen;