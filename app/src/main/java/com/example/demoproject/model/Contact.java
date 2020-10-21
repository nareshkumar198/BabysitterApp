package com.example.demoproject.model;

public class Contact {
    private ContactMethod contactMethod;
    private String firstName;
    private String id;
    private String lastContacted;
    private String lastName;
    private int rank;
    private String[] state;

    public ContactMethod getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(ContactMethod contactMethod) {
        this.contactMethod = contactMethod;
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

    public String getLastContacted() {
        return lastContacted;
    }

    public void setLastContacted(String lastContacted) {
        this.lastContacted = lastContacted;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String[] getState() {
        return state;
    }

    public void setState(String[] state) {
        this.state = state;
    }
}
