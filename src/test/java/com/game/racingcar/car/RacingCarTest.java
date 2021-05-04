package com.game.racingcar.car;

import com.game.racingcar.car.impl.RacingCar;
import com.game.racingcar.car.input.AccelPower;
import com.game.racingcar.car.input.CarName;
import com.game.racingcar.car.input.CarOption;
import com.game.racingcar.car.input.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    CarOption carOption;

    @BeforeEach
    private void setup() {
        carOption = new CarOption();
    }

    @Test
    @DisplayName("자동차 테스트 : 이동 테스트 > 직진")
    public void car_go_forward_test() {
        // given
        Car car = RacingCar.of(CarName.of("test1"));
        Position expectedPosition = new Position();
        expectedPosition.moveRight();
        AccelPower accelPower = AccelPower.of(carOption.getMinPowerForMove());

        // when
        car.move(accelPower);
        car.printPosition();

        // then
        Position position = car.getPosition();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
    }

    @Test
    @DisplayName("자동차 테스트 : 이동 테스트 > 정지")
    public void car_stop_test() {
        // given
        Car car = RacingCar.of(CarName.of("test2"));
        Position expectedPosition = new Position();
        AccelPower accelPower = AccelPower.of(carOption.getMinPowerForMove() - 1);

        // when
        car.move(accelPower);
        car.printPosition();

        // then
        Position position = car.getPosition();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
    }


}