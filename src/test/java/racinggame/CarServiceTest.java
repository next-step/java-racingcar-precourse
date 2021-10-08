/*
 * CarServiceTest
 * java-racingcar-precourse
 *
 * Version 0.3
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.exception.IncorrectInputException;
import racinggame.service.CarService;
import racinggame.utils.CarName;
import racinggame.utils.Positive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    @Test
    public void 일급컬렉션_전_자동차_여러대_생성() throws Exception {
        List<Car> carList = new ArrayList<>();

        String s = "abc,ele,wpp";
        List<String> carNames = Arrays.asList(s.split(","));

        for (String carName : carNames) {
            Car car = new Car(new Positive(1), new CarName(carName));
            carList.add(car);
        }

        assertThat(carList.size()).isEqualTo(carNames.size());
    }

    @Test
    public void 일급컬렉션_전_자동차_경주() throws Exception {
        List<Car> carList = new ArrayList<>();
        Positive positive = new Positive(3);
        String s = "abc,ele,wpp";
        List<String> carNames = Arrays.asList(s.split(","));

        for (String carName : carNames) {
            Car car = new Car(new Positive(1), new CarName(carName));
            carList.add(car);
        }

        for (int i = 0; i < positive.get(); i++) {
            carList.forEach(Car::action);
            carList.forEach(Car::print);
        }
    }

    @Test
    public void 일급컬렉션_후_자동차_여러대_생성() throws Exception {

        CarService carService = new CarService("abc,ele,wpp");

        assertThat(carService.getCarList().size()).isEqualTo(3);
    }

    @Test
    public void 일급컬렉션_후_자동차_이름_오류() throws Exception {
        System.out.println(assertThrows(IncorrectInputException.class, () -> new CarService("abc,ele,wpp333")).getMessage());
        System.out.println(assertThrows(IncorrectInputException.class, () -> new CarService("")).getMessage());
        System.out.println(assertThrows(IncorrectInputException.class, () -> new CarService(null)).getMessage());
    }

    @Test
    public void 일급컬렉션_후_자동차_경주() throws Exception {
        CarService carService = new CarService(",aaa,");

        Positive positive = new Positive(3);

        for (int i = 0; i < positive.get(); i++) {
            carService.getCarList().forEach(Car::action);
            carService.getCarList().forEach(Car::print);
        }
    }

    @Test
    public void 자동차_동작_실행() throws Exception {
        //given
        CarService carService = new CarService("abc,ele,wpp");
        //when
        carService.action();
        //then
        carService.getCarList().forEach(Car::print);
    }
}
