import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputTest {

    GameController gameController;

    @BeforeEach
    @DisplayName("initialization")
    void setUp() {
        gameController = new GameController();
    }

    @Test
    @DisplayName("car names length validation")
    void inputCarNamesLengthValid() {
        // given
        String names = "honda, mizda  , genesis,kia";
        // when
        String[] carNames = Arrays.stream(names.split(",")).map(String::trim).toArray(String[]::new);
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            gameController.checkNameLength(carNames);
        });
    }
    @Test
    @DisplayName("car names length validation")
    void inputCarNamesSplitValid() {
        // given
        String names = "honda,mizda  , kia  ";
        // when
        String[] carNames = Arrays.stream(names.split(",")).map(String::trim).toArray(String[]::new);
        // then
        assertThat(carNames[0]).isEqualTo("honda");
        assertThat(carNames[1]).isEqualTo("mizda");
        assertThat(carNames[2]).isEqualTo("kia");
    }

    @Test
    @DisplayName("car race try count validation")
    void inputTryCountValid() {
        // given
        int tryCount;
        // when
        tryCount = 0;
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            gameController.checkTryCountValue(tryCount);
        });
    }
}
