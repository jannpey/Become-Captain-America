package com.example.fitnessapplication;

public class FBmessage {
    private String name;
    private String feedback;

    public FBmessage(){}
    public FBmessage(String name, String feedback) {
        this.name = name;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
