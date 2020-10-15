package com.example.demoproject.model;

public class Babysitter {

    private int communicationMode;
    private String email;
    private String familyId;
    private String firstName;
    private String id;
    private String lastName;
    private String phone;
    private int ranking;

    public int getCommunicationMode() {
        return communicationMode;
    }

    public void setCommunicationMode(int communicationMode) {
        this.communicationMode = communicationMode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
