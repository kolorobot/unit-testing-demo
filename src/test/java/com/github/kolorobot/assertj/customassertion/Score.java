package com.github.kolorobot.assertj.customassertion;

import java.util.Collections;
import java.util.List;

class Score {
    public static final int ZERO = 0;
    private final List<Dice> combination;
    private final List<Dice> reminder;
    private int value = ZERO;

    private Score(int value, List<Dice> combination, List<Dice> reminder) {
        this.value = value;
        this.combination = Collections.unmodifiableList(combination);
        this.reminder = Collections.unmodifiableList(reminder);
    }

    public static Builder scoreBuilder() {
        return new Builder();
    }

    public int getValue() {
        return value;
    }

    public List<Dice> getReminder() {
        return reminder;
    }

    public List<Dice> getCombination() {
        return combination;
    }

    public boolean isGreaterThanZero() {
        return getValue() > ZERO;
    }

    public static class Builder {

        private int value = Score.ZERO;
        private List<Dice> combination = Collections.emptyList();
        private List<Dice> reminder = Collections.emptyList();

        private Builder() {

        }

        public Builder withValue(int value) {
            this.value = value;
            return this;
        }

        public Builder withCombination(List<Dice> combination) {
            this.combination = combination;
            return this;
        }

        public Builder withReminder(List<Dice> reminder) {
            this.reminder = reminder;
            return this;
        }

        public Builder zero(List<Dice> reminder) {
            this.reminder = reminder;
            this.value = ZERO;
            return this;
        }

        public Score build() {
            return new Score(value, combination, reminder);
        }
    }
}
