package org.predjeskovic.solutionCompany.model;

public class Addresses extends Persistable{

    private String place;

    private String postCode;

    private String street;

    protected Addresses(){

    }

    public Addresses(String place, String postCode, String street) {
        this.place = place;
        this.postCode = postCode;
        this.street = street;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "place='" + place + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
