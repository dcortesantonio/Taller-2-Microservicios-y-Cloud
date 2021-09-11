import React, { useContext, useState, useEffect } from 'react';
import { View, StyleSheet, ImageBackground } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';
import { Button, Text, Overlay, Input } from 'react-native-elements';
import { Context } from '../context/PaseoContext';


const HomeScreen = ({navigation}) => {

  const background = require('../../assets/homebg.png');

  const {state, deletePaseo, getAll, updatePaseo, createPaseo} = useContext(Context)

  const [visibDeleteModal, setVisibDeleteModal] = useState(false);
  const [visibUpdateModal, setVisibUpdateModal] = useState(false);
  const [visibCreateModal, setVisibCreateModal] = useState(false);

  const [textUpdated, setTextUpdated] = useState('');
  const [textDeleted, setTextDeleted] = useState('');


  const openDeleteModal = () => {
    setVisibDeleteModal(!visibDeleteModal);
  }

  const DeleteModal = () =>{
  const [idPaseo, setIdPaseo] = useState(8);

    return(
      <Overlay
        isVisible={visibDeleteModal}
        onBackdropPress={openDeleteModal}
        overlayStyle={styles.deleteModalStyle}
      >
        <TextInput
          placeholder='Ingresa el id del paseo a eliminar'
          value={idPaseo}
          onChangeText={value => setIdPaseo(value)}
          keyboardType='numeric'
          style={styles.inputStyle}
          />
        <Button
          title='Eliminar'
          buttonStyle = {styles.buttonCont}
          titleStyle = {styles.titleStyle}
          onPress={() => {
            deletePaseo({idPaseo});
            openDeleteModal();
          }}
          />
        <Text style ={{textAlign: 'center', }}>
          {textDeleted}
        </Text>

      </Overlay>
    );
  }

  const openUpdateModal = () => {
    setVisibUpdateModal(!visibUpdateModal);
  }


  const UpdateModal = () => {
    const [idPaseo, setIdPaseo] = useState(8);
    const [paseoOrigin, setPaseoOrigin] = useState('')
    const [paseoDest, setPaseoDest] = useState('');

    return (
      <Overlay
        isVisible={visibUpdateModal}
        onBackdropPress={openUpdateModal}
        overlayStyle={styles.updateModalStyle}
      >
        <TextInput
          placeholder='Id del paseo a actualizar'
          value={idPaseo}
          onChangeText={value => setIdPaseo(value)}
          keyboardType='numeric'
          style={styles.inputStyle}
          />
        <TextInput
          placeholder='Nuevo origen del paseo'
          value={paseoOrigin}
          onChangeText={value => setPaseoOrigin(value)}
          style={styles.inputStyle}
          />
        <TextInput
          placeholder='Nuevo destino del paseo'
          value={paseoDest}
          onChangeText={value => setPaseoDest(value)}
          style={styles.inputStyle}
          />
        <Button
          title='Modificar'
          buttonStyle = {styles.buttonCont}
          titleStyle = {styles.titleStyle}
          onPress={() => {
            updatePaseo({idPaseo, paseoOrigin, paseoDest});
            openUpdateModal();
          }}
          />
          <Text style ={{textAlign: 'center', }}>
            {textDeleted}
          </Text>
      </Overlay>

    );
  }


  const openCreateModal = () => {
    setVisibCreateModal(!visibCreateModal);
  }


  const CreateModal = () => {
    const [idPaseo, setIdPaseo] = useState(8);
    const [paseoOrigin, setPaseoOrigin] = useState('')
    const [paseoDest, setPaseoDest] = useState('');
    const [namePaseo, setNamePaseo] = useState('');

    return (
      <Overlay
        isVisible={visibCreateModal}
        onBackdropPress={openCreateModal}
        overlayStyle={styles.createModalStyle}
      >
        <TextInput
          placeholder='Id del paseo a crear'
          value={idPaseo}
          onChangeText={value => setIdPaseo(value)}
          keyboardType='numeric'
          style={styles.inputStyle}
          />
        <TextInput
          placeholder='Nombre del paseo'
          value={namePaseo}
          onChangeText={value => setNamePaseo(value)}
          style={styles.inputStyle}
          />
        <TextInput
          placeholder='Origen del paseo'
          value={paseoOrigin}
          onChangeText={value => setPaseoOrigin(value)}
          style={styles.inputStyle}
          />
        <TextInput
          placeholder='Destino del paseo'
          value={paseoDest}
          onChangeText={value => setPaseoDest(value)}
          style={styles.inputStyle}
          />
        <Button
          title='Guardar'
          buttonStyle = {styles.buttonCont}
          titleStyle = {styles.titleStyle}
          onPress={() => {
            createPaseo({idPaseo, paseoOrigin, paseoDest, namePaseo});
            openCreateModal();
          }}
          />
          <Text style ={{textAlign: 'center', }}>
            {textDeleted}
          </Text>
      </Overlay>

    );
  }

  return(
    <View style={{ backgroundColor: '#FFF' }}>
       <ImageBackground source={background} style={{ width: '100%', height: '100%' }}>
          <View style={styles.container}>
            <Button
              title="Paseos"
              buttonStyle = {styles.buttonCont}
              titleStyle = {styles.titleStyle}
              onPress={() => {
                getAll();
                navigation.navigate('Paseos')
              }}
              />
            <Button
              title="Borrar paseo"
              buttonStyle = {styles.buttonCont}
              titleStyle = {styles.titleStyle}
              onPress = {openDeleteModal}
              />
            <Button
              title="Actualizar paseo"
              buttonStyle = {styles.buttonCont}
              titleStyle = {styles.titleStyle}
              onPress = {openUpdateModal}
              />
            <Button
              title="Crear paseo"
              buttonStyle = {styles.buttonCont}
              titleStyle = {styles.titleStyle}
              onPress = {openCreateModal}
              />
        </View>
      <DeleteModal onClose={openDeleteModal}/>
      <UpdateModal onClose={openUpdateModal}/>
      <CreateModal onClose={openCreateModal}/>
      </ImageBackground>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    marginBottom: 80
  },
  buttonCont: {
    margin: 10,
    backgroundColor: "#91C788",
    width: 180,
    height: 40,
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    alignSelf: "center",
  },
  titleStyle: {
    color: "#FEFFDE",
    fontSize: 18,
    fontWeight: "bold",
  },
  deleteModalStyle:{
    height: 150,
    width: 330,
    borderRadius: 25,
  },
  updateModalStyle:{
    height: 250,
    width: 330,
    borderRadius: 25,
  },
  createModalStyle:{
    height: 310,
    width: 330,
    borderRadius: 25,
  },
  inputStyle:{
    fontSize: 18,
    backgroundColor: '#FEFEFE',
    margin: 15,
    textAlign: 'center'
  }

});


export default HomeScreen;
