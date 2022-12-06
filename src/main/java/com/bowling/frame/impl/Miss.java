package com.bowling.frame.impl;

import com.bowling.frame.Roll;

public class Miss extends Roll {
	public Miss(int score) {
		this.isMiss = true;
		this.score = score;
	}
}
