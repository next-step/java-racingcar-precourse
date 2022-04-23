package racingcar.nextstep.domain.racing.service;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.nextstep.domain.car.Car;
import racingcar.nextstep.domain.car.CarName;
import racingcar.nextstep.domain.car.CarPosition;
import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.infrastructure.racing.RacingRefereeImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingRefereeTest {

    RacingReferee racingReferee = new RacingRefereeImpl();

    @Test
    @DisplayName("우승자를 찾아주는 메소드")
    void findWinners() {
        //given
        final Car carA = Car.of(CarName.of("aaa"));
        carA.inputCarPosition(CarPosition.addValue(4));

        final Car carB = Car.of(CarName.of("bbb"));
        carB.inputCarPosition(CarPosition.addValue(3));

        final Car carC = Car.of(CarName.of("ccc"));
        carC.inputCarPosition(CarPosition.addValue(1));

        final Cars cars = Cars.of(Lists.newArrayList(carA, carB, carC));
        //when
        final Cars winners = racingReferee.findWinners(cars);
        //then
        assertThat(winners.getCars().size()).isEqualTo(1);
        assertThat(winners.getCars().get(0).getCarName().getValue()).isEqualTo("aaa");
        assertThat(winners.getCars().get(0).getCarPosition().getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자가 두 명일 때")
    void findWinners_2() {
        //given
        final Car carA = Car.of(CarName.of("aaa"));
        carA.inputCarPosition(CarPosition.addValue(4));

        final Car carB = Car.of(CarName.of("bbb"));
        carB.inputCarPosition(CarPosition.addValue(4));

        final Car carC = Car.of(CarName.of("ccc"));
        carC.inputCarPosition(CarPosition.addValue(1));

        final Cars cars = Cars.of(Lists.newArrayList(carA, carB, carC));
        //when
        final Cars winners = racingReferee.findWinners(cars);
        //then
        assertThat(winners.getCars().size()).isEqualTo(2);
        assertThat(winners.getCars().get(0).getCarName().getValue()).isEqualTo("aaa");
        assertThat(winners.getCars().get(0).getCarPosition().getValue()).isEqualTo(5);
        assertThat(winners.getCars().get(1).getCarName().getValue()).isEqualTo("bbb");
        assertThat(winners.getCars().get(1).getCarPosition().getValue()).isEqualTo(5);
    }
}