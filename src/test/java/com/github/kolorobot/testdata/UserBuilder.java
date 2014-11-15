package com.github.kolorobot.testdata;

public class UserBuilder {

    private String username;
    private String password;
    private String role;
    private String name;

    private UserBuilder() {
    }

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder inUserRole() {
        this.role = "ROLE_USER";
        return this;
    }

    public UserBuilder inAdminRole() {
        this.role = "ROLE_ADMIN";
        return this;
    }

    public UserBuilder inRole(String role) {
        this.role = role;
        return this;
    }

    public UserBuilder but() {
        return UserBuilder
                .aUser()
                .inRole(role)
                .withName(name)
                .withPassword(password)
                .withUsername(username);
    }

    public User build() {
        User user = new User(username, password, role);
        user.setName(name);
        return user;
    }
}