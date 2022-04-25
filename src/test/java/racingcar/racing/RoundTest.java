package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.TestCarsUtils.testCars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("실행 생성 성공 테스트")
    void of() {
        // given

        // when
        final Round round = Round.of(testCars());

        // then
        assertThat(round).isNotNull();
    }

    @Test
    @DisplayName("실행 생성 실패 테스트")
    void of_exception() {
        // given

        // when
        assertThatThrownBy(() -> Round.of(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 시작 성공 테스트")
    void start() {
        // given
        final Round round = Round.of(testCars());

        // when
        round.start();

        // then
        assertThat(round.isFinish()).isTrue();
        assertThat(round.getRoundResults().getRoundResults().size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("전진한 자동차들 조회 성공 테스트")
    void getGoCars() {
        // given
        final Round round = Round.of(testCars());

        // when
        round.start();

        // then
        assertThat(round.getGoCars().countCars()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("실행 종료 성공 테스트")
    void isFinish() {
        // given
        final Round round = Round.of(testCars());

        // when
        round.start();

        // then
        assertThat(round.isFinish()).isTrue();
    }

    @Test
    @DisplayName("실행하지 않았을 때 성공 테스트")
    void isFinish_not() {
        // given
        final Round round = Round.of(testCars());

        // when & then
        assertThat(round.isFinish()).isFalse();
    }
}