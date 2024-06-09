package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("위치 테스트")
public class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 100})
    void 위치_생성(final int value) {
        Position position = new Position(value);

        assertThat(position).isEqualTo(new Position(value));
    }

    @Test
    void 위치를_1_증가_시켜_반환한다() {
        Position position = new Position(0);

        assertThat(position.forward()).isEqualTo(new Position(1));
    }

    @Test
    void 위치_값보다_전달_받은_위치_값이_작으면_flase를_반환한다() {
        Position position = new Position(10);

        assertAll(
                () -> assertThat(position.isUpper(new Position(11))).isFalse(),
                () -> assertThat(position.isUpper(new Position(9))).isTrue(),
                () -> assertThat(position.isUpper(new Position(-100))).isTrue()
        );
    }
}
