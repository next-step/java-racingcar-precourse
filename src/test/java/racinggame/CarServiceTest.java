/*
 * CarServiceTest
 * java-racingcar-precourse
 *
 * Version 0.4
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.RaceResult;
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

    CarService carService;

    @BeforeEach
    void setUp(){
        carService = new CarService();
    }

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
    public void 일급컬렉션_후_자동차_이름_오류() throws Exception {
        System.out.println(assertThrows(IncorrectInputException.class, () -> carService.inputCarNames("abc,ele,wpp333")).getMessage());
        System.out.println(assertThrows(IncorrectInputException.class, () -> carService.inputCarNames("")).getMessage());
        System.out.println(assertThrows(IncorrectInputException.class, () -> carService.inputCarNames(null)).getMessage());
    }

    @Test
    public void 일급컬렉션_후_자동차_경주() throws Exception {
        carService.inputCarNames(",aaa,");
        Positive positive = new Positive(3);

        for (int i = 0; i < positive.get(); i++) {
            carService.action();
            carService.getRaceResult().print();
        }
    }

    @Test
    public void 자동차_동작_실행() throws Exception {
        //given
        carService.inputCarNames("abc,ele,wpp");
        //when
        carService.action();
        //then
        carService.getRaceResult().print();

    }

    @Test
    public void 자동차_순위_매김() throws Exception {
        //given
        carService.inputCarNames("abc,ele,wpp");
        //when
        for(int i = 0; i < 5; i++){
            carService.action();
            carService.getRaceResult().print();
        }
        //then
        RaceResult raceResult = carService.getRaceResult();
        raceResult.ranking();
        raceResult.print();
    }
}
