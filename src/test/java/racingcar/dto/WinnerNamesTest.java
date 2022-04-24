package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.racing.constant.TestConstant.OTHER_LOCATION;
import static racingcar.domain.racing.constant.TestConstant.WINNER_LOCATION;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.racer.Winner;
import racingcar.dto.response.WinnerNames;

public class WinnerNamesTest {
    private Winner winner;
    private String expectedWinner;

    @BeforeEach
    void setUp() {
        List<Car> participants = Arrays.asList(
                Car.of("pobi", WINNER_LOCATION),
                Car.of("woni", OTHER_LOCATION),
                Car.of("jun", WINNER_LOCATION)
        );
        winner = Winner.find(participants);

        expectedWinner = "pobi, jun";
    }

    @Test
    @DisplayName("Winner 도메인 객체를 DTO로 변환한다")
    void Winner_도메인_객체를_DTO로_변환한다() {
        WinnerNames winnerNames = WinnerNames.from(winner);
        assertThat(winnerNames.get()).isEqualTo(expectedWinner);
    }
}
