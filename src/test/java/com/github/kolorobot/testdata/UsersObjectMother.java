package com.github.kolorobot.testdata;

public final class UsersObjectMother {

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
