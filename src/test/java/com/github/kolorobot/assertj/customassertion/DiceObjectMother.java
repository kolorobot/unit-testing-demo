package com.github.kolorobot.assertj.customassertion;

import java.util.ArrayList;
import java.util.List;

public class DiceObjectMother {
    public static List<Dice> dice(int... expectedValues) {
        List<Dice> rolled = new ArrayList<>();
        for (int value : expectedValues) {
            rolled.add(new Dice.Builder().withValue(value).build());
        }
        return rolled;
    }

    public static List<Dice> reminder(int... expectedValues) {
        return dice(expectedValues);
    }

    public static List<Dice> combination(int... expectedValues) {
        return dice(expectedValues);
    }
}
