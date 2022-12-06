package com.bowling.frame.impl;

import com.bowling.frame.Roll;

public class Hit extends Roll {
	public Hit(int score) {
		this.isHit = true;
		this.score = score;
	}
}
