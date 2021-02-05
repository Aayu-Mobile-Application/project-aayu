import React from 'react';
import {createStackNavigator} from "@react-navigation/stack";
import {NavigationContainer} from "@react-navigation/native";
import appNavigTabs from './navigation/appNavTabs';
import {HomeScreen,PlantInfo} from './screens';

const Stack = createStackNavigator();

const App =() =>{
  return(
    <NavigationContainer>
        <Stack.Navigator
            screenOptions={{
                headerShown: false
            }}
            initialRouterName={"Main"}
          >
          <Stack.Screen name="Home" component={appNavigTabs} />
          <Stack.Screen name="PlantInfo" component={PlantInfo} />
        </Stack.Navigator>
    </NavigationContainer>
  )
}

export default App;