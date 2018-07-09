package com.example.daggersample.daggersample;

public class Contact {

    private String mail;

    public Contact() {
        this.mail = "No Contact";
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void deleteMail(){
        this.mail = null;
    }
}
