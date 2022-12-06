package com.bowling.round;

import com.bowling.frame.Roll;

public interface RoundBonus  {
    Integer getBonus(Roll firstRoll, Roll secondRoll);
}
