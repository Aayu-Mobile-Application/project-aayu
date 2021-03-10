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

    public List<Plant> viewEnglishPlantData() {

        List<Plant> englishDataSet = new ArrayList<>();

        for (Plant englishData : EnglishPlantDatabaseLoad.plantEnglishDatabase){
            englishDataSet.add(englishData);
        }
        return englishDataSet;
    }


    //add location
    @Override
    public void addLocation(int locationId, double longitude, double latitude, String userName, String plantName) {
        Map newLocation = new Map(locationId, plantName,latitude,longitude,userName);
        //DynamoDataLoad.locationDB.add(newLocation);
    }

    //view location
    @Override
    public List<Map> viewLocation() {

        List<Map> locationDataSet = new ArrayList<>();

        for (Map locationDB : MapDatabaseLoad.locationDatabase){
            locationDataSet.add(locationDB);
        }
        return locationDataSet;
    }

    //quiz
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

    //view plant details
    @Override
    public List<Plant> viewPlant() {
        return null;
    }
    
}
