package com.bowling.frame.impl;

import com.bowling.frame.Roll;

public class Strike extends Roll {
	public Strike(int score) {
		this.isStrike = true;
		this.score = score;
	}
}
