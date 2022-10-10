package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.utils.ConvertUtil.*;

public class ConvertUtilTest {

    @DisplayName("숫자 이외의 값이 입력되면 예외를 리턴한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,@,3", "10,2,3:=", "%,),2:*"})
    void convertToNumberTest(String input){
        assertThatThrownBy(() -> {
            convertStringToInteger(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
