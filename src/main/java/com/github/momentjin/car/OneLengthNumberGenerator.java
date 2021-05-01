package com.github.momentjin.car;

import java.util.Random;

class OneLengthNumberGenerator implements NumberGenerator {

    public Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
