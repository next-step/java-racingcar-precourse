package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @Test
    @DisplayName("자동차_객체_이름_검증_테스트")
    void 자동차_객체_이름_검증_테스트() {

        assertThat(new CarName("krad")).isInstanceOf(CarName.class);

        assertThat(new CarName("krad ")).isInstanceOf(CarName.class);

        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        new CarName("kradjeon")).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
