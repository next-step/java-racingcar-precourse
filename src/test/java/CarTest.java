import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void moveTest(Integer input, Integer expectedMileage) {
        // given
        Car movedCar = Car.of("테스트");

        // when
        movedCar.move(input);

        // then
        assertThat(movedCar.getMileage()).isEqualTo(Mileage.of(expectedMileage));
    }
}