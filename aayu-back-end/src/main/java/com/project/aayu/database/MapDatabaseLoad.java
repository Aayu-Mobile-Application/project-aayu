package com.project.aayu.database;

import com.project.aayu.model.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapDatabaseLoad {

    public static List<Map> locationDatabase = new ArrayList<>();
    File file;
    FileWriter writer;

    public void locationDatasetLoad() {

        JSONParser jsonParser = new JSONParser();

        try (InputStreamReader reader = new InputStreamReader(MapDatabaseLoad.class.getResourceAsStream("/location-dataset.json"))) {
            // read the json file
            Object object = jsonParser.parse(reader);
            // put into an array
            JSONArray jsonPlantArray = (JSONArray) object;
            // load the json data
            jsonPlantArray.forEach(location -> parseLocationObj((JSONObject) location));

        } catch (ParseException | IOException e) {
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

    public void newLocationDataset(long locationId, String plantName, double latitude, double longitude, String user){

        JSONParser jsonParser = new JSONParser();

        try (InputStreamReader reader = new InputStreamReader(EnglishPlantDatabaseLoad.class.getResourceAsStream("/location-dataset.json"))) {
            // read the json file
            Object object = jsonParser.parse(reader);
            // put into an array
            JSONArray jsonPlantArray = (JSONArray) object;
            //jsonPlantArray.add(object);

            System.out.println(jsonPlantArray);
            JSONObject obj = new JSONObject();

            obj.put("locationId",locationId);
            obj.put("plantName",plantName);
            obj.put("latitude",latitude);
            obj.put("longitude",longitude);
            obj.put("user", user);

            jsonPlantArray.add(obj);
            System.out.println(jsonPlantArray);


            URL resourceUrl = EnglishPlantDatabaseLoad.class.getResource("/location-dataset.json");
            //System.out.println(resourceUrl);
            file = new File(resourceUrl.toURI());
            writer = new FileWriter(file);
            writer.write(jsonPlantArray.toString());
            writer.flush();
            writer.close();
            System.out.println(obj);
        } catch (ParseException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }






    }

}
