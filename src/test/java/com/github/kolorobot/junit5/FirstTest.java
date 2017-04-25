package com.github.kolorobot.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.function.BiFunction;

@Tag("fast")
class FirstTest { // not a public class

    @Test
    @DisplayName("My 1st JUnit 5 test! 😎")
    void myFirstTest(TestInfo testInfo) {
        BiFunction<Integer, Integer, Integer> adder = (number, number2) -> number + number2;

        assertEquals(Integer.valueOf(2), adder.apply(1, 1), "1 + 1 should equal 2");
        assertEquals("My 1st JUnit 5 test! 😎", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
    }

}