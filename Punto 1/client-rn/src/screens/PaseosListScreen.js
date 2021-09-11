import React, { useContext, useState, useEffect } from 'react';
import { View, Text, StyleSheet, ImageBackground} from 'react-native';
import { color } from 'react-native-elements/dist/helpers';
import { FlatList, ScrollView } from 'react-native-gesture-handler';
import { Context } from '../context/PaseoContext';

const PaseosListScreen = ({navigation}) => {

  const {state, getAll} = useContext(Context);
  const background = require('../../assets/paseosbf-2.png');

  useEffect(() =>{
    getAll();
  }, [state.paseos.length]);

  return(
    <View style={{backgroundColor: "#FFF"}}>
      <ImageBackground source={background} style={{ width: '100%', height: '100%' }}>
      <ScrollView showsVerticalScrollIndicator={false}>
        <FlatList
          nestedScrollEnabled={true}
          style={{ marginBottom: 0 }}
          showsVerticalScrollIndicator={false}
          data={state.paseos}
          keyExtractor={(paseo) => paseo._id}
          renderItem={({ item }) => {
            return(
              <View style={styles.roundCard}>
                <Text style={styles.nameStyle}>
                        {item.name}
                    </Text>
                <View style={styles.contHor}>
                  <Text style={styles.param}>
                    Origen:
                  </Text>
                  <Text style={styles.normalStyle}>
                        {item.origin}
                  </Text>
                </View>
                <View style={styles.contHor}>
                  <Text style={styles.param}>
                    Destino:
                  </Text>
                  <Text style={styles.normalStyle}>
                          {item.origin}
                  </Text>
                </View>
                <View style={styles.contHor}>
                  <Text style={styles.param}>
                    Fecha:
                  </Text>
                  <Text style={styles.dateStyle}>
                          {item.origin}
                  </Text>
                </View>
              </View>
            );
          }}
        />
      </ScrollView>
    </ImageBackground>
    </View>
  );
}

const styles = StyleSheet.create({
  roundCard:{
    marginHorizontal: 20,
    marginVertical: 8,
    backgroundColor: "#FEFFDE",
    borderRadius: 10,
    flexDirection: "column",
    justifyContent: 'space-between'
  },
  contHor: {
    margin: 8,
    flexDirection: 'row',
    color: '#52734D'
  },
  nameStyle:{
    textAlign: 'center',
    fontSize: 22,
    fontWeight: 'bold',
    marginTop: 8,
    color: '#52734D'
  },
  param: {
    marginHorizontal: 8,
    fontWeight: '600'
  }
});


export default PaseosListScreen;


