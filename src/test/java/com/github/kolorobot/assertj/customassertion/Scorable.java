package com.github.kolorobot.assertj.customassertion;

import java.util.List;

interface Scorable {
    Score getScore(List<Dice> dice);
}
