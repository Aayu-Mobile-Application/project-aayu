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

    // search the plant
    @GetMapping("/location/{location}")
    public List<Map> getLocationDetails(@PathVariable("location") String location){
        return aayuManager.viewLocation(location);
    }

    // location add to server
    @PostMapping("/location/location")
    public void addNewLocation(@RequestBody Map newLocation){
        aayuManager.addLocation(newLocation);
    }

    // return english plant dataset
    @GetMapping("/plant/englishplant")
    public List<Plant> getPlantInformation() {
        return aayuManager.viewEnglishPlantData();
    }

    // return sinhala plant dataset
    @GetMapping("/plant/sinhalaplant")
    public List<Plant> getPlantInformationSinhala() {
        return aayuManager.viewSinhalaPlantData();
    }

    // return tamil plant dataset
    @GetMapping("/plant/tamilplant")
    public List<Plant> getPlantInformationTamil() {
        return aayuManager.viewTamilPlantData();
    }
}
