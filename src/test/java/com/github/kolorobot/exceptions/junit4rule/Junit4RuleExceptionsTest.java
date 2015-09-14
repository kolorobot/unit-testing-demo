package com.github.kolorobot.exceptions.junit4rule;

import com.github.kolorobot.exceptions.MyCheckedException;
import com.github.kolorobot.exceptions.MyRuntimeException;
import com.github.kolorobot.exceptions.Thrower;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.startsWith;

public class Junit4RuleExceptionsTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Thrower thrower = new Thrower();

    @Test
    public void verifiesTypeAndMessage() {
        thrown.expect(MyRuntimeException.class);
        thrown.expectMessage("My custom runtime exception");

        thrower.throwsRuntime();
    }

    @Test
    public void throwsDifferentExceptionThanExpected() throws MyCheckedException {
        thrown.expect(MyCheckedException.class);
        thrown.expectMessage("Expected exception to be thrown");

        thrower.throwsRuntimeInsteadOfChecked();
    }

    @Test
    public void doesNotThrowExpectedException() {
        thrown.expect(MyRuntimeException.class);
        thrown.reportMissingExceptionWithMessage("No exception of %s thrown");
    }

    @Test
    public void verifiesMessageStartsWith() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(startsWith("My custom runtime"));

        thrower.throwsRuntime();
    }

    @Test
    public void verifiesMessageMatchesPattern() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(new MatchesPattern("My custom runtime .*"));

        thrower.throwsRuntime();
    }

    @Test
    public void verifiesExceptionWithCustomMatcher() {
        thrown.expect(RuntimeException.class);
        thrown.expect(new MyExceptionCodeMatcher(1));

        thrower.throwsRuntimeWithCode(1);
    }

    @Test
    public void verifiesCauseTypeAndAMessage() {
        thrown.expect(RuntimeException.class);
        thrown.expectCause(new MyCauseMatcher(IllegalStateException.class, "Illegal state"));

        thrower.throwsRuntimeWithCause();
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
