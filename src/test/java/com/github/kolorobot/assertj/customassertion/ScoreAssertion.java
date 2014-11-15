package com.github.kolorobot.assertj.customassertion;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.List;

class ScoreAssertion extends AbstractAssert<ScoreAssertion, Score> {

    protected ScoreAssertion(Score actual) {
        super(actual, ScoreAssertion.class);
    }

    public static ScoreAssertion assertThat(Score actual) {
        return new ScoreAssertion(actual);
    }

    public ScoreAssertion isZero() {
        hasValue(Score.ZERO);
        hasNoCombination();
        return this;
    }

    public ScoreAssertion hasValue(int scoreValue) {
        isNotNull();
        if (actual.getValue() != scoreValue) {
            failWithMessage("Expected score to be <%s>, but was <%s>",
                    scoreValue, actual.getValue());
        }
        return this;
    }

    public ScoreAssertion hasNoReminder() {
        isNotNull();
        if (!actual.getReminder().isEmpty()) {
            failWithMessage("Reminder is not empty");
        }
        return this;
    }

    public ScoreAssertion hasReminder(List<Dice> expected) {
        isNotNull();
        Assertions.assertThat(actual.getReminder())
                .containsExactly(expected.toArray(new Dice[0]));
        return this;
    }

    private ScoreAssertion hasNoCombination() {
        isNotNull();
        if (!actual.getCombination().isEmpty()) {
            failWithMessage("Combination is not empty");
        }
        return this;
    }

    public ScoreAssertion hasCombination(List<Dice> expected) {
        isNotNull();
        Assertions.assertThat(actual.getCombination())
                .containsExactly(expected.toArray(new Dice[0]));
        return this;
    }
}
