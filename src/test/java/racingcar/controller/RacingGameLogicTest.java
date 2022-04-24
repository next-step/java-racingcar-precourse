package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.TestConstants.RIGHT_NAME;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RacingGameLogicTest {

    RacingGameLogic logic;
    List<Car> cars;

    @BeforeEach
    void setUp() {
        logic = RacingGameLogic.getInstance();
        cars = logic.parserCarName(String.join(",", Collections.nCopies(3, RIGHT_NAME)));
    }

    @Test
    void moveCars() {
        logic.moveCars(cars);
    }

    @Test
    void selectWinnerNames() {
        List<String> car_names = logic.selectWinnerName(cars);
        assertThat(car_names.size()).isEqualTo(3);
    }

    @Test
    void selectWinnerName() {
        cars.get(0).setMoveCount(cars.get(0).getMoveCount() + 1);
        List<String> car_names = logic.selectWinnerName(cars);
        assertThat(car_names.size()).isEqualTo(1);
    }
}