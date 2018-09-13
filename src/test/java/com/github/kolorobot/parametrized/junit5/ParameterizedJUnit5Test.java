package com.github.kolorobot.parametrized.junit5;

import com.github.kolorobot.parametrized.FizzBuzz;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ParameterizedJUnit5Test {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    /**
     * Parameterized test in JUnit 5:
     * <ul>
     * <li>Add org.junit.jupiter:junit-jupiter-params:${junitJupiterVersion} dependency to the project to use parameterized test, argument providers and converters</li>
     * <li>Use @org.junit.jupiter.params.ParameterizedTest annotation to mark test as parameterized. Customize invocation display names via the name attribute. {index} -> the current invocation index (1-based), {arguments} -> the complete, comma-separated arguments list, {0}, {1}, …​ -> an individual argument.</li>
     * <li>Provide argument source. In this example @org.junit.jupiter.params.provider.ValueSource provides access to an array of literal values of certain primitive types. Exactly one type of input must be provided in this annotation.</li>
     * <li>Optionally provide additional parameters resolved by org.junit.jupiter.api.extension.ParameterResolver. Method parameters that are resolved by argument sources need to come first in the argument list.</li>
     * </ul>
     */
    @ParameterizedTest(name = "{index} => calculate({0})")
    @ValueSource(ints = {1, 2, 4, 7, 11, 13, 14})
    void returnsNumberForNumberNotDivisibleByThreeAndFive(int number, TestInfo testInfo, TestReporter testReporter) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo("" + number);
    }

    /**
     * The @org.junit.jupiter.params.provider.MethodSource refers to methods returning argument source
     */
    @ParameterizedTest(name = "{index} => calculate({0})")
    @MethodSource({"divisibleByThree", "divisibleByThreeButNotFive"})
    void returnFizzForNumberDivisibleByThree(int number) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo("Fizz");
    }

    /**
     * The method provides arguments for returnFizzForNumberDivisibleByThree and:
     * <ul>
     * <li>it must be static</li>
     * <li>it must take no arguments</li>
     * <li>it must return either Stream, Iterable, Iterator or array</li>
     * </ul>
     */
    private static Stream<Integer> divisibleByThree() {
        return Stream.of(3, 6, 9, 12);
    }

    // The returned array will be converted to a Stream
    private static String[] divisibleByThreeButNotFive() {
        return new String[]{"18", "21"};
    }


    @ParameterizedTest(name = "{index} => calculate({0}) should return {1}")
    @MethodSource("fizzBuzz")
    void fizzBuzz(int number, String expectedResult) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo(expectedResult);
    }

    /**
     * Provides multiple arguments to fizzBuzz method. Returns a stream of org.junit.jupiter.params.provider.Arguments instances
     */
    private static Stream<Arguments> fizzBuzz() {
        return Stream.of(
            Arguments.of(1, "1"),
            Arguments.of(2, "2"),
            Arguments.of(3, "Fizz"),
            Arguments.of(4, "4"),
            Arguments.of(5, "Buzz"),
            Arguments.of(6, "Fizz"),
            Arguments.of(7, "7"),
            Arguments.of(8, "8"),
            Arguments.of(9, "Fizz"),
            Arguments.of(15, "FizzBuzz")
        );
    }

    /**
     * Multiple arguments provided by 2 CSV files.
     */
    @ParameterizedTest(name = "{index} => calculate({0}) should return {1}")
    @CsvFileSource(resources = {"/fizzbuzz/fizzbuzz_1.csv", "/fizzbuzz/fizzbuzz_2.csv"}, delimiter = ';', numLinesToSkip = 1)
    void fizzBuzzCsv(int number, String expectedResult) {
        assertThat(fizzBuzz.calculate(number)).isEqualTo(expectedResult);
    }

    @Test
    void nonParameterizedTest() {
        assertThat(fizzBuzz.calculate(1)).isEqualTo("1");
    }

    @Nested
    class NestedTest {
        @ParameterizedTest(name = "{index} => calculate({0}) should return {1}")
        @CsvFileSource(resources = {"/fizzbuzz/fizzbuzz_1.csv"}, delimiter = ';')
        void fizzBuzzCsv(int number, String expectedResult) {
            assertThat(fizzBuzz.calculate(number)).isEqualTo(expectedResult);
        }
    }

}
