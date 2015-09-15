package com.github.kolorobot.assertj.customassertion;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

class SoftScoreAssertion extends AbstractAssert<SoftScoreAssertion, Score> {

    private SoftAssertions softAssertions = new SoftAssertions();

    protected SoftScoreAssertion(Score actual) {
        super(actual, SoftScoreAssertion.class);
    }

    public static SoftScoreAssertion assertThat(Score actual) {
        return new SoftScoreAssertion(actual);
    }

    public SoftScoreAssertion isZero() {
        hasValue(Score.ZERO);
        hasNoCombination();
        return this;
    }

    public SoftScoreAssertion hasValue(int scoreValue) {
        isNotNull();
        softAssertions.assertThat(actual.getValue())
                      .as("Has score")
                      .isEqualTo(scoreValue);
        return this;
    }

    public SoftScoreAssertion hasNoReminder() {
        isNotNull();
        softAssertions.assertThat(actual.getReminder())
                      .as("Reminder is empty")
                      .isEmpty();
        return this;
    }

    public SoftScoreAssertion hasReminder(List<Dice> expected) {
        isNotNull();
        softAssertions.assertThat(actual.getReminder())
                      .as("Has reminder")
                      .isEqualTo(expected);
        return this;
    }

    private SoftScoreAssertion hasNoCombination() {
        isNotNull();
        softAssertions.assertThat(actual.getCombination())
                      .as("Combination is empty")
                      .isEmpty();
        return this;
    }

    public SoftScoreAssertion hasCombination(List<Dice> expected) {
        isNotNull();
        softAssertions.assertThat(actual.getCombination())
                      .as("Has combination")
                      .isEqualTo(expected);
        return this;
    }

    @Override
    public SoftScoreAssertion isNotNull() {
        softAssertions.assertThat(actual).isNotNull();
        return this;
    }

    public void assertAll() {
        this.softAssertions.assertAll();
    }
}
