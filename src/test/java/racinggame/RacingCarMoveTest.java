package racinggame;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.constants.Messages;
import racinggame.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racinggame.constants.RacingCarConstants.*;

public class RacingCarMoveTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("이동조건에맞을때자동차이동테스트")
    void moveCarTest(int moveConditionNum) {
        // Given
        RacingCar racingCar = RacingCar.newInstance("mCar");

        // When
        racingCar.moveForwardRacingCar(moveConditionNum);

        // Then
        assertThat(racingCar.getRacingCarPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("이동조건에맞지않을때자동차이동없음테스트")
    void stopCarTest(int stopConditionNum) {
        // Given
        RacingCar racingCar = RacingCar.newInstance("sCar");

        //When
        racingCar.moveForwardRacingCar(stopConditionNum);

        // Then
        assertThat(racingCar.getRacingCarPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("이동조건수예외테스트")
    void moveCarByConditionNumExceptionTest(int moveConditionNum) {
        assertThatThrownBy(() -> {
            RacingCar racingCar = RacingCar.newInstance("eCar");
            racingCar.moveForwardRacingCar(moveConditionNum);

        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(Messages.MOVE_CONDITION_NUM_INVALID.getMessage());
    }
}
