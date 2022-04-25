package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void getNameTest() {
        String[] names={"ab", "ef", "ff"};
        RacingCarView view = new RacingCarView();
        assertThat(view.validateName(names)).isTrue();
    }

    @Test
    void getNameLengthTest() {
        String[] names={"ab", "ef", "ffffff"};
        RacingCarView view = new RacingCarView();
        assertThatThrownBy(() -> view.validateName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.NAME_LENGTH_OVER_MESSAGE);
    }
    @Test
    void getNameEmptyTest() {
        String[] names={"ab", "ef", ""};
        RacingCarView view = new RacingCarView();
        assertThatThrownBy(() -> view.validateName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.NAME_EMPTY_MESSAGE);
    }
}
