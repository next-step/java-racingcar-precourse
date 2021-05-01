package com.github.momentjin.core.model.car;

import java.util.Random;

class OneLengthNumberGenerator implements NumberGenerator {

    public Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
