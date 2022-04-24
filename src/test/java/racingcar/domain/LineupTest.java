package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineupTest {

    @ParameterizedTest
    @CsvSource(value = {"car1, 4", "car2, 5", "car3, 6"})
    @DisplayName("자동차 라인업은 조건을 전달받아서 경기 결과를 반환한다")
    void send_condition_to_cars(String winnerName, int winnerNum) {
        //given
        String loserName = "loser";
        int loserNum = 3;

        Car winner = new Car(winnerName);
        Car loser = new Car(loserName);
        Lineup lineup = new Lineup();
        lineup.addCar(winner);
        lineup.addCar(loser);

        MovingCondition winnerCond = new MovingCondition(winnerNum);
        MovingCondition loserCond = new MovingCondition(loserNum);
        MovingConditions conditions = new MovingConditions();
        conditions.match(winner, winnerCond);
        conditions.match(loser, loserCond);

        //when
        RacingReport racingReport = lineup.race(conditions);

        //then
        assertThat(racingReport).isNotNull();
        assertThat(racingReport.winners()).containsOnly(winner);
    }

    @Test
    @DisplayName("자동차 라인업은 자동차 개수보다 적은 조건으로 경기를 시작할 수 없다")
    void invalid_less_conditions() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Lineup lineup = new Lineup();
        lineup.addCar(car1);
        lineup.addCar(car2);

        MovingConditions conditions = new MovingConditions();
        conditions.match(car1, new MovingCondition(3));

        //when
        Throwable throwable = catchThrowable(() -> lineup.race(conditions));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 라인업은 자동차 개수보다 많은 조건으로 경기를 시작할 수 없다")
    void invalid_more_conditions() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Lineup lineup = new Lineup();
        lineup.addCar(car1);

        MovingConditions conditions = new MovingConditions();
        conditions.match(car1, new MovingCondition(3));
        conditions.match(car2, new MovingCondition(4));

        //when
        Throwable throwable = catchThrowable(() -> lineup.race(conditions));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}
