package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PresenterTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("사용자가 쉼표를 기준으로 입력한 갯수만큼 Array 를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideUserInput")
    public void sameInputSizeWithListSize(final String mockInput, final int expectedLength) {
        Runnable runnable = () -> {
            Optional<Name[]> names = Presenter.inputCarNames();
            assertThat(names.isPresent()).isTrue();
            assertThat(names.get().length).isEqualTo(expectedLength);
        };
        usingMockInput(mockInput, runnable);
    }

    private static Stream<Arguments> provideUserInput() {
        return Stream.of(
                Arguments.of("pobi,woni,jun", 3),
                Arguments.of("pobi", 1)
        );
    }

    @DisplayName("사용자가 입력을 잘못하면 ERROR 메시지를 출력한다.")
    @Test
    public void invalidInputTest() {
        Runnable runnable = () -> {
            Presenter.inputCarNames();
            assertSimpleTest(() -> Assertions.assertThat(output()).contains(ERROR_MESSAGE));
        };
        usingMockInput("", runnable);
    }

    @DisplayName("레이싱 횟수를 위한 입력값을 받는다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void inputCount(final int expectedCount) {
        Runnable runnable = () -> {
            Optional<RacingCount> isNumber = Presenter.inputRacingCount();
            assertThat(isNumber.isPresent()).isTrue();
            assertThat(isNumber.get()).isEqualTo(new RacingCount(expectedCount));
        };
        usingMockInput(String.valueOf(expectedCount), runnable);
    }

    @DisplayName("레이싱 횟수 입력시 잘못된 값을 입력하면 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1","a"})
    public void invalidRacingTryCount(final String count) {
        Runnable runnable = () -> {
            Presenter.inputRacingCount();
            assertSimpleTest(() -> Assertions.assertThat(output()).contains(ERROR_MESSAGE));
        };
        usingMockInput(count, runnable);
    }

    @DisplayName("winner 출력")
    @Test
    public void winnerPrint() {
        Runnable runnable = () -> {
            Presenter.winnerPrint(new Name[]{new Name("pobi"), new Name("honux")});
            assertSimpleTest(() -> Assertions.assertThat(output()).contains("최종 우승자: pobi, honux"));
        };
    }

    private void usingMockInput(final String mockInput, Runnable runnable) {
        try (MockedStatic<Console> consoleMockedStatic = Mockito.mockStatic(Console.class)) {
            consoleMockedStatic.when(Console::readLine).thenReturn(mockInput);
            runnable.run();
        }
    }

    @Override
    protected void runMain() {
        Presenter.inputCarNames();
    }
}
