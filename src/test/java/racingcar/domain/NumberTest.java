package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @Nested
    @DisplayName("Number 생성자는")
    class Describe_NumberConstructor {

        @Nested
        @DisplayName("숫자가 아닌 문자가 포함되어 있다면")
        class Context_ContainsNonNumeric {

            private final String containsSymbol = "12.235";
            private final String containsAlphabet = "1ab3";

            @Test
            @DisplayName("예외를 던진다.")
            void It_ThrowException() {
                assertThatThrownBy(() -> new Number(containsSymbol))
                        .isInstanceOf(IllegalArgumentException.class);

                assertThatThrownBy(() -> new Number(containsAlphabet))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("숫자로만 이루어져 있다면")
        class Context_OnlyNumeric{

            private final String onlyNumeric = "12345";

            @Test
            @DisplayName("Number객체를 생성한다.")
            void It_MakeNumber(){
                Number number = new Number(onlyNumeric);
                int numeric = Integer.parseInt(onlyNumeric);
                assertThat(number.isEqual(numeric)).isTrue();
            }
        }
    }
}
