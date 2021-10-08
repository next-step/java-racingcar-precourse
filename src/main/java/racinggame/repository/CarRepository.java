/*
 * CarRepository
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-09.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.repository;

import racinggame.domain.Car;
import racinggame.exception.IncorrectInputException;
import racinggame.utils.CarComparator;
import racinggame.utils.CarName;
import racinggame.utils.Common;
import racinggame.utils.Positive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CarRepository {

    private final List<Car> carList;

    /**
     * 생성자
     *
     * @param input 사용자로부터 입력받은 차량 이름 목록
     */
    public CarRepository(String input) {
        carList = new ArrayList<>();
        validateCarNames(input);
        Positive id = new Positive(1);
        for (CarName carName : makeCarNameList(input.replaceAll(",", " ").trim())) {
            carList.add(new Car(new Positive(id.get()), carName));
            id.plus();
        }
    }

    /**
     * 입력받은 자동차 이름의 유효성 판단
     *
     * @param input 사용자로부터 입력받은 문자열
     * @throws IncorrectInputException 빈값 혹은 null 값을 전달받는 경우 발생한다.
     */
    private void validateCarNames(String input) {
        if (Common.isNullOrEmpty(input)) {
            throw new IncorrectInputException("잘못된 문자열 입력입니다.");
        }
    }

    /**
     * 자동차 이름 목록 만드는 로직
     *
     * @param input 사용자로부터 입력받은 문자열을 처리하기 용이하도록 변경하여 받은 문자열
     * @return 자동차 이름 목록
     */
    private List<CarName> makeCarNameList(String input) {
        List<CarName> result = new ArrayList<>();
        for (String carName : Arrays.asList(input.split(" "))) {
            result.add(new CarName(carName));
        }
        return result;
    }

    /**
     * 자동차 목록에 있는 자동차들의 전진 혹은 정지 동작 실행
     */
    public void action() {
        carList.forEach(Car::action);
    }

    /**
     * 전체 차량 목록 조회
     *
     * @return 차량 목록
     */
    public List<Car> findAll() {
        return carList;
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
        carList.removeIf(car -> !Objects.equals(car.getPosition(), winner.getPosition()));
    }
}
