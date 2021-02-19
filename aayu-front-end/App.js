import React from "react";
import { createStackNavigator } from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";
import appNavigTabs from "./navigation/appNavTabs";
import { HomeScreen, PlantInfo, AppLoginScreen } from "./screens";
import Map from "./screens/Map";
const Stack = createStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerShown: false,
        }}
        initialRouterName={"appSignUp"} //setting up the first screen to be displayed, SignUp
      >
        {/* navigation between tabs */}
        <Stack.Screen name="appSignUp" component={AppLoginScreen} />
        <Stack.Screen name="HomeScreen" component={appNavigTabs} />
        <Stack.Screen name="PlantInfo" component={PlantInfo} />
        <Stack.Screen name="MapView" component={Map} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;
