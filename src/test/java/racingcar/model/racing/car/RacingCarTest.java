package racingcar.model.racing.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.random.number.generator.GeneratedRandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private final CarName carName = new CarName("테스트 자동차 이름");
    private final Advance advance = new Advance();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void racingCarStaysWhenActionResultShouldStay(int number) {
        RacingCar racingCar = new RacingCar(carName, advance);
        GeneratedRandomNumber generatedRandomNumber = new GeneratedRandomNumber(number);
        racingCar.playOneRound(generatedRandomNumber);
        assertThat(racingCar.getAdvance().getValue()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void racingCarForwardsWhenActionResultCanForward(int number) {
        RacingCar racingCar = new RacingCar(carName, advance);
        GeneratedRandomNumber generatedRandomNumber = new GeneratedRandomNumber(number);
        racingCar.playOneRound(generatedRandomNumber);
        assertThat(racingCar.getAdvance().getValue()).isEqualTo(1);
    }
}
