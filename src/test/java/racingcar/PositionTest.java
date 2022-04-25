package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @DisplayName("Position은 0이상의 값을 갖는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void construct_valid(int source){
        Position position = new Position(source);
        assertThat(position).isEqualTo(new Position(source));
    }

    @DisplayName("Position이 음수를 입력받을 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void construct_inValid(int source){
        assertThatThrownBy(() -> {
            new Position(source);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
