package racingcar.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @ParameterizedTest(name = "입력된 자동차 이름은 쉼표를 기준으로 구분한다.")
    @MethodSource("provideInputRacingCarNamesTest")
    void inputRacingCarNamesTest(String given, List<String> expected) {
        final InputView inputView = new InputView(() -> given);
        final List<String> actual = inputView.readRacingCarNames();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideInputRacingCarNamesTest() {
        return Stream.of(
                Arguments.of("aaa", Arrays.asList("aaa")),
                Arguments.of("aaa,bbb,ccc", Arrays.asList("aaa", "bbb", "ccc"))
        );
    }

}