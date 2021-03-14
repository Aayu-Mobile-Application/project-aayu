import React, { useState, useEffect, useRef } from "react";
import { Text, View, TouchableOpacity, Image, StyleSheet } from "react-native";
import { Camera } from "expo-camera";

const CameraView = (props) => {
  const [hasPermission, setHasPermission] = useState(null);
  const [clickPhoto, setClickPhoto] = useState(null);
  const [flashMode, setFlashMode] = React.useState("off");

  let photo = null;

  useEffect(() => {
    (async () => {
      const { status } = await Camera.requestPermissionsAsync();
      setHasPermission(status === "granted");
    })();
  }, []);
  if (hasPermission === null) {
    return <View />;
  }
  if (hasPermission === false) {
    return <Text>No access to camera</Text>;
  }

  const __handleFlashMode = () => {
    if (flashMode === "on") {
      setFlashMode("off");
    } else if (flashMode === "off") {
      setFlashMode("on");
    } else {
      setFlashMode("auto");
    }
    console.log("flasher");
  };

  return (
    <View style={{ flex: 1 }}>
      <Camera
        flashMode={flashMode}
        style={{ flex: 1 }}
        ref={(ref) => {
          setClickPhoto(ref);
        }}
      >
        <View style={styles.shutterContainer}>
          <TouchableOpacity
            onPress={__handleFlashMode}
            style={styles.flashMode}
          >
            <Image
              source={require("../assets/icons/cameraFlasher.png")}
              style={styles.cameraFlasher}
            />
          </TouchableOpacity>
          <TouchableOpacity
            style={{ alignSelf: "center" }}
            onPress={() =>
              props.navigation.navigate("InfoPage", {
                num: props.route.params.num,
              })
            }
            // onPress={async () => {
            //   if (clickPhoto) {
            //     photo = await clickPhoto.takePictureAsync();
            //     console.log("photo");
            //     props.navigation.navigate("InfoPage", { photo, data });
            //   }
            //   console.log(props.route.params.num);
            // }}
          >
            <View style={styles.cameraShutter}>
              <Image
                source={require("../assets/icons/cameraIcon.png")}
                style={styles.cameraIcon}
              />
            </View>
          </TouchableOpacity>
        </View>
      </Camera>
    </View>
  );
};

const styles = StyleSheet.create({
  cameraIcon: {
    height: 80,
    width: 80,
  },
  cameraFlasher: {
    height: 40,
    width: 40,
  },
  flashMode: {
    right: 80,
    bottom: -10,
    marginBottom: 42,
    paddingLeft: 0,
  },
  cameraShutter: {
    borderWidth: 2,
    borderRadius: 50,
    borderColor: "black",
    height: 90,
    width: 90,
    backgroundColor: "#d9d9d9",
    marginBottom: 42,
    elevation: 30,
    marginLeft: 30,
  },
  shutterContainer: {
    flexDirection: "row-reverse",
    backgroundColor: "white",
    top: "165%",
    height: 150,
    width: "100%",
    borderRadius: 20,
    justifyContent: "center",
    alignItems: "center",
  },
});

export default CameraView;
