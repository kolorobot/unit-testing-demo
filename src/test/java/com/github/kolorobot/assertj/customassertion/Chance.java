package com.github.kolorobot.assertj.customassertion;

import java.util.List;

import static com.github.kolorobot.assertj.customassertion.Score.scoreBuilder;

class Chance implements Scorable {

    @Override
    public Score getScore(List<Dice> dice) {
        int sum = dice.stream()
                .mapToInt(die -> die.getValue())
                .sum();
        return scoreBuilder(this)
                .withValue(sum)
                .withCombination(dice)
                .build();
    }
}
