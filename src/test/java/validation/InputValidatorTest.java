package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @DisplayName("[validateIsNumber()] 숫자외의 문자를 입력했을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2k3", "머ㅏㅣㄴㅇㄹ3","234,./"})
    void test_validateIsNumber(String input){
        assertThatThrownBy(()->InputValidator.validateIsNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[validateIsNumber()] 숫자외의 문자를 입력했을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2k3asdf", "머ㅏㅣㄴㅇㄹ3","jweiqksldfsag"})
    void test_validateIsNameLessThan5(String input){
        assertThatThrownBy(()->InputValidator.validateIsNameLessThan5(input)).isInstanceOf(IllegalArgumentException.class);
    }
}