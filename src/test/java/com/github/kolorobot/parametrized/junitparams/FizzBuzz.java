package com.github.kolorobot.parametrized.junitparams;

public class FizzBuzz {

    private static final int THREE = 3;
    private static final int FIVE = 5;

    public static String fizzBuzz(int number) {
        if (isDivisibleBy(number, THREE) && isDivisibleBy(number, FIVE)) {
            return "FizzBuzz";
        }

        if (isDivisibleBy(number, THREE)) {
            return "Fizz";
        }

        if (isDivisibleBy(number, FIVE)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private static boolean isDivisibleBy(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
}
