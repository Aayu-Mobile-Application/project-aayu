import React from "react";
import {
    View,
    Image,
    TouchableOpacity
} from 'react-native';
import {createBottomTabNavigator, BottomTabBar} from "@react-navigation/bottom-tabs"

import {HomeScreen, PlantInfo,Scan} from "../screens";

import {colours,icons} from "../constants"


const tabNav = createBottomTabNavigator();

const navigationTbs = () => {
    return(
    <tabNav.Navigator
        tabBarOptions={{
            showLabel: false,
            style:{
                borderTopWidth: 0,
                backgroundColor:"transparent",
                elevation:0 //setting up elevation for avoid clash with soft keys
            }
        }}
    >
        <tabNav.Screen
            name="Home"
            component={HomeScreen}
            options={{
                tabBarIcon: ({focused}) => (
                    <Image
                        source={icons.cube}
                        resizeMode="contain"
                        style={{
                            width:25,
                            height:25,
                            tintColor: focused ? colours.primary : colours.secondary //change color when focused and not
                        }}
                    />
                )

                
            }}
            />

<tabNav.Screen
            name="Plant Info"
            component={PlantInfo}
            options={{
                tabBarIcon: ({focused}) => (
                    <Image
                        source={icons.camera}
                        resizeMode="contain"
                        style={{
                            width:25,
                            height:25,
                            tintColor: focused ? colours.primary : colours.secondary //change color when focused and not
                        }}
                    />
                )

                
            }}
            />

<tabNav.Screen
            name="Plant"
            component={Scan}
            options={{
                tabBarIcon: ({focused}) => (
                    <Image
                        source={icons.drop}
                        resizeMode="contain"
                        style={{
                            width:25,
                            height:25,
                            tintColor: focused ? colours.primary : colours.secondary //change color when focused and not
                        }}
                    />
                )

                
            }}
            />
    </tabNav.Navigator>
    )
}

export default navigationTbs;