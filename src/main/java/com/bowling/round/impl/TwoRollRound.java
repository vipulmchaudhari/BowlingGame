package com.bowling.round.impl;

import com.bowling.frame.Roll;
import com.bowling.round.Round;

public class TwoRollRound implements Round {
    @Override
    public Integer getBonus(Roll firstRoll, Roll secondRoll) {
        if (firstRoll.isStrike()) {
            // A strike in first roll gives two roll bonus to user
            return 2;
        } else if (null != secondRoll && secondRoll.isSpare()) {
            // A spare in second roll gives bonus of 1 roll to User
            return 1;
        } else if (firstRoll.ishit()) {
            // In two rolls, the bowler is unable to knock down all pins. In which case he
            // does not get any bonus
            return 0;
        } else {
            return 0;
        }
    }

    @Override
    public Integer getConsumed(Roll firstRoll, Roll secondRoll) {
        if (firstRoll.isStrike()) {
            // A strike in first roll consumes zero extra roll
            return 0;
        } else if (null != secondRoll && secondRoll.isSpare()) {
            // A spare in second roll consumes one extra Roll
            return 1;
        } else if (firstRoll.ishit()) {
            // In two rolls, the bowler is unable to knock down all pins. In which case he
            // has consumed one extra roll
            return 1;
        } else {
            return 1;
        }
    }

    @Override
    public Integer getScore(Roll firstRoll, Roll secondRoll, Roll thirdRoll) {
        Integer score = 0;
        if (firstRoll.isStrike()) {
            // A strike in first roll: Simply add first roll's score (which is 10)
            // to total number of knocked down pins in next 2 rolls. Note that we're
            // not checking if the second roll is a spare, which in this case would
            // indicate invalid input.
            score = firstRoll.getScore() + secondRoll.getScore() + thirdRoll.getScore();
            return score;
        } else if (null != secondRoll && secondRoll.isSpare()) {
            // A spare in second roll: Simply add 10 to total pins knocked down in
            // next roll. Note that we're not checking if total score of first and
            // second rolls is 10, which would indicate that a spare has occurred but
            // the input didn't indicate that.
            score = secondRoll.getScore() + thirdRoll.getScore();
            return score;
        } else if (firstRoll.ishit()) {
            // In two rolls, the bowler is unable to knock down all pins. Simply add
            // total of knocked down pins in these two rolls. No bonus rolls given.
            score = firstRoll.getScore() + secondRoll.getScore();
            return score;
        }
        return score;
    }
}
