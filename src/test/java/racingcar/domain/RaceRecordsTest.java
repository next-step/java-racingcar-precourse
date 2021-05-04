package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RaceRecordException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.constant.RacingCarConstant.SEPARATOR;

@DisplayName("경주기록 도메인 테스트")
class RaceRecordsTest {

    @DisplayName("경주기록 생성")
    @Test
    void 경주기록_생성() {
        // given
        RaceRecords raceRecords = new RaceRecords();
        MoveCondition moveCondition = new MoveCondition();
        Cars cars = new Cars("car1,car2,car3".split(SEPARATOR));
        cars.move(moveCondition);

        // when
        raceRecords.saveLapTime(cars.getCars());

        // then
        assertThat(raceRecords.getRaceRecords())
                .isNotNull()
                .isInstanceOf(String.class);
    }

    @DisplayName("경주기록 널값 예외발생")
    @Test
    void 경주기록_널값_예외발생() {
        RaceRecords raceRecords = new RaceRecords();
        assertThatThrownBy(() -> raceRecords.saveLapTime(null)).isInstanceOf(RaceRecordException.UnRecordableTypeException.class);
    }

}