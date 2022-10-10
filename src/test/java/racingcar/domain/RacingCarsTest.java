package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

import racingcar.constants.RacingCarMessage;

public class RacingCarsTest {
	
	@Test
    void 이름에_대한_예외_5자_초과() {
		assertThatIllegalArgumentException().isThrownBy(
                ()->{
                    String[] carNames = {"pobi","pobi2","javaji"};
                    RacingCars invalidCars = new RacingCars(carNames);
                }).withMessageContaining(
                        String.format(RacingCarMessage.MESSAGE_VALIDATION_INPUT_LENGTH));
    }

	@Test
    void 이름에_대한_예외_1자_미만() {
		assertThatIllegalArgumentException().isThrownBy(
                ()->{
                    String[] carNames = {"pobi","","javaji"};
                    RacingCars invalidCars = new RacingCars(carNames);
                }).withMessageContaining(
                        String.format(RacingCarMessage.MESSAGE_VALIDATION_INPUT_LENGTH));
    }
}
