package com.project.aayu.model;

public class Map {

    private double longitude;
    private double latitude;
    private User user;
    private String plantName;

    // define parameterize constructor
    public Map(double longitude, double latitude, User user, String plantName) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.user = user;
        this.plantName = plantName;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
