package com.project.aayu.controller;

import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import com.project.aayu.model.Quiz;
import com.project.aayu.model.User;

import java.util.List;

public interface AayuInterface {
    // add location to the database
    void addLocation(double longitude, double latitude, String userName, String plantName);
    // get location details
    List<Map> viewLocation();
    // add quiz score
    void addScore(int score, String userName);
    // view quiz score
    List<Quiz> viewScore();
    // add new user
    void addNewUser(int userId, String userName, String userEmail);
    // view user details
    List<User> viewUser();
    // view plant details
    List<Plant> viewPlant();

}
