package com.mini.caracing.util;

import java.util.HashMap;
import java.util.Random;

public final class GameUtil {

    public static int randomDistance() {
        Random random = new Random();

        if (random.nextInt(10) >= 4) {
            return 1;
        }

        return 0;
    }

    public static int getMaxDistance(HashMap<String, Integer> carDistances) {
        int maxDistance = 0;

        for (int distance : carDistances.values()) {
            maxDistance = Math.max(maxDistance, distance);
        }

        return maxDistance;
    }
}
