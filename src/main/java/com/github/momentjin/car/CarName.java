package com.github.momentjin.car;

public class CarName {

    private final static int CAR_NAME_LENGTH_LIMIT = 5;

    private final String value;

    public CarName(String value) {

        if (value.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LENGTH_LIMIT + "글자를 초과할 수 없습니다");
        }

        if (value.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값을 허용하지 않습니다");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
