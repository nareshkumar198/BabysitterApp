package com.example.demoproject.model;

import java.io.Serializable;


public class User implements Serializable {

    private String city;
    private int communicationMode;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String provider;
    private String photoUrl;
    private String socialId;
    private String state;
    private String status;
    private TimeZone timeZone;
    private String zipCode;
    private boolean eulaNotCurrent;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isEulaNotCurrent() {
        return eulaNotCurrent;
    }

    public void setEulaNotCurrent(boolean eulaNotCurrent) {
        this.eulaNotCurrent = eulaNotCurrent;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
