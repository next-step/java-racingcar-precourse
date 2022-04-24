package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

public class RacingMachineTest {

    @DisplayName("자동차 1대를 4회 만큼 이동했을 때, 위치를 이동하는지 테스트")
    @Test
    void carRacingGameWhenOneCarRacing() {
        // given
        String[] names = new String[]{"pobi"};
        int round = 4;

        // when
        RacingMachine racingMachine = new RacingMachine();
        Cars cars = racingMachine.start(names, round);

        // then
        assertThat(cars.totalCurPosition()).isGreaterThan(0);
    }

    @DisplayName("자동차 댓수와 반복 횟수를 0으로 입력했을때, 경주가 실패하는지 테스트")
    @Test
    void carRacingGameWhenNoCar() {
        // given
        String[] names = new String[]{"pobi"};
        int round = 0;

        // when
        RacingMachine racingMachine = new RacingMachine();
        Cars cars = racingMachine.start(names, round);

        // then
        assertThat(cars.totalCurPosition()).isEqualTo(0);
    }

}
