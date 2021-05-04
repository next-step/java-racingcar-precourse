package com.game.racingcar.car;

import com.game.racingcar.car.impl.RacingCar;
import com.game.racingcar.car.impl.RacingCars;
import com.game.racingcar.car.input.AccelPower;
import com.game.racingcar.car.input.CarName;
import com.game.racingcar.car.input.CarOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    CarOption carOption;

    @BeforeEach
    private void setUp() {
        carOption = new CarOption();
    }

    @Test
    @DisplayName("전체 자동차 출력 테스트")
    void printWholeCarsPosition() {
        // given
        Car car1 = RacingCar.of(CarName.of("car1"));
        Car car2 = RacingCar.of(CarName.of("car2"));
        Car car3 = RacingCar.of(CarName.of("car3"));
        Car car4 = RacingCar.of(CarName.of("car4"));

        Cars cars = new RacingCars();
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);

        // when
        car1.move(AccelPower.of(carOption.getMinPowerForMove() - 1));

        car2.move(AccelPower.of(carOption.getMinPowerForMove()));
        car2.move(AccelPower.of(carOption.getMinPowerForMove()));

        car3.move(AccelPower.of(carOption.getMinPowerForMove()));
        car3.move(AccelPower.of(carOption.getMinPowerForMove()));
        car3.move(AccelPower.of(carOption.getMinPowerForMove()));

        car4.move(AccelPower.of(carOption.getMinPowerForMove()));
        car4.move(AccelPower.of(carOption.getMinPowerForMove()));
        car4.move(AccelPower.of(carOption.getMinPowerForMove()));
        car4.move(AccelPower.of(carOption.getMinPowerForMove()));

        cars.printWholeCarsPosition();
    }

    @Test
    @DisplayName("최장거리 이동 자동차 목록 획득 테스트")
    void getLongestDistanceMovingCarsTest() {
        // given
        Car car1 = RacingCar.of(CarName.of("car1"));
        Car car2 = RacingCar.of(CarName.of("car2"));
        Car car3 = RacingCar.of(CarName.of("car3"));
        Car car4 = RacingCar.of(CarName.of("car4"));

        Cars cars = new RacingCars();
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);

        car2.move(AccelPower.of(carOption.getMinPowerForMove()));

        car3.move(AccelPower.of(carOption.getMinPowerForMove()));
        car3.move(AccelPower.of(carOption.getMinPowerForMove()));

        car4.move(AccelPower.of(carOption.getMinPowerForMove()));
        car4.move(AccelPower.of(carOption.getMinPowerForMove()));

        // when
        List<Car> longestDistanceMovingCars = cars.getWinnerCars();

        // then
        assertThat(longestDistanceMovingCars.size()).isEqualTo(2);
        assertThat(longestDistanceMovingCars).contains(car3, car4);

    }
}