package com.github.kolorobot.user;

public final class TestUsers {

    public static UserBuilder aUser() {
        return UserBuilder.aUser()
                .inUserRole()
                .withName("John Smith")
                .withUsername("jsmith")
                .withPassword("42xyz");
    }

    public static UserBuilder anAdmin() {
        return UserBuilder.aUser()
                .inAdminRole()
                .withName("Chris Choke")
                .withUsername("cchoke")
                .withPassword("66abc");
    }
}
