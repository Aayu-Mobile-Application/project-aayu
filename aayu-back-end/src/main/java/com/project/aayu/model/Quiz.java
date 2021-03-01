package com.project.aayu.model;

public class Quiz {

    private int quizId;
    private String user;
    private int quizScore;

    // define parameterize constructor
    public Quiz(int quizId, String user, int quizScore) {
        this.quizId = quizId;
        this.user = user;
        this.quizScore = quizScore;
    }

    // define getters and setters
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

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
                "quizId=" + quizId +
                ", user='" + user + '\'' +
                ", quizScore=" + quizScore +
                '}';
    }
}