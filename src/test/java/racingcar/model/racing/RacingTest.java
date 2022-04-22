package racingcar.model.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarRecordDto;
import racingcar.dto.RacingRecordDto;
import racingcar.model.movement.MovementStatus;
import racingcar.model.movement.MovementStrategy;
import racingcar.model.movement.random.RandomMovementConfig;
import racingcar.model.movement.random.RandomMovementStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @Test
    @DisplayName("최종 우승자는 1명 이상이다.")
    void winnerCountIsPositive() {
        // given
        MovementStrategy movementStrategy = new RandomMovementStrategy(RandomMovementConfig.START_RANDOM_NUMBER,
                                                                       RandomMovementConfig.END_RANDOM_NUMBER,
                                                                       RandomMovementConfig.GREATER_THAN_OR_EQUAL_TO_STANDARD_NUMBER);

        Racing racing = Racing.builder()
                .carNames("car1,car2,car3")
                .lapCount("5")
                .build();

        // when
        RacingRecordDto racingRecord = racing.start(movementStrategy);

        // then
        assertThat(racingRecord.getLapCount()).isEqualTo(5);
        assertThat(racingRecord.getCarRecords()).anyMatch(CarRecordDto::isWinner);
        assertThat(racingRecord.getWinnerNames()).hasSizeGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("모든 자동차의 위치가 동일한 경우 최종 우승자의 수는 모든 자동차의 수와 같다.")
    void winnerCountIsEqualToCarCount() {
        // given
        MovementStrategy movementStrategy = () -> MovementStatus.GO;

        Racing racing = Racing.builder()
                .carNames("car1,car2,car3")
                .lapCount("5")
                .build();

        // when
        RacingRecordDto racingRecord = racing.start(movementStrategy);

        // then
        assertThat(racingRecord.getLapCount()).isEqualTo(5);
        assertThat(racingRecord.getCarRecords()).allMatch(CarRecordDto::isWinner);
        assertThat(racingRecord.getWinnerNames()).hasSize(3);
    }
}
