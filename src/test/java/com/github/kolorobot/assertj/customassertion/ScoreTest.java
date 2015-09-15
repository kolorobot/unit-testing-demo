package com.github.kolorobot.assertj.customassertion;

import org.junit.Test;

import java.util.List;

import static com.github.kolorobot.assertj.customassertion.DiceObjectMother.dice;

public class ScoreTest {

    @Test
    public void verifiesScoreWithCustomAssertion() {
        List<Dice> rolled = dice(1, 2, 3, 4, 5);
        Score score = Score.scoreBuilder()
                           .withValue(15)
                           .withCombination(rolled)
                           .build();

        ScoreAssertion.assertThat(score)
                      .hasValue(15)
                      .hasNoReminder()
                      .hasCombination(rolled);
    }
}


