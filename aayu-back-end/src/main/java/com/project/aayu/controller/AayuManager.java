package com.project.aayu.controller;

import com.project.aayu.database.EnglishPlantDatabaseLoad;
import com.project.aayu.database.MapDatabaseLoad;
import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import com.project.aayu.model.Quiz;
import com.project.aayu.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AayuManager implements AayuInterface{
    
    // create aayu manager constructor for load plant database
    public AayuManager(){
        EnglishPlantDatabaseLoad englishPlantDatabaseLoad = new EnglishPlantDatabaseLoad();
        englishPlantDatabaseLoad.EnglishPlantDatabaseLoad();
    }

    @Override
    public List<Plant> viewEnglishPlantData() {
        List<Plant> englishDataSet = new ArrayList<>();

        for (Plant englishData : EnglishPlantDatabaseLoad.plantEnglishDatabase){
            englishDataSet.add(englishData);
        }
        return englishDataSet;
    }


    //add location details
    @Override
    public void addLocation(Map newLocation) {
        MapDatabaseLoad mapDatabaseLoad = new MapDatabaseLoad();
        mapDatabaseLoad.newLocationDataset(newLocation.getLocationId(),newLocation.getPlantName(),newLocation.getLatitude(),newLocation.getLongitude(),newLocation.getUser());
    }

    //view location details
    @Override
    public List<Map> viewLocation(String plantLocationName) {
        // create temp array list
        List<Map> locationDataSet = new ArrayList<>();
        // create map database object
        MapDatabaseLoad mapDatabaseLoad = new MapDatabaseLoad();
        for (Map locationDB : mapDatabaseLoad.mapDatabaseLoad()){
            // check plant is in the database
            if (locationDB.getPlantName().equalsIgnoreCase(plantLocationName)) {
                // add plant to the plant database
                locationDataSet.add(locationDB);
            }
        }

        return locationDataSet;
    }

    //add the quiz details
    @Override
    public void addScore(int quizId, int score, String userName) {
        Quiz newQuiz = new Quiz(quizId, userName, score);
        //quizDatabase.add(newQuiz);
    }

    //view score
    @Override
    public List<Quiz> viewScore() {
        return null;
   }

    //add user
    @Override
    public void addNewUser(int userId, String userName, String userEmail) {

    }

    //get user
    @Override
    public List<User> viewUser() {
        return null;
    }


    
}
