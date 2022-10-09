package racingcar.model.cars;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarsValidatorTest {
    @Test
    void 인식_문자열() {
        String[] strings = new String[]{"blah,1@!~", "가나다,123,  _ ", "가나다, ,   1", "-"};
        this.assertAcceptable(strings);
    }

    @Test
    void 인식_예외_이름_길이_범위_벗어남() {
        String[] errorStrings = new String[]{"여섯글자길이", " 공백포함6", " 공  백 "};
        this.assertNotAcceptableThrowException(errorStrings);
    }

    @Test
    void 인식_예외_이름_중복() {
        String[] errorStrings = new String[]{"중복,중복", "!중복, !중복,!중복", " 중 복 , 중 복 ", " 중복 , 중복 "};
        this.assertNotAcceptableThrowException(errorStrings);
    }

    private void assertAcceptable(String[] strings) {
        for (String s : strings) {
            this.assertAcceptableString(s);
        }
    }

    private void assertAcceptableString(String s) {
        try {
            CarsValidator.assertValid(s);
            assertTrue(Boolean.TRUE);
        } catch (IllegalArgumentException e) {
            fail("Illegal value error occurred.");
        }
    }

    private void assertNotAcceptableThrowException(String[] errorStrings) {
        for (String errorString : errorStrings) {
            assertThatThrownBy(() -> CarsValidator.assertValid(errorString)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}
