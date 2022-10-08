package racingcar.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.strategy.MockStrategy;
import racingcar.model.dto.RacingResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("참여자들의 경기 결과를 받는다")
    void getRaceResult() {
        List<Car> cars = Arrays.asList(
                Car.participate("testA", 1),
                Car.participate("testB", 2),
                Car.participate("testC", 0));

        List<RacingResult> result = new RacingGame(cars)
                .start(new MockStrategy(5), 1);

        assertEquals(result.get(0).getName(), "testA");
        assertEquals(result.get(0).getMove(), 2);
        assertEquals(result.get(0).getWinner(), false);
        assertEquals(result.get(1).getName(), "testB");
        assertEquals(result.get(1).getMove(), 3);
        assertEquals(result.get(1).getWinner(), true);
        assertEquals(result.get(2).getName(), "testC");
        assertEquals(result.get(2).getMove(), 1);
        assertEquals(result.get(2).getWinner(), false);
    }
}