import React from 'react';
import {View} from 'react-native';
import {TouchableOpacity} from 'react-native-gesture-handler';
import {NavigationContainer, useNavigation} from '@react-navigation/native';
import { createStackNavigator, HeaderBackButton } from '@react-navigation/stack';
import { MaterialIcons } from '@expo/vector-icons';
import  PaseoListScreen from './src/screens/PaseosListScreen';
import  HomeScreen from './src/screens/HomeScreen';
import { navigationRef, navigate } from './src/rootNavigator';

const Stack = createStackNavigator();

const stackOptions = (nombreScreen) => {

    return ({
        headerStyle: {
            backgroundColor: '#52734D',
        },
        headerTitle: [nombreScreen],
        headerTitleStyle: {
            color: '#FEFFDE',
            fontSize: 24,
        },
      headerLeft: () => {
        if(nombreScreen==='Paseos'){
          return(
           <View style={{ marginLeft: 20 }}>
                <TouchableOpacity
            onPress={() => navigate('Home')}>
                    <MaterialIcons name="arrow-back-ios" size={28} color="#FEFFDE" />
                </TouchableOpacity>
            </View>
          )}

      }
    });
}


const AppContainer = () => {
  return(
    <NavigationContainer ref={navigationRef}>
      <Stack.Navigator>
        <Stack.Screen 
          name = 'Home'
          component = {HomeScreen}
          options = { stackOptions('Home') }
          />
        <Stack.Screen 
          name = 'Paseos'
          component = {PaseoListScreen}
          options = { stackOptions('Paseos') }
          />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default AppContainer;
