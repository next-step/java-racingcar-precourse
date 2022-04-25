package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TotalLapsTest {
    @Test
    @DisplayName("레이싱_횟수_검증_테스트")
    void 레이싱_횟수_검증_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        new TotalLaps("text")).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
