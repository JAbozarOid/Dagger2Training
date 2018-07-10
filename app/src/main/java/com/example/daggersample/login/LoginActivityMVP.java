package com.example.daggersample.login;

public interface LoginActivityMVP {

    interface View {
        String getFirstName();
        String getLastName();

        void showUserNotAvailable();
        void showInputErro();
        void showUserSavedMessage();

        void setFirstName(String fname);
        void setLastName(String lname);
    }

    interface Presenter{

        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();

    }

    interface Model{
        void createUser(String fname,String lname);
        User getUser();
    }
}
