package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCarRule.NAME_LENGTH_EXCEPTION;
import static racingcar.domain.RacingCarRule.NAME_NULL_EXCEPTION;

class CarNameTest {

    @Nested
    @DisplayName("CarName 생성자는")
    class Describe_CarNameConstructor {

        @Nested
        @DisplayName("자동차 이름이 null,공백 또는 사이즈가 0 이라면")
        class Context_NameIsNullOrSizeZeroOrWhitespace {

            @Test
            @DisplayName("자동차 이름을 입력하라는 예외를 던진다.")
            void It_ThrowException() {
                assertThatThrownBy(() -> new CarName(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NAME_NULL_EXCEPTION);

                assertThatThrownBy(() -> new CarName(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NAME_NULL_EXCEPTION);

                assertThatThrownBy(() -> new CarName(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NAME_NULL_EXCEPTION);
            }
        }

        @Nested
        @DisplayName("자동차 이름이 6글자 이상이라면")
        class Context_NameIsOverLength {

            private final String name = "abcdef";

            @Test
            @DisplayName("자동차 이름 길이를 확인하라는 예외를 던진다.")
            void It_ThrowException() {
                assertThatThrownBy(() -> new CarName(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NAME_LENGTH_EXCEPTION);
            }
        }

        @Nested
        @DisplayName("자동차 이름이 1글자 이상 5글자 이하라면")
        class Context_NameLengthIsValid {

            private final String fiveLengthName = "abcde";

            @Test
            @DisplayName("객체를 생성한다.")
            void It_MakeObject() {
                CarName carName = new CarName(fiveLengthName);

                assertThat(carName.getName()).isEqualTo(fiveLengthName);
            }
        }
    }
}
