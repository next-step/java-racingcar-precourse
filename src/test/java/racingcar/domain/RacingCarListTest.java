package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.creator.RacingCarListCreator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarListTest {

    @DisplayName("가장 높은 위치 값을 반환한다.")
    @Test
    void racingCarMaxPosition() {
        // given
        int minPosition = 3;
        int maxPosition = 5;
        RacingCarList racingCarList = RacingCarListCreator.create(minPosition, maxPosition);

        // when
        int maxPositionCar = racingCarList.racingCarMaxPosition();

        // then
        assertThat(maxPositionCar).isEqualTo(maxPosition);
    }

    @DisplayName("RacingCarList에서 이긴 RacingCar 리스트를 반환한다.")
    @Test
    void racingCarWinner() {
        // given
        int minPosition = 3;
        int maxPosition = 5;
        RacingCarList racingCarList = RacingCarListCreator.create(minPosition, maxPosition);

        // when
        List<RacingCar> winnerRacingCar = racingCarList.racingCarWinner(maxPosition);

        // then
        assertThat(winnerRacingCar).hasSize(1);
        assertThat(winnerRacingCar.get(0).getName()).isEqualTo(racingCarList.getRacingCarList().get(2).getName());
    }

}
