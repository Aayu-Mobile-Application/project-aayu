package com.project.aayu.model;

public class Quiz {

    private User user;
    private int quizScore;

    // define parameterize constructor
    public Quiz(User user, int quizScore) {
        this.user = user;
        this.quizScore = quizScore;
    }

    // define getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
