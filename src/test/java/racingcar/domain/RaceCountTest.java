package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceCountTest {
    RaceCount raceCount;

    @DisplayName("PlayCount validation 생성자 테스트")
    @Test
    void generator_test(){
        assertThatThrownBy(() -> raceCount = new RaceCount("d"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 한다.");

    }
}
