package com.bowling.round;

import com.bowling.frame.Roll;

public interface RoundConsumed {
    Integer getConsumed(Roll firstRoll, Roll secondRoll);
}
