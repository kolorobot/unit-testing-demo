package com.github.kolorobot.exceptions.junit4rule;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.startsWith;

public class Junit4RuleExceptionsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void verifiesTypeAndMessage() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Runtime exception occurred");

        throw new RuntimeException("Runtime exception occurred");
    }

    @Test
    public void verifiesMessageStartsWith() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(startsWith("Illegal argument:"));

        throw new RuntimeException("Illegal argument: i must be <= 0");
    }

    @Test
    public void verifiesMessageMatchesPattern() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(new MatchesPattern("[Ii]llegal .*"));

        throw new RuntimeException("Illegal argument: i must be <= 0");
    }

    @Test
    public void verifiesCustomException() {
        thrown.expect(RuntimeException.class);
        thrown.expect(new ExceptionCodeMatcher(1));

        throw new CustomException(1);
    }

    @Test
    public void verifiesCauseTypeAndAMessage() {
        thrown.expect(RuntimeException.class);
        thrown.expectCause(new CauseMatcher(IllegalStateException.class, "Illegal state"));

        throw new RuntimeException("Runtime exception occurred",
                new IllegalStateException("Illegal state"));
    }


    private class MatchesPattern extends TypeSafeMatcher<String> {
        private String pattern;

        public MatchesPattern(String pattern) {
            this.pattern = pattern;
        }

        @Override
        protected boolean matchesSafely(String item) {
            return item.matches(pattern);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("matches pattern ")
                    .appendValue(pattern);
        }

        @Override
        protected void describeMismatchSafely(String item, Description mismatchDescription) {
            mismatchDescription.appendText("does not match");
        }
    }

}
