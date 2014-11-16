package com.github.kolorobot.parametrized.junitparams;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    @Parameters
    public void returnsNumberForNumberNotDivisibleByThreeAndFive(int number) {
        assertThat(fizzBuzz.fizzBuzz(number)).isEqualTo("" + number);
    }

    // by convention name of parameters method starts with "parametersFor"
    public Object[] parametersForReturnsNumberForNumberNotDivisibleByThreeAndFive() {
        return $(
                1, 2, 4, 7, 11, 13, 14
        );
    }

    // parameters method name provided
    @Test
    @Parameters(method = "divisibleByThreeButNotFive")
    public void returnFizzForNumberDivisibleByThree(int number) {
        assertThat(fizzBuzz.fizzBuzz(number)).isEqualTo("Fizz");
    }

    public Object[] divisibleByThreeButNotFive() {
        return $(
                3, 6, 9, 12, 18, 21, 24
        );
    }

    // parameters provided directly as String array
    @Test
    @Parameters({"5", "10", "20", "25", "35", "40", "50"})
    public void returnBuzzForNumberDivisibleByFive(int number) {
        assertThat(fizzBuzz.fizzBuzz(number)).isEqualTo("Buzz");
    }

    public Object[] divisibleByFiveButNotThree() {
        return $(
                5, 10, 20, 25, 35, 40, 50
        );
    }

    @Test
    @Parameters(method = "divisibleByThreeAndFive")
    public void returnFizzBuzzForNumberDivisibleByThreeAndFive(int number) {
        assertThat(fizzBuzz.fizzBuzz(number)).isEqualTo("FizzBuzz");
    }

    public Object[] divisibleByThreeAndFive() {
        return $(
                15, 30, 45, 60, 75, 90
        );
    }

    //
    // FizzBuzz all-in-one test (100% coverage)
    //

    @Test
    @Parameters
    public void fizzBuzz(int given, String expected) {
        assertThat(fizzBuzz.fizzBuzz(given)).isEqualTo(expected);
    }

    public Object[] parametersForFizzBuzz() {
        return $(
                $(1, "1"),
                $(2, "2"),
                $(3, "Fizz"),
                $(4, "4"),
                $(5, "Buzz"),
                $(6, "Fizz"),
                $(7, "7"),
                $(10, "Buzz"),
                $(15, "FizzBuzz"),
                $(30, "FizzBuzz")
        );
    }
}