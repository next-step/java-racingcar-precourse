package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.view.UserInput;

public class GameTest {

    private MockedStatic<RandomNumber> randomNumber;
    private Game game;

    @BeforeEach
    void beforeEach() {
        this.randomNumber = Mockito.mockStatic(RandomNumber.class);

        String inputNames = "pobi,crong,honux";
        String inputRaceCount = "5";

        Names names = new Names(new UserInput(inputNames));
        RaceCount raceCount = new RaceCount(new UserInput(inputRaceCount));

        this.game = new Game(names, raceCount);
    }

    @AfterEach
    void afterEach() {
        randomNumber.close();
    }

    @Test
    @DisplayName("race() 메서드를 호출하면 자동차들이 단일 횟수만큼 움직임")
    void playThenReturnCars() {
        // given
        this.randomNumber.when(RandomNumber::generate).thenReturn(0, 4, 9);

        // when
        Cars cars = game.race();

        // then
        assertThat(cars.getValue().get(0).getPosition().getValue()).isEqualTo(0);
        assertThat(cars.getValue().get(1).getPosition().getValue()).isEqualTo(1);
        assertThat(cars.getValue().get(2).getPosition().getValue()).isEqualTo(1);
    }
}
