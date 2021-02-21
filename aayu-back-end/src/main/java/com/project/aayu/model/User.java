package com.project.aayu.model;

public class User {

    //defining variables of the User class
    private int userId;
    private String nameOfUser;
    private String emailOfUser;

    //constructor
    public User(int userId, String nameOfUser, String emailOfUser) {
        this.userId = userId;
        this.nameOfUser = nameOfUser;
        this.emailOfUser = emailOfUser;
    }

    //defining getters and setter of the User class
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getEmailOfUser() {
        return emailOfUser;
    }

    public void setEmailOfUser(String emailOfUser) {
        this.emailOfUser = emailOfUser;
    }


    //define toString method
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nameOfUser='" + nameOfUser + '\'' +
                ", emailOfUser='" + emailOfUser + '\'' +
                '}';
    }
}

