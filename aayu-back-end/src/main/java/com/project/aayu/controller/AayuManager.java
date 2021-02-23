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

//------------------------------------------Location----------------------------------------------------------------
    
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


//------------------------------------------Add Score Of The Quiz----------------------------------------------------------------



    @Override
    public void addScore(int score, String userName) {

    }


//------------------------------------------View Score Of The Quiz----------------------------------------------------------------


    @Override
    public List<Quiz> viewScore() {
        return null;
    }


//------------------------------------------Add User----------------------------------------------------------------


    //create user arrayList
    List<User> userDataBase=new ArrayList<User>(Collections.singleton(new User(1,"Admin","admin@aayu.ac.lk")));

    
    @Override
    public void addNewUser(int userId, String userName, String userEmail) {

    }

    


//------------------------------------------View User----------------------------------------------------------------


    @Override
    public List<User> viewUser() {
        return userDataBase;
    }


//------------------------------------------Plant Derails----------------------------------------------------------------

 //create user arrayList
 List<Plant> plantDataBase=new ArrayList<Plant>(Collections.singleton(new Plant(1,"Idian beech","Pongamia pinnata","FABACEAE","Native","Swelling,Pains,Worm diseases,Wounds,Liver diseases,Cough,Skin diseases,Psoriasis,Rheumatoid arthritis,Constipation,Nausea,Hemorrhoids,Oral diseases","Tree to about 30 m tall; stems glabrous; stipules cucullate, 3.5-4 mm long; leaves about 5-9 foliate, the axis 6-17 cm long; leaflets (2-) 3-10 cm long, 2-5 cm wide; inflorescences racemose; flowers 12-14 mm long; petals white to pinkish; fruit glabrous, indehicent, 5-8 cm long, 2.5-3 cm wide, about 0.8-1 cm thick, sessile, 1 or 2 seeded; seeds brown, lustrous, about 2 cm long, 1 cm wide.","‌Guava")));

    @Override
    public List<Plant> viewPlant() {
        return plantDataBase;
    }
    
}
