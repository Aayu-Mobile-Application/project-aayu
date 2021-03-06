package com.project.aayu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "map")
public class Map {

    @Id
    private long locationId;
    private String plantName;
    private double latitude;
    private double longitude;
    private String user;

    // define parameterize constructor
    public Map(long locationId, String plantName, double latitude, double longitude, String user) {
        this.locationId = locationId;
        this.plantName = plantName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
    }

    // getter and setter
    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
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
