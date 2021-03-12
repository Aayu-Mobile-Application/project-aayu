// quiz holder

import React, { useState } from 'react';
import { render } from "react-dom";
//import quiz container
import {AppQuestions} from './AppQuizContainer';
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

const AppQuizHolder = ({navigation,route}) => {

    //handle current state of each question
    const [questionCrntOn, setQuestionCrntOn ] = useState(0);

    //handle state after answer is chosen
    const [answrChsn, setAnswrChsn] = useState("")

    //navig between questions
    const nextQuiz = () =>{

    }

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

                    <View style={{ marginTop: cntSizes.paddingObj * 2.2, marginHorizontal: cntSizes.paddingObj*6 }}>

                        <View style={{ flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' }}>
                            <Text style={{ color: colours.white, ...appFonts.h2, }}> Aayu Quiz </Text>
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
                            {/* enter the question here */}
                    </View>

                        <View>
                            <Text style={{ color: colours.white, ...appFonts.h2,marginTop: cntSizes.paddingObj * 2, marginHorizontal: cntSizes.paddingObj }}> {AppQuestions[questionCrntOn].prompt}</Text>
                        </View>

                    </View>
                    
                   
                        
            </View> 
                        <View>
                            {/* //navigation btns */}
         
                        <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj*6, paddingHorizontal: cntSizes.paddingObj*4 }}> 
                
                            {/* //responsive icons in the home screen */}
                            {/* <NavigBtnDesgnItems
                                onPress={()=>{navigation.navigate("AppQuizHolder")}}
                                bckColor={["#00996D",'#00e673']}
                                
                                
                            /> */}
                        <Button
                            onPress={()=> setAnswrChsn("ans4")}
                            title={AppQuestions[questionCrntOn].ans3}
                            color="#2a6337"
                        />



                        </View>

                        <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj, paddingHorizontal: cntSizes.paddingObj*4 }}> 
                
                        <Button
                            class="btns"
                            onPress={()=> setAnswrChsn("ans2")}
                            title={AppQuestions[questionCrntOn].ans2}
                            color="#2a6337"
                            borderRadius='8'
                            width='100%'
                        />
                        </View>

                        <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj, paddingHorizontal: cntSizes.paddingObj*4}}> 
                
                        <Button
                            onPress={()=> setAnswrChsn("ans1")}
                            title={AppQuestions[questionCrntOn].ans1}
                            color="#2a6337"
                            width='100'
                        />
                        </View>

                        <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj, paddingHorizontal: cntSizes.paddingObj*4 }}> 
                
                        <Button
                            onPress={()=> setAnswrChsn("ans3")}
                            title={AppQuestions[questionCrntOn].ans4}
                            color="#2a6337"
                        />
                        </View>
                        {/* next quiz btn */}
                        <View style={{flexDirection: 'row', marginTop: cntSizes.paddingObj*2, paddingHorizontal: cntSizes.paddingObj*6 }}> 
                
                        <Button
                            onPress={()=>{navigation.navigate("AppQuizHolder")}}
                            title='Next'
                            color="#2a6337"
                        />
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
    },
})

export default AppQuizHolder;






// import React, { useState } from 'react';
// import { render } from "react-dom";
// //import { Router, Route, Switch } from "react-router";
// import{
//     View,
//     Text,
//     StyleSheet,
//     SafeAreaView,
//     TouchableOpacity,
//     Image,
//     Button,
//     FlatList,
//     Touchable

// } from "react-native";
// import { colours,images,appIcons,cntSizes,appFonts } from "../constants";
// import { LinearGradient } from 'expo-linear-gradient';
// //import  {signInWithGoogleAsync} from './AppLoginScreen';




// const AppQuizHolder = ({navigation,route}) => {

//     //declaring a new state variable , useState to use inside function component to handle local state
//     //const [names,setNames] = useState();

//     //const {param1} = route.params
//     return (
//         <View style={styles.container}>
//             <View style={{ height: "40.25%" }}>
//                 <View style={{
//                     flex: 1,
//                     borderBottomLeftRadius: 49.5,
//                     borderBottomRightRadius: 49.5,
//                     backgroundColor: colours.green,
                    
//                 }}>
//                     <View style={{ marginTop: cntSizes.paddingObj * 2.2, marginHorizontal: cntSizes.paddingObj*6 }}>
//                         <View style={{ flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between' }}>
//                             <Text style={{ color: colours.white, ...appFonts.h2, }}> Aayu Quiz </Text>
//                         </View>
//                         {/* <View style={{ marginTop: cntSizes.baseSpc }}>
//                             <FlatList
//                                 horizontal
//                                 showsHorizontalScrollIndicator={false}
//                                 data={scannablePlants}
//                                 keyExtractor={itemAvl => itemAvl.idPlt.toString()}
//                                 renderItem={({ item, index }) => renderscannablePlants(item, index)}
//                             />
//                         </View> */}
//                             {/* enter the question here */}
//                     </View>
//                 </View>
//             </View>       
//  </View>

 
//     );
// };

// //styles for main screen
// const styles = StyleSheet.create({
//     container:{
//     flex:1,
//     }
// })

// export default AppQuizHolder;