package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.constants.ErrorMessage;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

@DisplayName("RacingCarFactory클래스")
public class RacingCarFactoryTest {

    @Nested
    @DisplayName("makeCars()는")
    class Describe_Make_Racing_Cars {

        @Nested
        @DisplayName("문자열 \"pobi,crong,honux\"를 받으면")
        class Context_Input_Seprated_With_Comma {

            final String input = "pobi,crong,honux";

            @Test
            @DisplayName("각자의 이름을 가진 3개의 자동차를 생성한다.")
            void It_Create_Cars() {

                final RacingCars racingCars = RacingCarFactory.makeCars(input);

                final String[] names = input.split(",");

                for (int i = 0; i < racingCars.size(); i++) {
                    final RacingCar racingCar = racingCars.get(i);
                    assertThat(racingCar.getName()).isEqualTo(names[i]);
                }

            }

        }

        @Nested
        @DisplayName("문자열 \"pobi,pobi,honux\"를 받으면")
        class Context_Input_Duplicated {

            final String input = "pobi,pobi,honux";

            @Test
            @DisplayName("IllegalArgumentException(자동차의 이름은 중복이 될 수 없습니다.)을 발생시킨다.")
            void It_Throws_IllegalArgumentException() {

                final IllegalArgumentException illegalArgumentException =
                        assertThrows(IllegalArgumentException.class, () -> RacingCarFactory.makeCars(input));

                final String errorMessage = illegalArgumentException.getMessage();

                assertThat(errorMessage).isEqualTo(ErrorMessage.CAR_NAME_IS_DUPLICATE);

            }

        }

    }

}
