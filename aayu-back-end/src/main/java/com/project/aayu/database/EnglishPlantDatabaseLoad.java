package com.project.aayu.database;

import com.project.aayu.model.Plant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EnglishPlantDatabaseLoad {


    public static List<Plant> plantEnglishDatabase = new ArrayList<>();

    public void EnglishPlantDatabaseLoad() {

        JSONParser jsonParser = new JSONParser();

        try(InputStreamReader reader = new InputStreamReader(EnglishPlantDatabaseLoad.class.getResourceAsStream("/english-dataset.json"))){
            // read the json file
            Object object = jsonParser.parse(reader);
            // put into an array
            JSONArray jsonPlantArray = (JSONArray) object;
            // load the json data
            jsonPlantArray.forEach(plant -> parsePlantObj((JSONObject) plant));

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void parsePlantObj(JSONObject plant){

        Long idOfPlant = (Long) plant.get("idOfPlant");
        String familyName = (String) plant.get("familyName");
        String description = (String) plant.get("description");
        String localName = (String) plant.get("localName");
        String scientificName = (String) plant.get("scientificName");
        String similarPlants = (String) plant.get("similarPlants");
        String statusOfPlant = (String) plant.get("statusOfPlant");
        String treatments = (String) plant.get("treatments");

        // create the plant object
        Plant englishPlantDetails = new Plant(idOfPlant, localName, scientificName, familyName, statusOfPlant, treatments, description, similarPlants);

        plantEnglishDatabase.add(englishPlantDetails);


    }



}
