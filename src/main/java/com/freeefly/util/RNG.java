package com.freeefly.util;

import java.util.Random;

/**
 * 무작위 숫자 생성기
 */
public class RNG {
    private static Random random = new Random();

    public static Integer generate(Integer bound) {
        return random.nextInt(bound);
    }
}
