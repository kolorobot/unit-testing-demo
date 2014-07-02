package com.github.kolorobot.testdata;

public class RegistrationsObjectMother {

    public static Register registration(String username, String password, String confirmedPassword) {
        return new Register(username, password, confirmedPassword);
    }

    public static Register registrationWithNoPassword(String username) {
        return new Register(username);
    }
}
