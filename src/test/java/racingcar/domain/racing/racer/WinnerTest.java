package racingcar.domain.racing.racer;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.racing.constant.TestConstant.OTHER_LOCATION;
import static racingcar.domain.racing.constant.TestConstant.WINNER_LOCATION;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;

public class WinnerTest {
    private List<Car> participants;
    private List<Car> expectedWinners;

    @BeforeEach
    void setUp() {
        Car pobiCar = Car.of("pobi", WINNER_LOCATION);
        Car woniCar = Car.of("woni", OTHER_LOCATION);
        Car junCar = Car.of("jun", WINNER_LOCATION);

        participants = Arrays.asList(pobiCar, woniCar, junCar);
        expectedWinners = Arrays.asList(pobiCar, junCar);
    }

    @Test
    @DisplayName("참가자 중 우승자를 찾아서 생성한다")
    void 참가자_중_우승자를_찾아서_생성한다() {
        Winner winner = Winner.find(participants);
        assertThat(winner.getWinners()).containsAll(expectedWinners);
    }
}
