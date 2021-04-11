package com.project.aayu.api;

import com.project.aayu.controller.AayuManager;
import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import com.project.aayu.model.Quiz;
import com.project.aayu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
// add rest controller
@RestController
public class AayuAPI {

    @Autowired
    private AayuManager aayuManager;

    @GetMapping("/getLocation/{location}")
    public List<Map> getLocationDetails(@PathVariable("location") String location){
        return aayuManager.viewLocation(location);
    }

    @PostMapping("/addLocation/add")
    public void addNewLocation(@RequestBody Map newLocation){
        aayuManager.addLocation(newLocation);
    }

    @GetMapping("/getUser")
    public List<User> getUserDetails(){
        return aayuManager.viewUser();
    }

    @GetMapping("/getPlant")
    public List<Plant> getPlantInformation() {
        return aayuManager.viewEnglishPlantData();
    }

    @GetMapping("/getQuiz")
    public List<Quiz> getQuizLocation() {
        return aayuManager.viewScore();
    }


}
