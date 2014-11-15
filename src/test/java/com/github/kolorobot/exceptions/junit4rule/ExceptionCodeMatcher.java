package com.github.kolorobot.exceptions.junit4rule;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class ExceptionCodeMatcher extends TypeSafeMatcher<CustomException> {

    private int expectedCode;

    public ExceptionCodeMatcher(int expectedCode) {
        this.expectedCode = expectedCode;
    }

    @Override
    protected boolean matchesSafely(CustomException item) {
        return item.getCode() == expectedCode;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("expects code ")
                .appendValue(expectedCode);
    }

    @Override
    protected void describeMismatchSafely(CustomException item, Description mismatchDescription) {
        mismatchDescription.appendText("was ")
                .appendValue(item.getCode());
    }
}
