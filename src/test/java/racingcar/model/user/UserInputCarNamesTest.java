package racingcar.model.user;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserInputCarNamesTest {

    @ParameterizedTest
    @DisplayName("입력받은 문자열이 빈칸이거나, 중복된 이름이 있는지 검사한다.")
    @MethodSource("provideArgumentsForCarNamesListCheck")
    public void 입력받은_문자열의_유효성검사(List<String> inputList) {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserInputCarNames(inputList));
    }

    private static Stream<Arguments> provideArgumentsForCarNamesListCheck() {
        return Stream.of(
            Arguments.of(Collections.emptyList()),
            Arguments.of(Arrays.asList("test", "test"))
        );
    }

}
