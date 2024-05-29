package com.mini.caracing.util;

import java.util.Random;

public final class GameUtil {

    public static int randomDistance() {
        Random random = new Random();

        if (random.nextInt(10) >= 4) {
            return 1;
        }

        return 0;
    }
}
