import React, { useState } from 'react';
console.ignoredYellowBox = ['Warning:'];
import * as Google from 'expo-google-app-auth'
//import * as Google from 'expo-google-app-auth';
import {
    FlatList,
    StyleSheet,
    Button,
    KeyboardAvoidingView,
    Modal,
    Image,
    TextInput,
    View,
    Text,
    ScrollView,
    TouchableOpacity,
    TouchableWithoutFeedback,
    Platform,
    Alert
} from "react-native";
//import { LinearGradient } from 'react-native-linear-gradient';
import { LinearGradient } from 'expo-linear-gradient';
import { colours, cntSizes, appIcons, images, appFonts } from '../constants';


const AppLoginScreen = ({ navigation }) => {
    //declaring a new state variable , useState to use inside function component to handle local state

    const [names, setNames] = useState("");

    //const [displayEnteredPasscord, setDisplayEnteredPasscord] = useState(false);

    //function to render app header
    function appHeaderRender() { //header render
        return (
            <TouchableOpacity
                style={{
                    //icon aligns
                    alignItems: "center",
                    flexDirection: "row",
                    //back icon margins
                    paddingHorizontal: cntSizes.paddingObj * 2,
                    marginTop: cntSizes.paddingObj * 3.62
                }}
                //set on action to back btn
                onPress={() => console.log("appSignUp")}
            >
                {/* login text */}
                < Text style={{ color: colours.green, ...appFonts.h1, marginLeft: cntSizes.paddingObj/5 }}>Welcome Aayu</Text>
            </TouchableOpacity>
        )
    }

    //function to render app logo
    function appLogoRender() {
        return (
            <View
                style={{
                    //setting up dimensions
                    height: 175,
                    alignItems: 'center',
                    //align logo from top
                    marginTop: cntSizes.paddingObj * 6,
                    justifyContent: 'center',
                }}
            >
                <Image
                    //logo setting up
                    style={{
                        width: "80%",
                        height: "200%"
                    }}
                    resizeMode="contain"
                    source={images.aayuLogo}
                />
            </View>
        )
    }

    const signInWithGoogle = () => {
        signInWithGoogleAsync()
    }

    //function of google login
    async function signInWithGoogleAsync() {
        try {
            const result = await Google.logInAsync({
                //api key for login: client Id
                //OAuth 2.0 Client IDs 

                //id1052848989525-ats8cb7kna3al6r115sg8rcvgfctpv3t.apps.googleusercontent.com
                //type:Web application 
                androidClientId:

                    "727475050248-pb0bqq81se47p2mq6mhp8kn20sp5r0fn.apps.googleusercontent.com",
                scopes: ['profile', 'email'],
            });
            if (result.type === 'success') {
                setNames(result.user.name);
                //showing user name by popup
                Alert.alert('Hey There !!!', `Hey ${names}. Welcome to Aayu!`);
                return result.name;

            } else {
                return { cancelled: true };
            }
        } catch (e) {
            return { error: true };
        }
    }

    //function of google login
    async function signInWithGoogleAsync() {
        try {
            const result = await Google.logInAsync({
                //api key for login: client Id
                //OAuth 2.0 Client IDs 

                //id1052848989525-ats8cb7kna3al6r115sg8rcvgfctpv3t.apps.googleusercontent.com
                //type:Web application 
                androidClientId:

                    "727475050248-pb0bqq81se47p2mq6mhp8kn20sp5r0fn.apps.googleusercontent.com",
                scopes: ['profile', 'email'],
            });
            if (result.type === 'success') {
                setNames(result.user.name);

                return result.name;
            } else {
                return { cancelled: true };
            }
        } catch (e) {
            return { error: true };
        }
    }
    //getting name
    console.log(`${names}`);
    var Uname = names;

    
    //function login button
    function buttonContRender() {
        return (
            <View style={{ margin: cntSizes.paddingObj * 2 , marginTop: cntSizes.paddingObj * 8 }}>
                <TouchableOpacity
                    //styling the continue button
                    style={{
                        alignItems: 'center',
                        justifyContent: 'center',
                        backgroundColor: colours.green,
                        borderColor: colours.gray,
                        borderRadius: cntSizes.radius , height: 55
                    }}
                    //set action to login button
                    onPress={() => { signInWithGoogle(); navigation.navigate("HomeScreen",{Uname})
                 }}
                >
                    <Text style={{
                        ...appFonts.h2,
                        color: colours.white
                    }}>Sign in with Google</Text>
                </TouchableOpacity>
                {/* < Text style={{ color: colours.green, ...appFonts.h2/1.2,marginTop: cntSizes.paddingObj*5 , alignItems:'center', marginHorizontal: cntSizes.paddingObj*2.5 }}>From Mindscape</Text> */}
            </View>

        )
    }


    // const signInWithGoogle = () => {
    //     signInWithGoogleAsync()
    // }

    return (
        <KeyboardAvoidingView
            behavior={Platform.OS === "android" ? "padding" : 0.5}
            style={{ flex: 1.0 }}
        >
            <LinearGradient
                //linear gradiant color mix in login screen
                colors={[colours.white, colours.lightGreen]}
                style={{ flex: 1 }}
            >
                <ScrollView>
                    {appHeaderRender()}
                    {appLogoRender()}
                    {/* {userRegFormRender()} */}
                    {/* <Button  title="Sign in with Google" /> */}
                    {buttonContRender()}
                </ScrollView>
            </LinearGradient>
        </KeyboardAvoidingView>
    )
}

export default AppLoginScreen;