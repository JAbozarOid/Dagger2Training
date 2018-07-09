package com.example.daggersample.daggersample;

import javax.inject.Inject;

// کلاس user به کلاس contact وابستگی دارد بنابراین باید برای user یک ماژول بنویسیم
public class User {

    private Contact contact;

    @Inject // یعنی اعلام میکنیم که ما توی این constructor یک وابستگی داریم (که همون Contact هست).
    public User(Contact contact) {
        this.contact = contact;
    }

    public void deleteUserMail(){
        contact.deleteMail();
    }

    public String getUserContact() {
        return contact.getMail();
    }

    public void setUserContact(String mail) {
        this.contact.setMail(mail);
    }
}
