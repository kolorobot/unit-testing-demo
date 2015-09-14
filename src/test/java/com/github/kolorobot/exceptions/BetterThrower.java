package com.github.kolorobot.exceptions;

public class BetterThrower {
    public BetterThrower() throws Exception {
        throw new Exception("Constructor exception occurred");
    }
}
