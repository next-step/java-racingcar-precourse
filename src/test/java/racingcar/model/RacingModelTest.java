package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.GameStatus;
import racingcar.car.model.RacingModel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingModelTest {
    RacingModel racingModel;

    @BeforeEach
    public void init() {
        racingModel = new RacingModel();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "-1", "0.1"})
    public void racingNumber검증(String inputs) {
        assertThatThrownBy(() -> racingModel.validateInput(inputs, GameStatus.RACING_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaa,ababab"})
    public void carNames_비정상_검증(String inputs) {
        assertThatThrownBy(() -> racingModel.validateInput(inputs, GameStatus.CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d", "aa,bb,cc,dd", "aaa,bbb,ccc,ddd", "aaaa,bbbb,cccc,dddd", "aaaaa,bbbbb,cccc,ddddd"})
    public void carNames_정상_검증(String inputs) {
        assertThat(racingModel.validateInput(inputs, GameStatus.CAR_NAME))
                .isEqualTo(inputs);
    }
}
