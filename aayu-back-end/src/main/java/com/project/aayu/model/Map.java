package com.project.aayu.model;

public class Map {

    private int locationId;
    private String plantName;
    private double latitude;
    private double longitude;
    private String user;

    // define parameterize constructor
    public Map(int locationId, String plantName, double latitude, double longitude, String user) {
        this.locationId = locationId;
        this.plantName = plantName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
    }

    // getter and setter
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    // define toString method
    @Override
    public String toString() {
        return "Map{" +
                "locationId=" + locationId +
                ", plantName='" + plantName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", user='" + user + '\'' +
                '}';
    }
}
