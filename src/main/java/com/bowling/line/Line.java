package com.bowling.line;

import com.bowling.model.BowlingGame;

public interface Line {
    Integer CalculateLineScore(BowlingGame context, String rollString);
}
