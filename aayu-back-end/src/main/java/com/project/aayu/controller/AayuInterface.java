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
    // view plant details - english
    List<Plant> viewEnglishPlantData();
    // view plant details - sinhala
    List<Plant> viewSinhalaPlantData();
    // view plant details - tamil
    List<Plant> viewTamilPlantData();

}
