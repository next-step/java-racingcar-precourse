package racingcar.domain.race;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTimeTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3" })
    public void 레이스_회수_체크(String race){
        RaceTime time = RaceTime.of(race);
        assertThat(time).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "움직여라 차 ", "" })
    public void 레이스_회수_실패_체크(String race){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> RaceTime.of((race)));
    }
}
