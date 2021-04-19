package com.project.aayu.controller;

import com.project.aayu.Repository.LocationRepository;
import com.project.aayu.database.EnglishPlantDatabaseLoad;
import com.project.aayu.database.MapDatabaseLoad;
import com.project.aayu.database.SinhalaPlantDatabaseLoad;
import com.project.aayu.database.TamilPlantDatabaseLoad;
import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AayuManager implements AayuInterface{

    @Autowired
    private LocationRepository locationRepository;

    // create aayu manager constructor for load plant database
    public AayuManager(){
        EnglishPlantDatabaseLoad englishPlantDatabaseLoad = new EnglishPlantDatabaseLoad();
        englishPlantDatabaseLoad.EnglishPlantDatabaseLoad();
        SinhalaPlantDatabaseLoad sinhalaPlantDatabaseLoad=new SinhalaPlantDatabaseLoad();
        sinhalaPlantDatabaseLoad.SinhalaPlantDatabaseLoad();
        TamilPlantDatabaseLoad tamilPlantDatabaseLoad=new TamilPlantDatabaseLoad();
        tamilPlantDatabaseLoad.TamilPlantDatabaseLoad();
    }

    @Override
    public List<Plant> viewEnglishPlantData() {
        List<Plant> englishDataSet = new ArrayList<>();

        for (Plant englishData : EnglishPlantDatabaseLoad.plantEnglishDatabase){
            englishDataSet.add(englishData);
        }
        return englishDataSet;
    }

    //Aayu sinhala plant information
    @Override
    public List<Plant> viewSinhalaPlantData() {
        List<Plant> sinhalaDataSet = new ArrayList<>();

        for (Plant sinhalaData : SinhalaPlantDatabaseLoad.plantSinhalaDatabase){
            sinhalaDataSet.add(sinhalaData);
        }
        return sinhalaDataSet;
    }


    //Aayu tamil plant information
    @Override
    public List<Plant> viewTamilPlantData() {
        List<Plant> tamilDataSet = new ArrayList<>();

        for (Plant tamilData : TamilPlantDatabaseLoad.plantTamilDatabase){
            tamilDataSet.add(tamilData);
        }
        return tamilDataSet;
    }



    //add location details
    @Override
    public void addLocation(Map newLocation) {
        Map newMap = new Map(newLocation.getLocationId(), newLocation.getPlantName(), newLocation.getLatitude(), newLocation.getLongitude(), newLocation.getUser());
        locationRepository.save(newMap);
    }

    //view location details
    @Override
    public List<Map> viewLocation(String plantLocationName) {
        // create temp array list
        List<Map> locationDataSet = new ArrayList<>();
        // create map database object
        MapDatabaseLoad mapDatabaseLoad = new MapDatabaseLoad();
        for (Map locationDB : locationRepository.findAll()){
            // check plant is in the database
            if (locationDB.getPlantName().equalsIgnoreCase(plantLocationName)) {
                // add plant to the plant database
                locationDataSet.add(locationDB);
            }
        }

        return locationDataSet;
    }

    
}
