import React from "react";
import{
    FlatList,
    KeyboardAvoidingView,
    Modal,
    Image,
    TextInput,
    View,
    Text ,
    ScrollView,
    TouchableOpacity,
    TouchableWithoutFeedback,
    Platform,
} from "react-native";
//import { LinearGradient } from 'react-native-linear-gradient';
import { LinearGradient } from 'expo-linear-gradient';
import {colours,cntSizes,appIcons,images,appFonts} from '../constants'


const AppLoginScreen = ({navigation}) => {
    //declaring a new state variable , useState to use inside function component to handle local state
    const [displayEnteredPasscord, setDisplayEnteredPasscord] = React.useState(false)

    //function to render app header
    function appHeaderRender(){ //header render
        return(
        <TouchableOpacity
            style={{
                //icon aligns
                alignItems:"center",
                flexDirection:"row",
                //back icon margins
                paddingHorizontal: cntSizes.paddingObj*2,
                marginTop: cntSizes.paddingObj*3.62
            }}
            //set on action to back btn
            onPress={()=> console.log("appSignUp")}
        >
            <Image
                style={{
                    height:30.24,
                    //back icon  color
                    tintColor:colours.black,
                    width:30.24,
                }}source={appIcons.bckArrw}
                //import from icons
                resizeMode="contain"
                
            />
            {/* login text */}
            < Text style={{color:colours.white, ...appFonts.h2 ,marginLeft:cntSizes.paddingObj*0.4}}>Log In</Text>
        </TouchableOpacity>
        )
    }

    //function to render app logo
    function appLogoRender(){
        return(
            <View
                style={{
                    //setting up dimensions
                    height:175,
                    alignItems:'center',
                    //align logo from top
                    marginTop:cntSizes.paddingObj*1.36,
                    justifyContent:'center',
                }}
            >
                <Image
                    //logo setting up
                    style={{
                        width:"50%"
                    }}
                    resizeMode="contain"
                    source={images.aayuLogo}
                />
            </View>
        )
    }

    //function user reg form render
    function userRegFormRender(){
        return(
            <View
                style={{
                    marginTop: cntSizes.paddingObj*4,
                    marginHorizontal: cntSizes.paddingObj*4,
                }}
                >

                {/* getting user name */}
                <View 
                    style={{marginTop:cntSizes.paddingObj*0.28}}
                ><Text style={{color:colours.white, ...appFonts.bdy5}}>Full Name</Text>
                <TextInput
                    style={{
                        //styles for user text input field
                        height:28, ...appFonts.bdy3,
                        marginVertical: cntSizes.paddingObj*0.1,
                        //borderBottomColor:colours.white,
                        borderBottomWidth:1.2,
                        color: colours.white

                    }}
                    //props for placeholder
                    selectionColor={colours.white}
                    placeholder="Enter Your Name"
                    placeholderTextColor={colours.white}
                />
                </View>

                {/* getting user password */}
                <View 
                    style={{marginTop:cntSizes.paddingObj*1}}
                ><Text style={{color:colours.white, ...appFonts.bdy5}}>Password</Text>
                <TextInput
                    style={{
                        //styles for user text input field
                        height:28, ...appFonts.bdy3,
                        marginVertical: cntSizes.paddingObj*0.1,
                        //borderBottomColor:colours.white,
                        borderBottomWidth:1.2,
                        color: colours.white
                    }}
                    //props for placeholder
                    secureTextEntry={true}
                    selectionColor={colours.white}
                    placeholder="Enter Password"
                    //secure text entry input
                    secureTextEntry={!displayEnteredPasscord}
                    placeholderTextColor={colours.white}
                />
                {/* //toggle button for password input */}
                <TouchableOpacity
                    style={{height:32,
                        right:0,
                        bottom:0,
                        position: 'absolute',
                        width:32,
                    }}
                    //on press display password
                    //set on action to display password when eye pressed
                    onPress={() => setDisplayEnteredPasscord(!displayEnteredPasscord)}
                >
                    {/* setting up image to password view */}
                    <Image
                        source={appIcons.OpenEye}//consider to add disable icon when unClicked
                        style={{
                            height:20.25,
                            width:20.25,
                            tintColor:colours.white
                        }}
                        />
                    
                </TouchableOpacity>
                    </View>
            </View>

        )
    }

    //function login button
    function buttonContRender(){
        return(
            <View style={{margin: cntSizes.paddingObj*2}}>
                <TouchableOpacity
                //styling the continue button
                    style={{
                        alignItems:'center',
                        justifyContent:'center',
                        backgroundColor:colours.black,
                        borderColor: colours.gray,
                        borderRadius: cntSizes.radius/4,height:55
                    }}
                //set action to login button
                onPress={()=> navigation.navigate("HomeScreen")}
                >
                <Text style={{...appFonts.h2,
                    color:colours.white}}>Log In</Text>
                </TouchableOpacity>
            </View>

        )
    }

    return (
        <KeyboardAvoidingView
            behavior={Platform.OS === "android" ? "padding" :0.5}
            style={{ flex:1.0}}
        >
            <LinearGradient 
                //linear gradiant color mix in login screen
                colors={[colours.green, colours.lightGreen]}
                style={{flex:1}}
            >
            <ScrollView>
                {appHeaderRender()}
                {appLogoRender()} 
                {userRegFormRender()}
                {buttonContRender()}
            </ScrollView>
            </LinearGradient>
        </KeyboardAvoidingView>
    )
}

export default AppLoginScreen;