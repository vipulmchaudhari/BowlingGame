package com.bowling.model;

import com.bowling.game.Game;
import com.bowling.line.Line;
import com.bowling.round.Round;

public class BowlingGame {
    private Game game;

    private Line line;

    private Round round;

    private Score score;

    public BowlingGame(Line line, Round round, Game game) {
        this.line = line;
        this.round = round;
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "BowlingGame{" +
                "game=" + game +
                ", line=" + line +
                ", round=" + round +
                ", score=" + score +
                '}';
    }
}
