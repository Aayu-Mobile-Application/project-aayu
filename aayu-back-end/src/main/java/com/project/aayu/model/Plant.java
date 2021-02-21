package com.project.aayu.model;
public class Plant {

    //variables of Plant class
    private int idOfPlant;
    private String localName;
    private String scientificName;
    private String familyName;
    private String statusOfPlant;
    private String treatments;
    private String description;
    private String similarPlants;

    //constructor
    public Plant(int idOfPlant, String localName, String scientificName, String familyName, String statusOfPlant, String treatments, String description, String similarPlants) {
        this.idOfPlant = idOfPlant;
        this.localName = localName;
        this.scientificName = scientificName;
        this.familyName = familyName;
        this.statusOfPlant = statusOfPlant;
        this.treatments = treatments;
        this.description = description;
        this.similarPlants = similarPlants;
    }

    //getters and setters of class Plant
    public int getIdOfPlant() {
        return idOfPlant;
    }

    public void setIdOfPlant(int idOfPlant) {
        this.idOfPlant = idOfPlant;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getStatusOfPlant() {
        return statusOfPlant;
    }

    public void setStatusOfPlant(String statusOfPlant) {
        this.statusOfPlant = statusOfPlant;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSimilarPlants() {
        return similarPlants;
    }

    public void setSimilarPlants(String similarPlants) {
        this.similarPlants = similarPlants;
    }


    //define toString method
    @Override
    public String toString() {
        return "Plant{" +
                "idOfPlant=" + idOfPlant +
                ", localName='" + localName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", statusOfPlant='" + statusOfPlant + '\'' +
                ", treatments='" + treatments + '\'' +
                ", description='" + description + '\'' +
                ", similarPlants='" + similarPlants + '\'' +
                '}';
    }
}
