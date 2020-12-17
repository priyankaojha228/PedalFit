package com.example.pedalfit;

public class Users {
    String Email;
    String Name;
    String Phone;
    Integer rides;
    String Milestone;
    String Distance;
    Integer hrs;

    public Users() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Integer getRides() {
        return rides;
    }

    public void setRides(Integer rides) {
        this.rides = rides;
    }

    public String getMilestone() {
        return Milestone;
    }

    public void setMilestone(String milestone) {
        Milestone = milestone;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public Integer getHrs() {
        return hrs;
    }

    public void setHrs(Integer hrs) {
        this.hrs = hrs;
    }
}
