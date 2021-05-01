package com.github.momentjin.car;


import com.github.momentjin.MoveCondition;

class CarMoveCondition implements MoveCondition {

    private final static int THRESHOLD = 4;

    private final NumberGenerator numberGenerator;

    CarMoveCondition(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean movableToForward() {
        int n = numberGenerator.generate();
        return n >= THRESHOLD;
    }
}
