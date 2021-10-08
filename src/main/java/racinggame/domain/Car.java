/*
 * Car
 * java-racingcar-precourse
 *
 * Version 0.4
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.constants.UtilsConstant;
import racinggame.utils.CarName;
import racinggame.utils.Positive;

public class Car {

    private Positive id;
    private CarName name;
    private StringBuilder sb = new StringBuilder();

    /**
     * @param id      자동차 식별자
     * @param carName 입력받은 자동차 이름
     */
    public Car(Positive id, CarName carName) {
        this.id = id;
        this.name = carName;
    }

    /**
     * @return 자동차 이름
     */
    public Positive getId() {
        return id;
    }

    /**
     * @return 자동차 이름
     */
    public String getName() {
        return name.get();
    }

    /**
     * 자동차 전진
     */
    public void forward() {
        sb.append('-');
    }

    /**
     * @return 자동차 현재 위치
     */
    public String getPosition() {
        return sb.toString();
    }

    /**
     * 랜덤 값을 생성해 값에 맞는 동작을 하도록 함
     */
    public void action() {
        Positive positive = new Positive(Randoms.pickNumberInRange(UtilsConstant.MIN_NO, UtilsConstant.MAX_NO));
        if (UtilsConstant.MIN_CAR_FORWARD_NO <= positive.get()) {
            this.forward();
        }
    }

    /**
     * 자동차의 이름과 위치를 조합하는 함수
     *
     * @return "자동차 이름 : 현재 위치"
     */
    @Override
    public String toString() {
        return getName() + " : " + getPosition();
    }

    /**
     * 자동차의 이름과 위치를 출력하기 위한 함수
     */
    public void print() {
        System.out.println(this.toString());
    }
}
