package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarLocationTest {

    private RacingCarLocation racingCarLocation;

    @BeforeEach
    void setUp() {
        racingCarLocation = new RacingCarLocation();
    }

    @Test
    void 자동차_전진() {
        racingCarLocation.moveOnCondition(4);

        assertThat(racingCarLocation.getLocation()).isEqualTo("-");
    }

    @Test
    void 자동차_2번_전진() {
        racingCarLocation.moveOnCondition(4);
        racingCarLocation.moveOnCondition(5);

        assertThat(racingCarLocation.getLocation()).isEqualTo("--");
    }


    @Test
    void 자동차_멈춤() {
        racingCarLocation.moveOnCondition(1);

        assertThat(racingCarLocation.getLocation()).isEqualTo("");
    }

    @Test
    void 범위에_벗어나는_수_입력() {
        assertThatThrownBy(() -> racingCarLocation.moveOnCondition(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자는 1~9사이만 입력이 가능합니다.");
    }

}
