package com.example.firebasedatabasestorage;

public class DataViewModel {
        private String name;
        private String email;
        private String phNo;
        private String gender;

    public DataViewModel(String name, String email, String phNo, String gender) {
        this.name = name;
        this.email = email;
        this.phNo = phNo;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
