package com.bowling;

import com.bowling.game.Game;
import com.bowling.game.impl.SinglePlayerGame;
import com.bowling.line.Line;
import com.bowling.line.impl.TenRoundLine;
import com.bowling.model.BowlingGame;
import com.bowling.round.Round;
import com.bowling.round.impl.TwoRollRound;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TenRoundLineTest {

    @Test
    public void testAllRollsFail() {
        assertThat(getScoreFromRollsString("--------------------"), is(0));
    }

    @Test
    public void testMissScore() {
        assertThat(getScoreFromRollsString("9-9-9-9-9-9-9-9-9-9-"), is(90));
    }

    @Test
    public void testPerfectScore() {
        assertThat(getScoreFromRollsString("XXXXXXXXXXXX"), is(300));
    }

    @Test
    public void test5SpareScore() {
        assertThat(getScoreFromRollsString("5/5/5/5/5/5/5/5/5/5/5"), is(150));
    }

    private int getScoreFromRollsString(String rolls) {
        Game game = new SinglePlayerGame();
        Line line = new TenRoundLine();
        Round round = new TwoRollRound();
        BowlingGame bowlingGame = new BowlingGame(line, round, game);
        Integer score = line.CalculateLineScore(bowlingGame, rolls);
        return score;
    }
}
