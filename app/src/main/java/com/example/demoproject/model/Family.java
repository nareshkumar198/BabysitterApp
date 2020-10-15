package com.example.demoproject.model;

public class Family {
    private Babysitter[] babySitters;
    private String id;
    private String name;
    private String primaryEmail;

    public Babysitter[] getBabySitters() {
        return babySitters;
    }

    public void setBabySitters(Babysitter[] babySitters) {
        this.babySitters = babySitters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }
}
