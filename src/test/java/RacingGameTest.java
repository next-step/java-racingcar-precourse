import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void shouldCreateCarsWithValidNames() {
        racingGame.initializeCars("pobi,woni,jun");
        List<Car> cars = racingGame.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars).extracting(Car::getName).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void shouldThrowExceptionWhenCarNameIsInvalid() {
        assertThatThrownBy(() -> racingGame.initializeCars("abcdef"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("차 이름은 1자 이상, 5자 이하만 가능합니다.");
    }

    @Test
    void shouldThrowExceptionWhenRoundsInputIsInvalid() {
        assertThatThrownBy(() -> racingGame.setRounds("십이회"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("숫자만 가능합니다.");
    }

    @Test
    void shouldThrowExceptionWhenRoundsIsNonPositive() {
        assertThatThrownBy(() -> racingGame.setRounds("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void shouldDetermineWinnersCorrectly() {
        racingGame.initializeCars("pobi,woni,jun");
        racingGame.setRounds("5");
        racingGame.race();

        List<String> winners = racingGame.getWinners();
        int maxPosition = racingGame.getCars().stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winnerCars = racingGame.getCars().stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());

        assertThat(winners).hasSize(winnerCars.size());
        assertThat(winners).containsAll(winnerCars.stream().map(Car::getName).collect(Collectors.toList()));
    }
}