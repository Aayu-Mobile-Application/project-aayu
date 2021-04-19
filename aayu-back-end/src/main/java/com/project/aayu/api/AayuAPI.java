package com.project.aayu.api;

import com.project.aayu.controller.AayuManager;
import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import com.project.aayu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// add rest controller
@RestController
@CrossOrigin(origins = "*")
public class AayuAPI {

    @Autowired
    private AayuManager aayuManager;

    @GetMapping("/location/{location}")
    public List<Map> getLocationDetails(@PathVariable("location") String location){
        return aayuManager.viewLocation(location);
    }

    @PostMapping("/location/add")
    public void addNewLocation(@RequestBody Map newLocation){
        aayuManager.addLocation(newLocation);
    }

    @GetMapping("/user")
    public List<User> getUserDetails(){
        return aayuManager.viewUser();
    }

    //english-plant
    @GetMapping("/englishplant")
    public List<Plant> getPlantInformation() {
        return aayuManager.viewEnglishPlantData();
    }

    //sinhala-plant
    @GetMapping("/sinhalaplant")
    public List<Plant> getPlantInformationSinhala() {
        return aayuManager.viewSinhalaPlantData();
    }

    //tamil-plant
    @GetMapping("/tamilplant")
    public List<Plant> getPlantInformationTamil() {
        return aayuManager.viewTamilPlantData();
    }
}
