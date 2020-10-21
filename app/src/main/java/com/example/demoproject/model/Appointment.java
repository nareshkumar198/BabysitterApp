package com.example.demoproject.model;

public class Appointment {

    private Babysitter babysitter;
    private String duration;
    private String endDateTime;
    private String familyId;
    private String id;
    private Organizer organizer;
    private String startDateTime;
    private String[] status;
    private Contact[] contacts;
    private String[] currentState;
    private String requestedDateTime;
    private String stateUpdatedAt;
    private String uniqueCode;
    private String[] skip;

    public Babysitter getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(Babysitter babysitter) {
        this.babysitter = babysitter;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public String[] getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String[] currentState) {
        this.currentState = currentState;
    }

    public String getRequestedDateTime() {
        return requestedDateTime;
    }

    public void setRequestedDateTime(String requestedDateTime) {
        this.requestedDateTime = requestedDateTime;
    }

    public String getStateUpdatedAt() {
        return stateUpdatedAt;
    }

    public void setStateUpdatedAt(String stateUpdatedAt) {
        this.stateUpdatedAt = stateUpdatedAt;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String[] getSkip() {
        return skip;
    }

    public void setSkip(String[] skip) {
        this.skip = skip;
    }
}
