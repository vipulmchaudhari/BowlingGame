package com.bowling.frame.impl;

import com.bowling.frame.Roll;

public class Spare extends Roll {
	public Spare(int score) {
		this.isSpare = true;
		this.score = score;
	}
}
