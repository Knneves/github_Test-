package com.diogomendes.sqldatabase1;

public class Card {
    private String id;
    private String name;
    private String email;
    private String job;
    private String degree;
    private String phoneNumber;
    private String linkedin;
    private int img;


    public Card() {
    }

    public Card(String id, String name, String email, String job, String degree, String phoneNumber, String linkedin, int img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.job = job;
        this.degree = degree;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.linkedin = linkedin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree){this.degree = degree;}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getLinkedin() {return linkedin; }
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
