package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.RacingCarRule.NAME_LENGTH_EXCEPTION;
import static racingcar.domain.RacingCarRule.NAME_NULL_EXCEPTION;

class CarTest {

    @Nested
    @DisplayName("Car 생성자는")
    class Describe_CarConstructor {

        @Nested
        @DisplayName("자동차 이름이 null이라면")
        class Context_NameIsNull {

            @Test
            @DisplayName("자동차 이름을 입력하라는 예외를 던진다.")
            void It_ThrowException() {
                assertThatThrownBy(() -> new Car(null))
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
                assertThatThrownBy(() -> new Car(name))
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
                Car car = new Car(fiveLengthName);

                assertThat(car.getName()).isEqualTo(fiveLengthName);
            }
        }
    }

    @Nested
    @DisplayName("move()")
    class Describe_MoveMethod {

        @Nested
        @DisplayName("전달받은 숫자가 4 이상이라면")
        class Context_NumberIsMoreThan4 {

            private final String name = "test";
            private final int number = 4;
            private final int move = 1;

            @Test
            @DisplayName("앞으로 전진한다.")
            void It_MoveForward() {
                Car car = new Car(name);
                car.move(number, new CarForwardStrategy());

                assertThat(car.toStringIfWinner(move)).isEqualTo(name);
            }
        }
    }
}
