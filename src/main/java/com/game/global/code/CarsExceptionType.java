package com.game.global.code;

public enum CarsExceptionType {

    EMPTY_CAR_NAME("자동차명이 비어있습니다."),
    OVERSIZE_CAR_NAME("자동차명(%s)이 이름 길이 제한(%d)을 초과하였습니다."),
    DUPLICATE_CAR_NAME("%d번째 자동차명(%s)이 이름이 중복 됩니다."),
    WRONG_CAR_NAME("입력된 자동차(%s)는 경주 목록에 없습니다."),
    WRONG_CAR_GO_FORWARD_VALUE("자동차 전진을 위해 입력된 정수값(%d)이 올바르지 않습니다. 올바른 정수값은 0 에서 9 사이의 값입니다."),
    ;

    private String description;

    CarsExceptionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
