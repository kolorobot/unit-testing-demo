package com.github.kolorobot.assertj.customassertion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Dice implements Comparable<Dice> {

    private static final int SIDES_COUNT = 6;

    private final int value;

    Dice() {
        this(0);
    }

    Dice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Dice roll() {
        Random random = new Random();
        int randomValue = random.nextInt(SIDES_COUNT) + 1;
        return new Builder().withValue(randomValue).build();
    }

    public static List<Dice> roll(int numberOfDice) {
        List<Dice> dice = new ArrayList<>(numberOfDice);
        for (int i = 0; i < numberOfDice; i++) {
            dice.add(roll());
        }
        return dice;
    }

    public static List<Dice> reminder(List<Dice> rolled, List<Dice> combination) {
        ArrayList<Dice> diceCopy = new ArrayList<>(rolled);
        diceCopy.removeAll(combination);
        return diceCopy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dice{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dice dice = (Dice) o;

        if (value != dice.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(Dice other) {
        return Integer.compare(this.getValue(), other.getValue());
    }

    public static class Builder {

        private int value;

        public Builder withValue(int value) {
            this.value = value;
            return this;
        }

        public Dice build() {
            return new Dice(value);
        }
    }
}
