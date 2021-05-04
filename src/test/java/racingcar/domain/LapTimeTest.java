package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랩 타임 도메인 테스트")
class LapTimeTest {

    @ParameterizedTest(name = "랩 타임 생성")
    @CsvSource({
            "0, car1, 5"
            , "0, car2, 3"
            , "1, car1, 7"
            , "1, car2, 8"
    })
    void 랩타임_생성(int lap, String name, int distance) {
        // when
        LapTime lapTime = new LapTime(lap, name, distance);
        // then
        assertThat(lapTime.getLap()).isEqualTo(lap);
        assertThat(lapTime.getCarName()).isEqualTo(name);
        assertThat(lapTime.getDistance()).isEqualTo(distance);
    }

}