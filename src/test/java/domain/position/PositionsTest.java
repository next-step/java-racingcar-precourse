package domain.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionsTest {
    @Test
    @DisplayName("최고의 점수를 얻을 수 있다")
    public void 최고의_점수를_얻을_수_있다() {
        Positions positions = new Positions(
                Arrays.asList(
                        new Position(1),
                        new Position(2),
                        new Position(6),
                        new Position(4),
                        new Position(5)
                )
        );

        assertThat(positions.getMaxPosition())
                .isEqualTo(new Position(6));
    }
}
