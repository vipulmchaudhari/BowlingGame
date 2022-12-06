package com.bowling.line.impl;

import com.bowling.line.Line;
import com.bowling.model.BowlingGame;
import com.bowling.round.Round;
import com.bowling.frame.Roll;
import com.bowling.utils.RollCreatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TenRoundLine implements Line {
    private static final Logger logger = LoggerFactory.getLogger(TenRoundLine.class);

    @Override
    public Integer CalculateLineScore(BowlingGame bowlingGame, String rollString) {
        List<Character> rollsCharList = rollString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        int totalRollCount = rollsCharList.size();
        logger.info("Total Roll Count is " + totalRollCount);
        // Add 2 more virtual entries (2nd and 3rd roll in last round.)
        rollsCharList.add(null);
        rollsCharList.add(null);
        // Calculate Total Score By Recreating Round In Loops
        int totalScore = CalculateTotalScoreByRecreatingRoundInLoops(bowlingGame, rollsCharList, totalRollCount);
        logger.info("Total Score calculated is " + totalScore);
        logger.info("Exiting the Line Score");
        return totalScore;
    }

    private int CalculateTotalScoreByRecreatingRoundInLoops(BowlingGame bowlingGame, List<Character> rollsCharList,
                                                            int totalRollCount) {
        int totalScore = 0;

        // Get the Object of kind of Round chosen for this game.
        Round theRound = bowlingGame.getRound();

        // Start analyzing at first roll.
        int rollPos = 0;

        // initialize bonus as zero to start
        int rollBonus = 0;
        logger.info("Starting Analysis of rolls using a loop in order to recreate the rounds");
        // Analyze the rolls using a loop
        do {
            // Next round...

            // Get three possible Rolls of this round.
            Roll firstRoll = RollCreatorUtil.createRollFromChar(rollsCharList.get(rollPos));
            Roll secondRoll = RollCreatorUtil.createRollFromChar(rollsCharList.get(rollPos + 1));
            Roll thirdRoll = RollCreatorUtil.createRollFromChar(rollsCharList.get(rollPos + 2));

            // Add round's score to total score.
            totalScore += theRound.getScore(firstRoll, secondRoll, thirdRoll);

            // Jump the consumed rolls so that we don't process them with round.
            rollPos += theRound.getConsumed(firstRoll, secondRoll);

            rollBonus = theRound.getBonus(firstRoll, secondRoll);
            logger.info("firstRoll=" + firstRoll + ", secondRoll=" + secondRoll + ", thirdRoll=" + thirdRoll
                    + ", totalScore=" + totalScore + ", rollPos=" + rollPos + ", rollBonus=" + rollBonus);

        } while (totalRollCount - rollBonus > ++rollPos);
        return totalScore;
    }
}
