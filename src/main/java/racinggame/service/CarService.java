/*
 * CarService
 * java-racingcar-precourse
 *
 * Version 0.4
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.service;

import racinggame.domain.Car;
import racinggame.repository.CarRepository;

import java.util.List;

public class CarService {

    private CarRepository carRepository;

    /**
     * 사용자로부터 자동차 이름 입력 받는 로직
     *
     * @param input 사용자로부터 입력받은 차량 이름 목록
     */
    public void inputCarNames(String input) {
        carRepository = new CarRepository(input);
    }

    /**
     * @return 자동차 목록
     */
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    /**
     * 자동차 목록에 있는 자동차들의 전진 혹은 정지 동작 실행
     */
    public void action() {
        carRepository.action();
    }

    public List<Car> ranking() {
        return carRepository.ranking();
    }
}
