package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("경주 게임은 자동차들의 이름을 전달받아서 자동차들을 만든다")
    void make_lineup() {
        //given
        RacingGame racingGame = new RacingGame("car1", "car2");

        //when
        Lineup lineup = racingGame.getLineup();

        //then
        assertThat(lineup.numberOfCars()).isEqualTo(2);
    }

    @Test
    @DisplayName("경주 게임은 중복된 이름의 자동차를 만들 수 없다")
    void duplicate_car_name() {
        //when
        Throwable throwable = catchThrowable(() -> new RacingGame("car", "car"));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주 게임은 시도횟수를 전달받고 경기 결과를 반환한다")
    void report_racing_result() {
        //given
        RacingGame racingGame = new RacingGame("car");

        //when
        RacingReport racingReport = racingGame.race();

        //then
        assertThat(racingReport).isNotNull();
    }
}
