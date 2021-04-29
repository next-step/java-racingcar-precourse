package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    @Test
    @DisplayName("증가가 가능하다.")
    public void 증가가_가능하다() {
        Position position = new Position();

        Position newPosition = position.increase();

        assertThat(newPosition)
                .isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("위치는 음수가 없다.")
    public void 위치는_음수가_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1));
    }
}
