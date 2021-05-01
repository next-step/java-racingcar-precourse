package com.github.momentjin.core.model.car;

import com.github.momentjin.core.model.MovableObjectName;

class CarName implements MovableObjectName {

    private final static int CAR_NAME_LENGTH_LIMIT = 5;

    private final String value;

    CarName(String value) {

        if (value.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LENGTH_LIMIT + "글자를 초과할 수 없습니다");
        }

        if (value.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값을 허용하지 않습니다");
        }

        this.value = value;
    }

    @Override
    public String getName() {
        return value;
    }
}
