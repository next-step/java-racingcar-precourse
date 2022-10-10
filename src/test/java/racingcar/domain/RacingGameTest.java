package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        Cars cars = new Cars("car1, car2, car3");
        Movement movement = new Movement("5");
        racingGame = new RacingGame(cars, movement);
    }

    @DisplayName("자동차 경주를 진행하는 클래스를 생성한다.")
    @Test
    void construct() {
        assertThat(racingGame).isNotNull();
    }

    @DisplayName("자동차 경주를 수행하고 결과값을 받는다.")
    @Test
    void game() {
        List<Car> gameResult = racingGame.game(() -> true);
        assertAll(
                () -> assertThat(gameResult.get(0)).isEqualTo(new Car("car1", 1)),
                () -> assertThat(gameResult.get(1)).isEqualTo(new Car("car2", 1)),
                () -> assertThat(gameResult.get(2)).isEqualTo(new Car("car3", 1))
        );
    }
}
