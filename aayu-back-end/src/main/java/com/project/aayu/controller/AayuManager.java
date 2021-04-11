package com.project.aayu.controller;

import com.project.aayu.AayuApplication;
import com.project.aayu.database.EnglishPlantDatabaseLoad;
import com.project.aayu.database.MapDatabaseLoad;
import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import com.project.aayu.model.Quiz;
import com.project.aayu.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AayuManager implements AayuInterface{

    // return english data set

    public AayuManager(){
        EnglishPlantDatabaseLoad databaseLoad = new EnglishPlantDatabaseLoad();
        MapDatabaseLoad mapDatabaseLoad = new MapDatabaseLoad();

        databaseLoad.plantDataLoad();
        mapDatabaseLoad.locationDatasetLoad();
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
        List<Map> locationDataSet = new ArrayList<>();

        for (Map locationDB : MapDatabaseLoad.locationDatabase){
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
