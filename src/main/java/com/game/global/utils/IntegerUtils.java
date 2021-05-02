package com.game.global.utils;

import java.util.Random;

public class IntegerUtils {

    public static Integer getRandomSingleNumber() {
        return new Random().nextInt(9);
    }

}
