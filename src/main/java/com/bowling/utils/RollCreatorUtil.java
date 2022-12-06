package com.bowling.utils;

import com.bowling.frame.Roll;
import com.bowling.frame.impl.Hit;
import com.bowling.frame.impl.Miss;
import com.bowling.frame.impl.Spare;
import com.bowling.frame.impl.Strike;

public class RollCreatorUtil {
    private final static char MISS = '-';
    private final static char SPARE = '/';
    private final static char STRIKE = 'X';

    public static Roll createRollFromChar(Character rollChar) {
        System.out.println("Creating out the Roll from Char passed in");
        System.out.println("The char passed in is " + rollChar);
        Roll roll = null;
        if(rollChar == null || MISS == rollChar) {
            // This is a MISS throw.
            roll = new Miss(0);
        } else if(SPARE == rollChar) {
            // This is a SPARE throw.
            roll = new Spare(10);
        } else if(STRIKE == rollChar) {
            // This is a STRIKE throw.
            roll = new Strike(10);
        } else {
            // This is a throw which knocked down some pins.
            roll = new Hit(Character.getNumericValue(rollChar));
        }
        System.out.println("The Roll getting passed back is " + roll);
        return roll;
    }
}
