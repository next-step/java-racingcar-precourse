package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {
    Winner winner;

    @DisplayName("getWinners_단독_정상_테스트")
    @Test
    void getWinners_단독_정상_테스트() {
        winner = new Winner(getOneWinnerCars());
        List<String> expectedResult = Collections.singletonList("pobi");
        assertThat(winner.getWinners()).isEqualTo(expectedResult);
    }

    @DisplayName("getWinners_여려명_정상_테스트")
    @Test
    void getWinners_여려명_정상_테스트() {
        winner = new Winner(getTwoWinnerCars());
        List<String> expectedResult = Arrays.asList("pobi", "crong");
        assertThat(winner.getWinners()).isEqualTo(expectedResult);
    }

    private Cars getOneWinnerCars() {
        String inputName = "pobi,crong,honux";
        Cars cars = new Cars(inputName);
        cars.cars().get(0).move(4);
        return cars;
    }

    private Cars getTwoWinnerCars() {
        String inputName = "pobi,crong,honux";
        Cars cars = new Cars(inputName);
        cars.cars().get(0).move(4);
        cars.cars().get(0).move(4);
        cars.cars().get(1).move(4);
        cars.cars().get(1).move(4);
        return cars;
    }
}
