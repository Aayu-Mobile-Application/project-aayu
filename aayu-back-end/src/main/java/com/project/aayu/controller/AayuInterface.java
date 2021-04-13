package com.project.aayu.controller;

import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import com.project.aayu.model.User;

import java.util.List;

public interface AayuInterface {
    // add location to the database
    void addLocation(Map newLocation);
    // get location details
    List<Map> viewLocation(String plantLocationName);
    // add new user
    void addNewUser(int userId, String userName, String userEmail);
    // view user details
    List<User> viewUser();
    // view plant details
    List<Plant> viewEnglishPlantData();

}
