package com.project.aayu.model;

public class Map {

    private String plantName;
    private double latitude;
    private double longitude;
    private String user;


    // define parameterize constructor
    public Map(String plantName, double latitude, double longitude, String user) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.plantName = plantName;
        this.user = user;
    }

    // getter and setter
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    // deine toString method
    @Override
    public String toString() {
        return "Map{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", user=" + user +
                ", plantName='" + plantName + '\'' +
                '}';
    }
}
