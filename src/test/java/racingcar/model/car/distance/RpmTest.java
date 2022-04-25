package racingcar.model.car.distance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.error.Error;

public class RpmTest {
    @ParameterizedTest(name = "{index} : {1}")
    @MethodSource("inValidParameterExpected")
    @DisplayName("유효하지않은 level에 따른 예외발생 테스트")
    void 비정상범위_LEVEL값_입력에따른_예외발생테스트(int level, String displayName) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Rpm(level));
        assertThat(e.getMessage()).isEqualTo(Error.NOT_VALID_LEVEL.message());
    }

    private static Stream<Arguments> inValidParameterExpected() {
        return Stream.of(
                Arguments.of(-1, "level이 -1인 경우 전진 불가능"),
                Arguments.of(10, "level이 10인 경우 전진 불가능")
        );
    }
}
