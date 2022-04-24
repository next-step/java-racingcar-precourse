package racingcar.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    private static InputValidator inputValidator;

    @BeforeAll
    static void setup() {
        inputValidator = InputValidator.getInstance();
    }

    @Test
    @DisplayName("싱글턴 확인하는 테스트")
    void 싱글턴확인() {
        InputValidator newInputValidator = InputValidator.getInstance();

        assertThat(inputValidator.hashCode()).isEqualTo(newInputValidator.hashCode());
    }

    @Test
    @DisplayName("입력값이 없는 경우 테스트")
    void 입력없는에러() {
        String input = "";

        assertThatThrownBy(() -> {
            inputValidator.validateEmpty(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EmptyValue.toString());
    }

    @Test
    @DisplayName("한명의 참가자만 있는 경우 테스트")
    void 참가자한명에러() {
        String input = "thor";
        String input_2 = "thor,";

        assertThatThrownBy(() -> {
            inputValidator.validateLeastCandidate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LeastCandidate.toString());


        assertThatThrownBy(() -> {
            inputValidator.validateLeastCandidate(input_2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LeastCandidate.toString());
    }

    @Test
    @DisplayName("이름이 중복되는 경우 테스트")
    void 입름중복에러() {
        String input = "shwan,shwan";

        assertThatThrownBy(() -> {
            inputValidator.validateSameName(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SameName.toString());
    }

    @Test
    @DisplayName("이름이 비어있는 경우 테스트")
    void 빈이름에러() {
        String input = "shwan,,son";
        String[] names = input.split(",");
        List<String> nameList = Arrays.asList(names);

        assertThat(nameList.contains("")).isTrue();

        assertThatThrownBy(() -> {
            inputValidator.validateEmptyName("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EmptyName.toString());

    }

    @Test
    @DisplayName("이름글자수가 큰 경우 테스트")
    void 긂자수제한에러() {
        String name = "shwan323.lee";

        assertThatThrownBy(() -> {
            inputValidator.validateNameLimit(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ExceedCount.toString());
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어온 경우 테스트")
    void 숫자아닌값에러() {
        String number = "3d";

        assertThatThrownBy(() -> {
            inputValidator.validateNumber(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NotNumber.toString());
    }

    @Test
    @DisplayName("공백이 포함된 경우 예외 테스트")
    void 띄어쓰기포함에러() {
        String input = "AAA,BBB, CCC";

        assertThatThrownBy(() -> {
            inputValidator.validateSplitWord(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.SplitChar.toString());
    }

    @Test
    @DisplayName("숫자 값이 범위 초과로 크게 들어온 경우 테스트")
    void 숫자범위밖에러() {
        String number = "3000000000";

        assertThatThrownBy(() -> {
            inputValidator.validateNumberRange(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ExceedNumber.toString().toString());
    }
}