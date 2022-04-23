package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;
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
import racingcar.input.validator.CarNamesValidatorGroup;

public class RacingCarInputTest {
    private MockedStatic<Console> console;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("자동차 이름을 정상적으로 입력하면 정상적으로 validator 에 통과해 반환되어야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("정상적인_자동차_이름_input")
    void racingCarInput_success_test(String input) {
        CarNamesValidatorGroup carNamesValidatorGroup = new CarNamesValidatorGroup();

        when(Console.readLine())
                .thenReturn(input);

        RacingCarInput racingCarInput = new RacingCarInput(carNamesValidatorGroup);
        assertThat(racingCarInput.getCarNames()).isEqualTo(input);
    }

    private static Stream<? extends Arguments> 정상적인_자동차_이름_input() {
        return Stream.of(
                Arguments.of("wood , mask , 1123 , 2"),
                Arguments.of("test , qq , 2 , mycar"),
                Arguments.of("test1 , test2 , test3 , test4 , test5 , test6")
        );
    }

    @Nested
    @DisplayName("자동차 이름이 문제가 있으면 다시 입력받을 수 있어야 한다")
    class RacingCarInputFailedTest {
        String 잘못된_입력값_1 = "wood , mask23 , 1123789 , 2";
        String 잘못된_입력값_2 = "test , test , 2 , mycar55";
        String 잘못된_입력값_3 = "test10";

        String 정상적인_입력값 = "pobi , wobe , rade , test";

        @DisplayName("잘못된 값이 3번 입력되고 이후 정상적인 입력이 된다면 "
                + "validate 는 4번 호출되어야 한다")
        @Test
        void racingCarInput_length_failed_test() {
            CarNamesValidatorGroup validatorGroup = mock(CarNamesValidatorGroup.class);

            doThrow(new IllegalArgumentException()).when(validatorGroup)
                    .validate(잘못된_입력값_1);
            doThrow(new IllegalArgumentException()).when(validatorGroup)
                    .validate(잘못된_입력값_2);
            doThrow(new IllegalArgumentException()).when(validatorGroup)
                    .validate(잘못된_입력값_3);

            when(Console.readLine())
                    .thenReturn(
                            잘못된_입력값_1,
                            잘못된_입력값_2,
                            잘못된_입력값_3,
                            정상적인_입력값
                    );

            new RacingCarInput(validatorGroup);

            verify(validatorGroup, times(4))
                    .validate(anyString());
        }
    }
}
