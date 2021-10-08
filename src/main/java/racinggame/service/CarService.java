/*
 * CarService
 * java-racingcar-precourse
 *
 * Version 0.2
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.service;

import racinggame.constants.UtilsConstant;
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
        carList = new ArrayList<>();
        Positive id = new Positive(1);
        for (CarName carName : validateCarNames(input)) {
            carList.add(new Car(id, carName));
            id.plus();
        }
    }

    /**
     * 입력받은 자동차 이름의 유효성 판단하여 이름 목록을 반환
     *
     * @param input 사용자로부터 입력받은 문자열
     * @return 자동차 이름 목록
     */
    private List<CarName> validateCarNames(String input) {
        if (Common.isNullOrEmpty(input)) {
            throw new IncorrectInputException(String.format("%d 글자보다 긴 이름을 입력할 수 없습니다.", UtilsConstant.MAX_CAR_NAME_LENGTH));
        }
        return makeCarNameList(input.replaceAll(",", " ").trim());
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
}
