/*
 * RaceResult
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-09.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.domain;

import racinggame.utils.CarComparator;

import java.util.List;
import java.util.Objects;

public class RaceResult {

    private List<Car> carList;

    public RaceResult(List<Car> carList) {
        this.carList = carList;
    }

    /**
     * 주어진 제약사항에 맞춰 레이싱 결과 출력
     */
    public void print() {
        carList.forEach(car -> car.print());
        System.out.println();
        System.out.println();
    }

    /**
     * 차량의 거리와 순번 순으로 정렬 후 우승자를 찾아 나머지 차량은 제거
     *
     * @return 우승자 목록
     */
    public List<Car> ranking() {
        carList.sort(new CarComparator());
        findWinnerAndRemoveOtherCar(carList.get(0));
        return carList;
    }

    /**
     * @param winner 전달받은 우승자 정보
     */
    private void findWinnerAndRemoveOtherCar(Car winner) {
        carList.removeIf(car -> Objects.equals(car.getPosition(), winner.getPosition()) == false);
    }
}
