import React, { useState } from "react";
import {
  StyleSheet,
  Text,
  View,
  TextInput,
  Image,
  TouchableNativeFeedback,
  TouchableHighlight,
  TouchableOpacity,
} from "react-native";

const Scan = (props) => {
  return (
    <View style={styles.container}>
      <Text style={styles.buttonTextHeader}>
        What kind of leaf are you scanning..?
      </Text>
      <Image
        source={require("../assets/icons/scannericon.png")}
        style={styles.scannerIcon}
      />
      <TouchableOpacity
        style={styles.buttons}
        underlayColor={"gray"}
        onPress={() => props.navigation.navigate("CameraView", { num: 1 })}
      >
        <Text style={styles.buttonText}>Healthy</Text>
      </TouchableOpacity>
      <TouchableOpacity
        style={styles.buttons}
        underlayColor={"gray"}
        onPress={() => props.navigation.navigate("CameraView", { num: 2 })}
      >
        <Text style={styles.buttonText}>Deceased</Text>
      </TouchableOpacity>
    </View>
  );
};
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#d2f5ce",
    alignItems: "center",
    justifyContent: "center",
  },
  buttons: {
    backgroundColor: "#4f9447",
    width: 300,
    height: 50,
    elevation: 30,
    borderRadius: 15,
    justifyContent: "center",
    alignItems: "center",
    marginTop: 30,
  },
  buttonText: {
    fontSize: 20,
    color: "white",
  },
  buttonTextHeader: {
    fontSize: 30,
    color: "black",
    textAlign: "center",
  },
  scannerIcon: {
    marginTop: 20,
    height: 80,
    width: 80,
  },
});

export default Scan;
