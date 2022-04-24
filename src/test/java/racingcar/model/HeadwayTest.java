package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.Sign;

import static org.assertj.core.api.Assertions.assertThat;

public class HeadwayTest {

    private final int addHeadwayNumber = 4;
    Headway headway;

    @BeforeEach
    void initialize() {
        headway = new Headway();
        for (int i = 0; i < addHeadwayNumber; i++) {
            headway.addHeadway();
        }
    }

    @Test
    void 자동차_전진_수() {
        assertThat(headway.getHeadway())
            .isEqualTo(addHeadwayNumber);
    }

    @Test
    void 자동차_전진_수를_문자로표현() {
        assertThat(headway.getHeadwaySign())
            .isEqualTo(Sign.HEADWAY_SIGN.getSign()
                + Sign.HEADWAY_SIGN.getSign()
                + Sign.HEADWAY_SIGN.getSign()
                + Sign.HEADWAY_SIGN.getSign());
    }
}
