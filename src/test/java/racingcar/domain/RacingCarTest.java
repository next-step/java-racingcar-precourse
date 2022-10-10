package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

import racingcar.constants.RacingCarMessage;

public class RacingCarTest {
	
	@Test
    void 이름에_대한_예외_5자_초과() {
        assertThatIllegalArgumentException().isThrownBy(()-> new RacingCar("carover"))
        .withMessageContaining(
                String.format(RacingCarMessage.MESSAGE_VALIDATION_INPUT_LENGTH));
    }
	
	@Test
    void 이름에_대한_예외_1자_미만() {
        assertThatIllegalArgumentException().isThrownBy(()-> new RacingCar(""))
        .withMessageContaining(
                String.format(RacingCarMessage.MESSAGE_VALIDATION_INPUT_LENGTH));
    }


}
