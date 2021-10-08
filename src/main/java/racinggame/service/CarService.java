/*
 * CarService
 * java-racingcar-precourse
 *
 * Version 0.3
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.service;

import racinggame.domain.Car;
import racinggame.exception.IncorrectInputException;
import racinggame.utils.CarName;
import racinggame.utils.Common;
import racinggame.utils.Positive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {

    private final List<Car> carList;

    /**
     * 생성자
     *
     * @param input 사용자로부터 입력받은 차량 이름 목록
     */
    public CarService(String input) {
        validateCarNames(input);
        carList = new ArrayList<>();
        Positive id = new Positive(1);
        for (CarName carName : makeCarNameList(input.replaceAll(",", " ").trim())) {
            carList.add(new Car(id, carName));
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
     * @return 자동차 목록
     */
    public List<Car> getCarList() {
        return carList;
    }

    /**
     * 자동차 목록에 있는 자동차들의 전진 혹은 정지 동작 실행
     */
    public void action() {
        getCarList().forEach(Car::action);
    }
}
