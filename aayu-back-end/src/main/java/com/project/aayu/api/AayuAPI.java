package com.project.aayu.api;

import com.project.aayu.controller.AayuManager;
import com.project.aayu.model.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// add rest controller
@RestController
public class AayuAPI {

    @Autowired
    private AayuManager aayuManager;

    @GetMapping("/getLocation")
    public List<Map> getLocationDetails(){
        // test the add method
        // aayuManager.addLocation(0,0,"","");
        return aayuManager.viewLocation();
    }

    @GetUser("/getUser")
    public List<User> getUserDetails(){
        return aayuManager.viewUser();
    }


    @GetPlant("/getPlant")
    public List<Plant> getPlantInformation(){
        return aayuManager.viewPlant();
    }





}
