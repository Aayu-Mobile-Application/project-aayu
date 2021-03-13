import React, { useState, useEffect, useRef } from "react";
import {
  Text,
  View,
  TouchableOpacity,
  Image,
  StyleSheet,
  ScrollView,
  SafeAreaView,
  FlatList,
  Dimensions,
  Alert,
  ActivityIndicator,
} from "react-native";

import * as Location from "expo-location";
import CameraView from "./CameraView";

const InfoPage = (props) => {
  const [location, setLocation] = useState(null);
  const [errorMsg, setErrorMsg] = useState(null);
  const [scientificName, setScientificName] = useState("");
  const [localName, setLocalName] = useState("");
  const [familyName, setFamilyName] = useState("");
  const [plantStatus, setPlantStatus] = useState("");
  const [plantDescription, setPlantDescription] = useState("");
  const [treatments, setTreatments] = useState("");
  const [imageUrl, setImageUrl] = useState(
    "https://cdn1.iconfinder.com/data/icons/freeline/32/coda_eco_ecology_environment_flower_green_leaf_nature_paper_plant-512.png"
  );
  const [dataLoaded, setDataLoaded] = useState(false);
  const [url, setUrl] = useState("");

  let text = null;

  const [data, setData] = useState();

  useEffect(() => {
    const ac = new AbortController();
    if (props.route.params.num === 1) {
      setUrl("https://api.mocki.io/v1/5eac1e0a");
    } else if (props.route.params.num === 2) {
      setUrl("https://api.mocki.io/v1/66d3ea66");
    }
    fetch(url)
      .then((response) => response.json())
      .then((responseJson) => {
        responseJson.map((report) => {
          setScientificName(report.scientificName);
          setLocalName(report.localName);
          setFamilyName(report.familyName);
          setPlantStatus(report.plantStatus);
          setPlantDescription(report.description);
          setTreatments(report.treatments);
          setImageUrl(report.imageUrl);
        });
      })
      .then(() => setDataLoaded(true))
      .catch((error) => console.log(error));
    ac.abort();
  });

  const retakeButton = () => {
    alert("Camera View Again");
  };
  const fetchLocation = () => {
    (async () => {
      let { status } = await Location.requestPermissionsAsync();
      if (status !== "granted") {
        setErrorMsg("Permission to access location was denied");
        return;
      }

      let location = await Location.getCurrentPositionAsync({});
      setLocation(location);
      console.log("Location requested");
    })();
  };

  if (errorMsg) {
    text = errorMsg;
  } else if (location) {
    text = JSON.stringify(location);
    // if (text === null) {
    //   console.log("Error");
    // } else {

    // }
    textString = JSON.parse(text);
  }

  const dataSections = () => {
    if (!dataLoaded) {
      return (
        <ActivityIndicator
          color="#0000ff"
          size="large"
          style={styles.activityIndicator}
        />
      );
    } else {
      return (
        <View style={styles.container}>
          <View style={{ position: "absolute", left: -35 }}>
            <View style={{ top: -240, flexDirection: "row", marginLeft: 30 }}>
              <View style={styles.imageContainer}>
                <Image
                  style={styles.plantImage}
                  source={{
                    uri: imageUrl,
                  }}
                />
              </View>
              <View style={{ width: 200, marginLeft: 5, left: 40 }}>
                <Text style={styles.scientificName} key={1}>
                  {scientificName}
                </Text>
                <Text style={styles.smallDetails}>Local Name-{localName}</Text>
                <Text style={styles.smallDetails}>Family:{familyName}</Text>
                <Text style={styles.smallDetails}>Status: {plantStatus}</Text>
              </View>
            </View>
          </View>
          <View style={styles.infoContainer}>
            <ScrollView style={styles.scroller}>
              <Text style={styles.description}>Description</Text>
              <Text style={{ fontSize: 20, marginBottom: 10 }}>
                {plantDescription}
              </Text>
              <Text style={styles.description}>Treatments</Text>
              <Text style={{ fontSize: 20, marginBottom: 10 }}>
                {treatments}
              </Text>
            </ScrollView>
            <View style={styles.locationContainer}>
              <View>
                <TouchableOpacity
                  style={{ alignSelf: "center" }}
                  onPress={fetchLocation}
                >
                  <View style={styles.cameraShutter}>
                    <Image
                      source={require("../assets/icons/locationMarker.png")}
                      style={styles.cameraIcon}
                    />
                  </View>
                </TouchableOpacity>
              </View>

              <View style={{ height: 40, width: 60, right: 120, top: 0 }}>
                <TouchableOpacity
                  style={{ sleft: 32, fontSize: 20, top: -90 }}
                  onPress={() => console.log(data)}
                >
                  <Image
                    source={require("../assets/icons/retakeButton.png")}
                    style={{ height: 40, width: 40 }}
                  />
                </TouchableOpacity>
              </View>
            </View>
          </View>
        </View>
      );
    }
  };

  // props.route.params.data.map((report) => setScientificName(report.longitude));
  return <View style={styles.container}>{dataSections()}</View>;
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "column",

    justifyContent: "center",
    marginTop: 10,
  },
  locationContainer: {
    flexDirection: "column",
    backgroundColor: "#ededed",
    alignItems: "center",
    top: "10%",
    height: 120,
    width: "100%",
    borderRadius: 30,
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 15,

    marginBottom: 20,
  },
  scientificName: {
    fontSize: 23,
    fontStyle: "italic",
  },
  localName: {},
  plantImage: {
    height: 150,
    width: 150,
  },
  imageContainer: {
    backgroundColor: "white",
    borderRadius: 15,
    left: 30,
    elevation: 10,
  },
  smallDetails: {
    fontSize: 15,
    marginTop: 15,
  },
  scroller: {
    paddingLeft: 10,
    paddingRight: 10,
    width: Dimensions.get("window").width,
    top: 0,
  },
  infoContainer: {
    paddingTop: 10,
    top: 120,
    flexDirection: "column",
    backgroundColor: "white",
    borderRadius: 5,
    height: 520,
  },
  description: {
    fontSize: 30,
    left: "25%",
  },
  cameraShutter: {
    borderRadius: 50,
    height: 90,
    width: 90,
    backgroundColor: "white",
    marginBottom: 42,
    elevation: 30,
    marginLeft: 30,
    left: -14,
    top: -10,
  },
  cameraIcon: {
    height: 90,
    width: 90,
  },
});
export default InfoPage;
