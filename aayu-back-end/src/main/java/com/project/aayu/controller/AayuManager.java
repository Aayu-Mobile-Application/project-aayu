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
    List<Map> locationDB = new ArrayList<Map>(Collections.singleton(new Map("Mango",6.936149,79.844254, "Minura")));
    //create user arrayList
    List<Plant> plantDataBase = new ArrayList<Plant>(Collections.singleton(new Plant(1,"Idian beech","Pongamia pinnata","FABACEAE","Native","Swelling,Pains,Worm diseases,Wounds,Liver diseases,Cough,Skin diseases,Psoriasis,Rheumatoid arthritis,Constipation,Nausea,Hemorrhoids,Oral diseases","Tree to about 30 m tall; stems glabrous; stipules cucullate, 3.5-4 mm long; leaves about 5-9 foliate, the axis 6-17 cm long; leaflets (2-) 3-10 cm long, 2-5 cm wide; inflorescences racemose; flowers 12-14 mm long; petals white to pinkish; fruit glabrous, indehicent, 5-8 cm long, 2.5-3 cm wide, about 0.8-1 cm thick, sessile, 1 or 2 seeded; seeds brown, lustrous, about 2 cm long, 1 cm wide.","‌Guava")));
    //create user arrayList
    List<User> userDataBase = new ArrayList<User>(Collections.singleton(new User(1,"Admin","admin@aayu.ac.lk")));
    // create quiz arraylist
    List<Quiz> quizDatabase = new ArrayList<Quiz>(Collections.singleton(new Quiz("Minura", 72)));

    //add location
    @Override
    public void addLocation(double longitude, double latitude, String userName, String plantName) {
        Map newLocation = new Map(plantName,latitude,longitude,userName);
        locationDB.add(newLocation);
    }

    //view location
    @Override
    public List<Map> viewLocation() {
        return locationDB;
    }

    //quiz
    @Override
    public void addScore(int score, String userName) {
        Quiz newQuiz = new Quiz(userName,score);
        quizDatabase.add(newQuiz);
    }

    //view score
    @Override
    public List<Quiz> viewScore() {
        return quizDatabase;
    }

    //add user
    @Override
    public void addNewUser(int userId, String userName, String userEmail) {
    }

    //get user
    @Override
    public List<User> viewUser() {
        return userDataBase;
    }

    //view plant details
    @Override
    public List<Plant> viewPlant() {
        return plantDataBase;
    }
    
}
