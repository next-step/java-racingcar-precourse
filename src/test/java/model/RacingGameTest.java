package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    @Test
    public void shouldParseCarNamesSeparatedByComma() {
        String input = "pobi,woni,jun";
        List<Car> cars = new RacingGame(Arrays.asList(input.split(","))).getCars();
        assertThat(cars).extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    public void shouldDetermineWinnersBasedOnMaxPosition() {


        RacingGame racingGame = new RacingGame(Arrays.asList("pobi", "woni", "jun"));
        List<Car> cars = racingGame.getCars();
        for (Car car : cars) {
            int moveCount = 5;
            if("woni".equals(car.getName())) {
               moveCount = 3;
            }
            car.move(moveCount);
        }
        List<String> winners = racingGame.getWinners();
        assertThat(winners).containsExactly("pobi","jun");
    }


}