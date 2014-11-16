package com.github.kolorobot.basic;

class Register {

    private final String password;
    private final String confirmedPassword;

    public static Builder builder() {
        return new Builder();
    }

    private Register(String password, String confirmedPassword) {
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    String getPassword() {
        return password;
    }

    String getConfirmedPassword() {
        return confirmedPassword;
    }

    static class Builder {

        private String password;
        private String confirmedPassword;

        Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        Builder withConfirmedPassword(String confirmedPassword) {
            this.confirmedPassword = confirmedPassword;
            return this;
        }

        Register build() {
            return new Register(password, confirmedPassword);
        }
    }
}
