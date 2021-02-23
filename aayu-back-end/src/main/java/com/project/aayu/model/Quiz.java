package com.project.aayu.model;

public class Quiz {

    private String user;
    private int quizScore;

    // define parameterize constructor
    public Quiz(String user, int quizScore) {
        this.user = user;
        this.quizScore = quizScore;
    }

    // define getters and setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }

    // define toString method
    @Override
    public String toString() {
        return "Quiz{" +
                "user=" + user +
                ", quizScore=" + quizScore +
                '}';
    }
}
