package com.project.aayu.controller;

import com.project.aayu.model.Map;
import com.project.aayu.model.Plant;
import com.project.aayu.model.Quiz;
import com.project.aayu.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AayuManager implements AayuInterface{

    // create location arrayList
    List<Map> locationDB = new ArrayList<Map>(Collections.singleton(new Map("Mango",6.936149,79.844254)));

    // Map location1 = new Map("Mango",79.844254, 6.936149);

    @Override
    public void addLocation(double longitude, double latitude, String userName, String plantName) {
        //locationDB.add(location1);
    }

    @Override
    public List<Map> viewLocation() {
        addLocation(0,0,"","");
        return locationDB;
    }

    @Override
    public void addScore(int score, String userName) {

    }

    @Override
    public List<Quiz> viewScore() {
        return null;
    }

    @Override
    public void addNewUser(int userId, String userName, String userEmail) {

    }

    @Override
    public List<User> viewUser() {
        return null;
    }

    @Override
    public List<Plant> viewPlant() {
        return null;
    }
}
