package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Nested
    @DisplayName("carsSplit 메소드는")
    class Describe_checkCarNameLen {
        @DisplayName("나열된 자동차 이름들을")
        @Nested
        class Context_with_correct {
            @DisplayName("',' 기준으로 분리한다.")
            @Test
            void car_name_length() {
                String carsName = "prr,rupi,edi";
                Cars cars = new Cars(carsName);
                assertThat(cars.cars).contains("prr", "rupi", "edi");
            }
        }
    }
}
