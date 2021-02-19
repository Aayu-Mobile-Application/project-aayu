import React, { useState } from "react";
import {
  StyleSheet,
  View,
  Dimensions,
  TextInput,
  ActivityIndicator,
  TouchableOpacity,
  Image,
} from "react-native";
import MapView, { Marker } from "react-native-maps";

const Map = () => {
  const mapRegion = {
    latitude: 7.8731,
    longitude: 80.7718,
    latitudeDelta: 6.0,
    longitudeDelta: 0.0,
  };

  const [isLoading, setLoading] = useState(true);
  const [data, setData] = useState([]);
  const [errorOccurred, setError] = useState(false);
  const [markers, setMarkers] = useState(false);
  const [textValue, setTextValue] = useState("");

  //fetching data from the link-the json file should be very well structured
  const search = () => {
    setMarkers(true);

    fetch("https://api.mocki.io/v1/740e35e3")
      .then((response) => response.json())
      .then((json) => setData(json))
      .catch((error) => setError(true))
      .finally(() => setLoading(false));

    console.log(textValue);
  };

  const mapMarkers = () => {
    if (markers) {
      return data.map((report) => (
        <Marker
          key={report.latitude + report.longitude}
          coordinate={{
            latitude: report.latitude,
            longitude: report.longitude,
          }}
          title={report.title}
        ></Marker>
      ));
    }
  };

  const loadingWhileDataFetched = () => {
    if (!errorOccurred) {
      if (markers && isLoading) {
        return (
          <ActivityIndicator
            color="#0000ff"
            size="large"
            style={styles.activityIndicator}
          />
        );
      } else {
        return (
          <MapView
            style={styles.map}
            initialRegion={mapRegion}
            loadingEnabled={true}
          >
            {mapMarkers()}
          </MapView>
        );
      }
    } else {
      alert("Error");
    }
  };
  return (
    <View style={styles.container}>
      <View style={{ flexDirection: "row" }}></View>
      <TextInput
        style={styles.button}
        placeholder="Search for a Plant"
        onChangeText={(textInput) => setTextValue(textInput)}
        value={textValue}
      />
      <TouchableOpacity style={styles.search} onPress={search}>
        <Image
          source={require("../assets/icons/searchButtonIcon.png")}
          style={styles.searchButton}
        />
      </TouchableOpacity>

      {loadingWhileDataFetched()}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flexDirection: "row",
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
    marginTop: 0,
  },
  map: {
    zIndex: -1,
    width: Dimensions.get("window").width,
    height: Dimensions.get("window").height,
  },
  text: {
    fontSize: 30,
  },
  activityIndicator: {
    position: "absolute",
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    height: 80,
  },
  button: {
    position: "absolute",
    top: 50,
    height: 50,
    width: "90%",
    borderColor: "gray",
    elevation: 40,
    backgroundColor: "#f2f7f4",
    borderRadius: 20,
    fontSize: 20,
    paddingLeft: 10,
  },
  search: {
    position: "absolute",
    top: 48,
    left: 320,
    height: 30,
    width: 60,
    borderColor: "gray",
    elevation: 40,
    fontSize: 20,
  },
  searchButton: {
    width: 55,
    height: 55,
  },
});
export default Map;
