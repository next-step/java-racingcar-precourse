package com.ktc2.precourse.racingcar.model;

import com.ktc2.precourse.racingcar.Config;
import java.util.Random;

/**
 * 이름이 있는 경주 자동차를 표현하는 클래스
 * @param name 경주 자동차 이름
 * @param position 경주 자동차 위치
 */
public record RacingCar(String name, int position) {

    //설정으로부터 여러 세팅들을 불러옴
    private final static int lowerBound = Config.CAR_FORWARD_RANDOM_RANGE_LOWER_BOUND;
    private final static int upperBound = Config.CAR_FORWARD_RANDOM_RANGE_UPPER_BOUND + 1;
    private final static int factor = Config.CAR_FORWARD_FACTOR;
    private final static String format = "%-" + Config.CAR_NAME_MAX_LENGTH + "s: %s";
    private final static Random random = new Random();

    /**
     * 이름 있는 자동차를 생성한다.
     * @param name 자동차 이름
     */
    public RacingCar(String name) {
        this(name, 0);
    }

    @Override
    public String toString() {
        return String.format(format, name, "-".repeat(position));
    }

    /**
     * 자동차의 전진을 시도한다.
     * @return 전진을 시도한 자동차(이름이 같음)
     */
    public RacingCar tryMoveForward() {
        //지정된 확률로 자동차를 한 칸 전진하거나 멈춰있는다.
        if (random.nextInt(lowerBound, upperBound) >= factor) {
            return new RacingCar(this.name, this.position + 1);
        }

        return this;
    }

}
