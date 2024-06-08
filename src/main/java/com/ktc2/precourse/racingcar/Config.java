package com.ktc2.precourse.racingcar;

/**
 * 프로그램의 고정된 설정을 저장하는 설정 클래스
 */
public class Config {

    private Config() {}

    //자동차 이동을 결정할 랜덤 숫자의 하한
    public final static int CAR_FORWARD_RANDOM_RANGE_LOWER_BOUND = 0;
    //자동차 이동을 결정할 랜덤 숫자의 상한
    public final static int CAR_FORWARD_RANDOM_RANGE_UPPER_BOUND = 9;
    //자동차 이동을 결정할 랜덤 숫자의 경계값
    public final static int CAR_FORWARD_FACTOR = 4;

    //자동차 이름을 구분짓는 구분자
    public final static String CAR_NAME_SPLITTER = ",";
    //자동차 이름의 최소 길이
    public final static int CAR_NAME_MIN_LENGTH = 1;
    //자동차 이름의 최대 길이
    public final static int CAR_NAME_MAX_LENGTH = 5;

}
