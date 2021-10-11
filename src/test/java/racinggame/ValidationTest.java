package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racinggame.domain.Validation;

public class ValidationTest {
    @Nested
    @DisplayName("checkCarNameLen 메소드는")
    class Describe_checkCarNameLen {
        @DisplayName("자동차 이름이 다섯글자 이하이면")
        @Nested
        class Context_with_correct {
            @DisplayName("Ture를 반환한다.")
            @Test
            void car_name_length() {
                Validation validation = new Validation();
                assertThat(validation.checkCarNmaeLen("poro")).isTrue();
            }
        }
        @DisplayName("자동차 이름이 다섯글자 초과이면")
        @Nested
        class Context_with_incorrect {
            @DisplayName("False를 반환한다.")
            @Test
            void car_name_length() {
                Validation validation = new Validation();
                assertThat(validation.checkCarNmaeLen("pororo")).isFalse();
            }
        }
    }

}
