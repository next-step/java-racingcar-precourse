import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void inputCarNamesValid() {
        // given
        String names = "honda, mizda  , genesis,kia";
        // when
        String[] carNames = names.split(",");
        // then
        assertThrows(IllegalArgumentException.class, () -> {
            gameController.checkNameLength(carNames);
        });
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
