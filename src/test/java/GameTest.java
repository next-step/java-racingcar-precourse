import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(3);
    }

    @Test
    @DisplayName("입력받은_골_숫자_검증_성공")
    void setGoalValidTestSuccess() {
        assertThat(new Game(1)).isNotNull().isInstanceOf(Game.class);
    }

    @Test
    @DisplayName("입력받은_골_숫자_검증_실패")
    void setGoalValidTestFail() {
        assertThatThrownBy(() -> new Game(-1)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1 이상의 수를 입력해주세요.");
        assertThatThrownBy(() -> new Game(0)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1 이상의 수를 입력해주세요.");
    }
}
