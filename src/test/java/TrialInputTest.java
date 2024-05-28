import static org.assertj.core.api.Assertions.assertThatThrownBy;

import controller.GameController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrialInputTest {

    GameController gameController;

    public TrialInputTest() {
        this.gameController = new GameController();
    }

    @Test
    void validTrial() {
        Assertions.assertThat(gameController.getTrial("1")).isEqualTo(1);
        Assertions.assertThat(gameController.getTrial("50")).isEqualTo(50);
        Assertions.assertThat(gameController.getTrial("100")).isEqualTo(100);
    }

    @Test
    void inValidTrial() {
        assertThatThrownBy(
            () -> gameController.getTrial("")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getTrial("string")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getTrial("12a")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getTrial("1 2")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getTrial("12 ")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getTrial("0")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getTrial("101")
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
            () -> gameController.getTrial("-1")
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
