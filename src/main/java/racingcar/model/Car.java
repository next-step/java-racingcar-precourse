package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private final Integer INITIAL_LOCATION = 0;
    private final Integer MIN_RANDOM_RANGE = 0;
    private final Integer MAX_RANDOM_RANGE = 9;
    private final Integer CAR_MOVING_POLICY = 3;

    private Integer location;
    private final String name;
    private final Integer movingPolicy;

    /**
     * 자동차 객체 생성자
     *
     * @param name 참가자 이름
     */
    public Car(String name) {
        this.name = name;
        this.location = INITIAL_LOCATION;
        this.movingPolicy = CAR_MOVING_POLICY;
    }

    /**
     * 이름 조회 함수
     *
     * @return 조회된 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 위치 조회 함수
     *
     * @return 조회된 위치
     */
    public Integer getLocation() {
        return location;
    }

    /**
     * 전진 함수
     *
     */
    public void go() {
        location++;
    }

    /**
     * 랜덤 전진 함수
     *
     */
    public void randomlyMove() {
        if (movingPolicy < pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE)) {
            go();
        }
    }
}
