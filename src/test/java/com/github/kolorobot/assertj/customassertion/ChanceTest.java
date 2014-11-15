package com.github.kolorobot.assertj.customassertion;

import org.junit.Test;

import java.util.List;

import static com.github.kolorobot.assertj.customassertion.DiceObjectMother.dice;
import static com.github.kolorobot.assertj.customassertion.ScoreAssertion.assertThat;

public class ChanceTest {

    private Chance chance = new Chance();

    @Test
    public void scoreIsSumOfAllDice() {
        List<Dice> rolled = dice(1, 2, 3, 4, 5);
        Score score = chance.getScore(rolled);

        assertThat(score)
                .hasValue(15)
                .hasNoReminder()
                .hasCombination(rolled);
    }
}


