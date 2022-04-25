package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.utils.TestCarsUtils.testCars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.utils.TestCarsUtils;

class WinnerCountsTest {

    @Test
    @DisplayName("우승자 횟수 생성 후 전진 집계 성공 테스트")
    void countingCars() {
        // given
        final WinnerCounts winnerCounts = WinnerCounts.init();

        // when
        winnerCounts.countingCars(testCars());

        // then
        assertThat(winnerCounts.hasWinners()).isTrue();
    }

    @Test
    @DisplayName("우승자 자동차 조회 테스트")
    void maxCountCars() {
        // given
        final WinnerCounts winnerCounts = WinnerCounts.init();
        final Cars goCars = testCars();
        winnerCounts.countingCars(goCars);

        // when & then
        assertThat(winnerCounts.maxCountCars().countCars()).isGreaterThan(0);
    }

    @Test
    @DisplayName("우승자 존재 여부 확인 테스트")
    void hasWinners() {
        // given
        final WinnerCounts winnerCounts = WinnerCounts.init();

        // when
        winnerCounts.countingCars(testCars());

        // then
        assertThat(winnerCounts.hasWinners()).isTrue();
    }

    @Test
    @DisplayName("우승자 존재 하지 않을 때 테스트")
    void hasWinners_exception() {
        // given
        final WinnerCounts winnerCounts = WinnerCounts.init();

        // when & then
        assertThat(winnerCounts.hasWinners()).isFalse();

    }
}