package com.github.kolorobot.parametrized.junitparams;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    @Parameters
    public void returnsNumberForNumberNotDivisibleByThreeAndFive(int number) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo("" + number);
    }

    // by convention name of parameters method starts with "parametersFor"
    public Object[] parametersForReturnsNumberForNumberNotDivisibleByThreeAndFive() {
        return new Object[]{
            1, 2, 4, 7, 11, 13, 14
        };
    }

    // parameters method name provided
    @Test
    @Parameters(method = "divisibleByThreeButNotFive")
    public void returnFizzForNumberDivisibleByThree(int number) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo("Fizz");
    }

    public Object[] divisibleByThreeButNotFive() {
        return new Object[]{
            3, 6, 9, 12, 18, 21, 24
        };
    }

    // parameters provided directly as String array
    @Test
    @Parameters({"5", "10", "20", "25", "35", "40", "50"})
    public void returnBuzzForNumberDivisibleByFive(int number) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo("Buzz");
    }

    public Object[] divisibleByFiveButNotThree() {
        return new Object[]{
            5, 10, 20, 25, 35, 40, 50
        };
    }

    @Test
    @Parameters(method = "divisibleByThreeAndFive")
    public void returnFizzBuzzForNumberDivisibleByThreeAndFive(int number) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo("FizzBuzz");
    }

    public Object[] divisibleByThreeAndFive() {
        return new Object[]{
            15, 30, 45, 60, 75, 90
        };
    }

    //
    // FizzBuzz all-in-one test (100% coverage)
    //

    @Test
    @Parameters
    public void fizzBuzz(int given, String expected) {
        assertThat(fizzBuzz.calculate(given)).isEqualTo(expected);
    }

    public Object[] parametersForFizzBuzz() {
        return new Object[]{
            new Object[]{1, "1"},
            new Object[]{2, "2"},
            new Object[]{3, "Fizz"},
            new Object[]{4, "4"},
            new Object[]{5, "Buzz"},
            new Object[]{6, "Fizz"},
            new Object[]{7, "7"},
            new Object[]{10, "Buzz"},
            new Object[]{15, "FizzBuzz"},
            new Object[]{30, "FizzBuzz"}
        };
    }
}