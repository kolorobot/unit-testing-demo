package com.github.kolorobot.exceptions.junit4rule;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class MyCauseMatcher extends TypeSafeMatcher<Throwable> {

    private final Class<? extends Throwable> expectedType;
    private final String expectedMessage;

    public MyCauseMatcher(Class<? extends Throwable> expectedType, String expectedMessage) {
        this.expectedType = expectedType;
        this.expectedMessage = expectedMessage;
    }

    @Override
    protected boolean matchesSafely(Throwable item) {
        return item.getClass().isAssignableFrom(expectedType)
            && item.getMessage().contains(expectedMessage);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("expects type ")
                   .appendValue(expectedType)
                   .appendText(" and a message ")
                   .appendValue(expectedMessage);
    }
}
