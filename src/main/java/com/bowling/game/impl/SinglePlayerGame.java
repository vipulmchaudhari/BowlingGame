package com.bowling.game.impl;

import com.bowling.game.Game;
import com.bowling.model.BowlingGame;
import com.bowling.model.Score;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SinglePlayerGame implements Game {
    private static final Logger logger = LoggerFactory.getLogger(SinglePlayerGame.class);

    @Override
    public List<Score> evaluate(BowlingGame bowlingGame, List<String> rollStringList) {
        List<Score> gameScoreList = new ArrayList<Score>();
        if (rollStringList == null || rollStringList.isEmpty()) {
            getGameScoreForInvalidInput(gameScoreList);
            logger.info("The RollString Passed in is Empty Or Null");
            return gameScoreList;
        } else {
            getGameScoreForValidInput(bowlingGame, rollStringList, gameScoreList);
            logger.info("The output Game Score List is = " + gameScoreList);
            return gameScoreList;
        }
    }

    private void getGameScoreForInvalidInput(List<Score> gameScoreList) {
        //return a pre-calculated message we want to pass on in Score
        Score score = new Score();
        score.setMessage("No Input for Score was provided. Hence not able to calculate score for game");
        score.setSuccess(false);
        gameScoreList.add(score);
    }

    private void getGameScoreForValidInput(BowlingGame bowlingGame, List<String> rollStringList,
                                           List<Score> gameScoreList) {
        //initialize parameters for score and those we want to pass n to line for calculation.
        Score score = new Score();
        String rollString = rollStringList.get(0);
        List<Integer> scoreList = new ArrayList<Integer>();
        //Calculate the line Score based upon kind of Line passed in Context
        logger.info("The Roll String getting passed is " + rollString);
        Integer lineScore = bowlingGame.getLine().CalculateLineScore(bowlingGame, rollString);
        scoreList.add(lineScore);
        score.setScoreList(scoreList);
        score.setSuccess(true);
        logger.info("The output score is " + score);
        //Add to game score list to be returned
        gameScoreList.add(score);
    }
}
