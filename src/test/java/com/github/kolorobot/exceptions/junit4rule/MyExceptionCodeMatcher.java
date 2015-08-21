package com.github.kolorobot.exceptions.junit4rule;

import com.github.kolorobot.exceptions.MyRuntimeException;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class MyExceptionCodeMatcher extends TypeSafeMatcher<MyRuntimeException> {

    private int expectedCode;

    public MyExceptionCodeMatcher(int expectedCode) {
        this.expectedCode = expectedCode;
    }

    @Override
    protected boolean matchesSafely(MyRuntimeException item) {
        return item.getCode() == expectedCode;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("expects code ")
                .appendValue(expectedCode);
    }

    @Override
    protected void describeMismatchSafely(MyRuntimeException item, Description mismatchDescription) {
        mismatchDescription.appendText("was ")
                .appendValue(item.getCode());
    }
}
