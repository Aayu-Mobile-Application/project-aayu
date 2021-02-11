import React from "react"
import {

    StyleSheet,
    Text,
    View,
    Image,
    Button,
    FlatList,
    KeyboardAvoidingView,
    Modal,
    TextInput,
    ScrollView,
    TouchableOpacity,
    TouchableWithoutFeedback,
    Platform,

} from "react-native"
import { LinearGradient } from 'expo-linear-gradient';
import { colours, cntSizes, appIcons, images, appFonts } from '../constants'
//importing google app auth
import * as GoogleForAayu from 'expo-google-app-auth'

//AppLoginScreen extending
class AppLoginScreen extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            signedIn: false,
            name: "",
            photoUrl: ""
        }
    }


    //sign in
    signIn = async () => {
        try {
            const result = await GoogleForAayu.logInAsync({
                androidClientId:
                    //api key for login: client Id
                    //OAuth 2.0 Client IDs 
                    //current auth mail:prasandikabhagya@gmail.com
                    //id1052848989525-ats8cb7kna3al6r115sg8rcvgfctpv3t.apps.googleusercontent.com
                    //type:Web application 
                    "727475050248-pb0bqq81se47p2mq6mhp8kn20sp5r0fn.apps.googleusercontent.com",

                scopes: ["profile", "email"]
            })

            if (result.type === "success") {
                this.setState({
                    signedIn: true,
                    name: result.user.name,
                    photoUrl: result.user.photoUrl
                })
            } else {
                console.log("cancelled")
            }
        } catch (e) {
            console.log("error", e)
        }
    }

    //rendering 
    render() {
        return (
            <View >
                {appHeaderRender()}
                {appLogoRender()}
                {buttonContRender()}
                <KeyboardAvoidingView
                    behavior={Platform.OS === "android" ? "padding" : 0.5}
                    style={{ flex: 1.0 }}
                >
                    <LinearGradient
                        //linear gradiant color mix in login screen
                        colors={[colours.green, colours.lightGreen]}
                        style={{ flex: 1 }}
                    >
                        <ScrollView>
                        </ScrollView>
                    </LinearGradient>
                </KeyboardAvoidingView>


                {this.state.signedIn ? (
                    <LoggedInPage name={this.state.name} />
                ) : (
                        <LoginPage signIn={this.signIn} />
                    )}

            </View>
        )
    }
}



//function login button
function buttonContRender() {
    return (
        <View style={{ margin: cntSizes.paddingObj * 2 }}>
            <TouchableOpacity
                //styling the continue button
                style={{
                    alignItems: 'center',
                    justifyContent: 'center',
                    backgroundColor: colours.black,
                    borderColor: colours.gray,
                    borderRadius: cntSizes.radius / 4, height: 55
                }}
                //set action to login button
                onPress={() => navigation.navigate("HomeScreen")}
            >
                <Text style={{
                    ...appFonts.h2,
                    color: colours.white
                }}>Log In</Text>
            </TouchableOpacity>
        </View>

    )
}



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
            <Image
                style={{
                    height: 30.24,
                    //back icon  color
                    tintColor: colours.black,
                    width: 30.24,
                }} source={appIcons.bckArrw}
                //import from icons
                resizeMode="contain"

            />
            {/* login text */}
            < Text style={{ color: colours.white, ...appFonts.h2, marginLeft: cntSizes.paddingObj * 0.4 }}>Log In</Text>
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
                marginTop: cntSizes.paddingObj * 1.36,
                justifyContent: 'center',
            }}
        >
            <Image
                //logo setting up
                style={{
                    width: "50%"
                }}
                resizeMode="contain"
                source={images.aayuLogo}
            />
        </View>
    )
}

const LoginPage = props => {
    return (
        <View>
            <Text style={styles.header}>Sign In With Google</Text>
            <Button title="Sign in with Google" onPress={() => props.signIn()} />
        </View>
    )
}


const LoggedInPage = props => {
    return (
        <View style={styles.container}>
            <Text style={styles.header}>Hello {props.name}</Text>
        </View>
    )
}


const styles = ({

})
export default AppLoginScreen;