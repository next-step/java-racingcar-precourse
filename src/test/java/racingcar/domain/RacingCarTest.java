package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.constants.ErrorMessage;

@DisplayName("RacingCar클래스")
public class RacingCarTest {

    @DisplayName("RacingCar의 생성자는")
    @Nested
    class Describe_Racing_Car_Constructor {

        @DisplayName("입력된 이름이 5자를 넘어갈 경우")
        @Nested
        class Context_Input_Name_Length_Is_More_Than_Five {

            final String carName = "america";

            @DisplayName("IllegalArgumentException(자동차의 이름은 5자 이하만 가능합니다.)을 발생시킨다.")
            @Test
            void it_Throws_IllegalArgumentException() {

                final IllegalArgumentException illegalArgumentException =
                        assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));

                final String errorMessage = illegalArgumentException.getMessage();

                assertThat(errorMessage).isEqualTo(ErrorMessage.CAR_NAME_LENGTH_IS_MORE_THAN_FIVE);

            }

        }

        @DisplayName("입력된 이름이 공백일 경우")
        @Nested
        class Context_Input_Name_Is_Empty {

            final String carName = "";

            @DisplayName("IllegalArgumentException(자동차의 이름은 공백으로 할 수 없습니다.)을 발생시킨다.")
            @Test
            void it_Throws_IllegalArgumentException() {

                final IllegalArgumentException illegalArgumentException =
                        assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));

                final String errorMessage = illegalArgumentException.getMessage();

                assertThat(errorMessage).isEqualTo(ErrorMessage.CAR_NAME_IS_EMPTY);

            }

        }

    }
}
