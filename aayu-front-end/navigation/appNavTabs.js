import React from "react";
import { View, Image, TouchableOpacity } from "react-native";
import {
  createBottomTabNavigator,
  BottomTabBar,
} from "@react-navigation/bottom-tabs";
import { HomeScreen, Map, PlantInfo, Scan } from "../screens";
import { colours, appIcons } from "../constants";
// import MapsView from "./screens";

const appNavigTab = createBottomTabNavigator();

const appNavigTabs = () => {
  return (
    <appNavigTab.Navigator
      tabBarOptions={{
        style: {
          elevation: 0, //setting up elevation for avoid clash with soft keys
          borderTopWidth: 0,
          backgroundColor: "transparent",
        },
        showLabel: false,
      }}
    >
      <appNavigTab.Screen
        name="Home"
        component={HomeScreen}
        options={{
          tabBarIcon: ({ focused }) => (
            <Image
              source={appIcons.hme}
              resizeMode="contain"
              style={{
                width: 25,
                height: 25,
                tintColor: focused ? colours.green : colours.gray, //change color when focused and not
              }}
            />
          ),
        }}
      />
      <appNavigTab.Screen
        name="Plant"
        component={PlantInfo}
        options={{
          tabBarIcon: ({ focused }) => (
            <Image
              source={appIcons.cam}
              resizeMode="contain"
              style={{
                width: 25,
                height: 25,
                tintColor: focused ? colours.green : colours.gray, //change color when focused and not
              }}
            />
          ),
        }}
      />

      <appNavigTab.Screen
        name="Plant Info"
        component={Scan}
        options={{
          tabBarIcon: ({ focused }) => (
            <Image
              style={{
                width: 25,
                height: 25,
                tintColor: focused ? colours.green : colours.gray, //change color when focused and not
              }}
              source={appIcons.hlp}
              resizeMode="contain"
            />
          ),
        }}
      />
      <appNavigTab.Screen
        name="Plant Map"
        component={Map}
        options={{
          tabBarIcon: ({ focused }) => (
            <Image
              style={{
                width: 25,
                height: 25,
                tintColor: focused ? colours.green : colours.gray, //change color when focused and not
              }}
              source={appIcons.hlp}
              resizeMode="contain"
            />
          ),
        }}
      />
    </appNavigTab.Navigator>
  );
};

export default appNavigTabs;
