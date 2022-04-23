package racingcar.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import racingcar.domain.MoveCount;
import racingcar.input.validator.InputValidator;
import racingcar.input.validator.impl.MoveCountValidator;

public class MoveCountInputTest {
    private MockedStatic<Console> console;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("시도 횟수를 1~9 사이의 정상적인 값을 입력하면 validator 에 통과해 반환되어야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("정상적인_이동횟수_입력값")
    void move_count_success_test(String input) {
        InputValidator validator = new MoveCountValidator();

        when(Console.readLine())
                .thenReturn(input);

        MoveCountInput moveCountInput = new MoveCountInput(validator);
        MoveCount moveCount = moveCountInput.getMoveCount();
        assertEquals(moveCount.getRemainingMoveCount(), Integer.parseInt(input));
    }

    private static Stream<? extends Arguments> 정상적인_이동횟수_입력값() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("2"),
                Arguments.of("3"),
                Arguments.of("5"),
                Arguments.of("7"),
                Arguments.of("8"),
                Arguments.of("9")
        );
    }

    @Nested
    @DisplayName("이동횟수 입력 실패 테스트 - (잘못된 값을 입력하면 다시 입력할 수 있어야 한다)")
    class MoveCountFailed {
        @DisplayName("1~9 사이 이외의 값을 두번 입력후  1~9 사이의 값을 입력하면 "
                + "validate 가 3번 호출되어야 한다")
        @Test
        void move_count_failed_test() {
            InputValidator validator = mock(MoveCountValidator.class);

            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("123");
            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("456");

            when(Console.readLine())
                    .thenReturn("123", "456", "5");

            new MoveCountInput(validator);
            verify(validator, times(3)).validate(anyString());
        }

        @DisplayName("1~9 사이 이외의 값을 한번 입력후  1~9 사이의 값을 입력하면 "
                + "validate 가 2번 호출되어야 한다")
        @Test
        void move_count_failed_test_v2() {
            InputValidator validator = mock(MoveCountValidator.class);

            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("-5");

            when(Console.readLine())
                    .thenReturn("-5", "5");

            new MoveCountInput(validator);
            verify(validator, times(2)).validate(anyString());
        }

        @DisplayName("1~9 사이 이외의 값을 다섯번 연속 입력후  1~9 사이의 값을"
                + " 입력하면 validate 가 6번 호출되어야 한다")
        @Test
        void move_count_failed_test_v3() {
            InputValidator validator = mock(MoveCountValidator.class);

            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("-5");
            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("123");
            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("asd");
            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("11");
            doThrow(new IllegalArgumentException()).when(validator)
                    .validate("efw1");

            when(Console.readLine())
                    .thenReturn("-5", "123", "asd", "11", "efw1", "8");

            new MoveCountInput(validator);
            verify(validator, times(6)).validate(anyString());
        }
    }
}
