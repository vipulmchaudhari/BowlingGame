package com.bowling.game;

import com.bowling.model.BowlingGame;
import com.bowling.model.Score;

import java.util.List;

public interface Game {
    List<Score> evaluate(BowlingGame context, List<String> rollStringList);
}
