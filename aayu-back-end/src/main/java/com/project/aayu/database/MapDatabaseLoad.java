package com.project.aayu.database;

import com.project.aayu.model.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapDatabaseLoad {

    public static List<Map> locationDatabase = new ArrayList<>();

    public void locationDatasetLoad() {

        JSONParser jsonParser = new JSONParser();

        try (InputStreamReader reader = new InputStreamReader(EnglishPlantDatabaseLoad.class.getResourceAsStream("/location-dataset.json"))) {
            // read the json file
            Object object = jsonParser.parse(reader);
            // put into an array
            JSONArray jsonPlantArray = (JSONArray) object;
            // load the json data
            jsonPlantArray.forEach(location -> parseLocationObj((JSONObject) location));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void parseLocationObj(JSONObject location){

        Long locationId = (Long) location.get("locationId");
        String plantName = (String) location.get("plantName");
        Double latitude = (Double) location.get("latitude");
        Double longitude = (Double) location.get("longitude");
        String user = (String) location.get("user");

        // create the location object
        Map locationMap = new Map(locationId, plantName, latitude, longitude, user);

        locationDatabase.add(locationMap);


    }
}
