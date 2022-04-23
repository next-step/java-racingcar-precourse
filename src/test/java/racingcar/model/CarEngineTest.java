package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.common.ErrorMessage.ENERGY_NOT_ACCEPTED;
import static racingcar.model.CarEngine.MINIMUM_MOVE_ENERGY;

public class CarEngineTest {
    private static final int MAX_ENERGY = 9;
    private static final int MIN_ENERGY = 0;

    @Test
    @DisplayName("car engine 테스트")
    void carEngineTest() {
        CarEngine notRunnableCarEngine = CarEngine.charge(MINIMUM_MOVE_ENERGY - 1);
        assertThat(notRunnableCarEngine.run()).isEqualTo(0);
        CarEngine runnableCarEngine = CarEngine.charge(MINIMUM_MOVE_ENERGY);
        CarEngine.charge(MINIMUM_MOVE_ENERGY);
        assertThat(runnableCarEngine.run()).isEqualTo(1);
    }

    @Test
    @DisplayName("car engine 실패 테스트")
    void carEngineFailTest() {
        assertThatIllegalArgumentException().isThrownBy(()-> CarEngine.charge(MIN_ENERGY-1)).withMessage(ENERGY_NOT_ACCEPTED.text());
        assertThatIllegalArgumentException().isThrownBy(()->  CarEngine.charge(MAX_ENERGY+1)).withMessage(ENERGY_NOT_ACCEPTED.text());
    }

}