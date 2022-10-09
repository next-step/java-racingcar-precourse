package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingJudgeTest {
    RacingJudge racingJudge;
    List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = Lists.newArrayList(
                new Car("socar"),
                new Car("uber"),
                new Car("bmw")
        );
        racingJudge = new RacingJudge(carList);
    }

    @Test
    @DisplayName("1개의 car 우승 테스트")
    void oneCarWinnerTest() {
        carList.get(0).setGoCount(3);
        carList.get(1).setGoCount(2);
        carList.get(2).setGoCount(2);
        racingJudge.judgeWinner();
        List<Car> winners = racingJudge.findWinners();

        Assertions.assertThat(winners.size())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("2개의 car 우승 테스트")
    void towCarWinnerTest() {
        carList.get(0).setGoCount(3);
        carList.get(1).setGoCount(3);
        carList.get(2).setGoCount(2);
        racingJudge.judgeWinner();
        List<Car> winners = racingJudge.findWinners();

        Assertions.assertThat(winners.size())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("3개의 car 우승 테스트")
    void threeCarWinnerTest() {
        carList.get(0).setGoCount(3);
        carList.get(1).setGoCount(3);
        carList.get(2).setGoCount(3);
        racingJudge.judgeWinner();
        List<Car> winners = racingJudge.findWinners();

        Assertions.assertThat(winners.size())
                .isEqualTo(3);
    }
}