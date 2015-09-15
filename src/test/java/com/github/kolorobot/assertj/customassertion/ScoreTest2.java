package com.github.kolorobot.assertj.customassertion;

import org.assertj.core.api.JUnitSoftAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Rule;
import org.junit.Test;

import static com.github.kolorobot.assertj.customassertion.DiceObjectMother.dice;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest2 {

    @Rule
    public JUnitSoftAssertions softAssertions = new JUnitSoftAssertions();

    @Test
    public void verifiesScore() {
        Score score = Score.scoreBuilder()
                           .withValue(11)
                           .withCombination(dice(1, 1, 3, 4))
                           .withReminder(dice(6))
                           .build();

        assertThat(score.getValue())
            .as("Has score")
            .isEqualTo(8);
        assertThat(score.getCombination())
            .as("Has combination")
            .isEqualTo(dice(1, 1, 3, 3));
        assertThat(score.getReminder())
            .as("Has reminder")
            .isEqualTo(dice(5));
    }

    @Test
    public void verifiesScoreSoftly() {
        Score score = Score.scoreBuilder()
                           .withValue(11)
                           .withCombination(dice(1, 1, 3, 4))
                           .withReminder(dice(6))
                           .build();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(score.getValue())
                      .as("Has score")
                      .isEqualTo(8);
        softAssertions.assertThat(score.getCombination())
                      .as("Has combination")
                      .isEqualTo(dice(1, 1, 3, 3));
        softAssertions.assertThat(score.getReminder())
                      .as("Has reminder")
                      .isEqualTo(dice(5));

        softAssertions.assertAll();
    }

    @Test
    public void verifiesScoreSoftlyUsingRule() {
        Score score = Score.scoreBuilder()
                           .withValue(11)
                           .withCombination(dice(1, 1, 3, 4))
                           .withReminder(dice(6))
                           .build();

        softAssertions.assertThat(score.getValue())
                      .as("Has score")
                      .isEqualTo(8);
        softAssertions.assertThat(score.getCombination())
                      .as("Has combination")
                      .isEqualTo(dice(1, 1, 3, 3));
        softAssertions.assertThat(score.getReminder())
                      .as("Has reminder")
                      .isEqualTo(dice(5));
    }

    @Test
    public void verifiesScoreSoftlyWithCustomAssertion() {

        Score score = Score.scoreBuilder()
                           .withValue(11)
                           .withCombination(dice(1, 1, 3, 4))
                           .withReminder(dice(6))
                           .build();

        SoftScoreAssertion.assertThat(score)
                          .hasValue(8)
                          .hasCombination(dice(1, 1, 3, 3))
                          .hasReminder(dice(5))
                          .assertAll();
    }
}


