package com.github.momentjin.core.model.car;


import com.github.momentjin.core.model.MoveCondition;

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
