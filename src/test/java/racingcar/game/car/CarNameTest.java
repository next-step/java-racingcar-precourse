package racingcar.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.GameConfig;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    @DisplayName("CarName() 최대 길이 이름을 넘기면 만들어 짐")
    void CarName_PassNameLengthIsMax_LengthIsSame() {
        String name = String.join("", Collections.nCopies(GameConfig.MAX_CAR_NAME_LENGTH, "a"));
        CarName carName = new CarName(name);
        assertThat(carName.get().length()).isEqualTo(name.length());
    }

    @Test
    @DisplayName("CarName() 이름의 길이가 최대를 넘기면 예외")
    void CarName_PassNameLengthIsOverMax_ThrowsException() {
        String name = String.join("", Collections.nCopies(GameConfig.MAX_CAR_NAME_LENGTH + 1, "a"));
        assertThatThrownBy(
                () -> new CarName(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
