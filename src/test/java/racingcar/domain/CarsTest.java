package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.Constant;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    @ParameterizedTest
    @DisplayName("Car 객체 생성 테스트")
    @CsvSource(value = {"yoon,lee,kim:3", "yoon,lee:2", "yoon:1"}, delimiter = ':')
    void validateCreateCarsTest(String input, String expected) {
        // given
        // when
        Cars cars = Cars.createCars(input.split(Constant.COLON)[0]);
        // then
        assertEquals(cars.getCarItems().size(), Integer.parseInt(expected));
    }
}
