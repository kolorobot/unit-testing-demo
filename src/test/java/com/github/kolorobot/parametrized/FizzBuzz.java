package com.github.kolorobot.parametrized;

public class FizzBuzz {

    public String calculate(int number) {
        if (isDivisibleByThree(number) && isDivisibleByFive(number)) {
            return "FizzBuzz";
        }

        if (isDivisibleByThree(number)) {
            return "Fizz";
        }

        if (isDivisibleByFive(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private static boolean isDivisibleByThree(int dividend) {
        return isDivisibleBy(dividend, 3);
    }

    private static boolean isDivisibleByFive(int dividend) {
        return isDivisibleBy(dividend, 5);
    }

    private static boolean isDivisibleBy(int dividend, int divisor) {
        return dividend % divisor == 0;
    }
}
