package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.ExceptionType;
import racingcar.input.validator.InputValidator;
import racingcar.input.validator.impl.CarNamesLengthValidator;
import racingcar.input.validator.impl.CarNamesOverlapValidator;
import racingcar.input.validator.impl.CarQtyValidator;
import racingcar.input.validator.impl.MoveCountValidator;

public class InputValidatorTest {

    @DisplayName("자동차의 이름이 5자 이상이라면 IllegalArgumentException 이 발생해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("이름이_다섯자리_이상이_포함된_입력값")
    void car_name_input_test(String input) {
        InputValidator validator = new CarNamesLengthValidator();

        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.IS_NAME_LENGTH_OVER_FIVE.getMessage());
    }

    private static Stream<? extends Arguments> 이름이_다섯자리_이상이_포함된_입력값() {
        return Stream.of(
                Arguments.of("123 , woob , asdasd"),
                Arguments.of("qq , min , loss , drogba"),
                Arguments.of("jack , hoy , black , yellow2")
        );
    }


    @DisplayName("자동차의 개수가 2개 이상이 아니라면 IllegalArgumentException 이 발생해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("자동차의_개수가_두개_미만인_입력값")
    void car_qty_input_test(String input) {
        InputValidator validator = new CarQtyValidator();

        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.IS_CAR_QTY_UNDER_TWO.getMessage());
    }

    private static Stream<? extends Arguments> 자동차의_개수가_두개_미만인_입력값() {
        return Stream.of(
                Arguments.of("123"),
                Arguments.of("qq.we"),
                Arguments.of("jack")
        );
    }

    @DisplayName("자동차의 이름이 중복된다면 IllegalArgumentException 이 발생해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("자동차의_이름이_중복인_입력값")
    void car_names_overlap_input_test(String input) {
        InputValidator validator = new CarNamesOverlapValidator();

        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.NOT_CONTAINS_CAR_NAMES_OVERLAP.getMessage());
    }

    private static Stream<? extends Arguments> 자동차의_이름이_중복인_입력값() {
        return Stream.of(
                Arguments.of("123 , 123 , wes"),
                Arguments.of("qq.we , qq3 , qq.we"),
                Arguments.of("jack , dani , deny , dani")
        );
    }

    @DisplayName("1~9 이외의 시도횟수가 입력된다면 IllegalArgumentException 이 발생해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("잘못된_시도횟수_입력값")
    void move_count_input_test(String input) {
        InputValidator validator = new MoveCountValidator();

        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.INVALID_MOVE_COUNT_INPUT.getMessage());
    }

    private static Stream<? extends Arguments> 잘못된_시도횟수_입력값() {
        return Stream.of(
                Arguments.of("-5"),
                Arguments.of("asd"),
                Arguments.of(""),
                Arguments.of("11"),
                Arguments.of("23")
        );
    }
}
