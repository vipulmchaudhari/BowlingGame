package com.bowling.round;

import com.bowling.frame.Roll;

public interface RoundScore {
    Integer getScore(Roll firstRoll, Roll secondRoll, Roll thirdRoll);
}
