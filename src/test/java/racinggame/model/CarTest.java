package racinggame.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.exception.ValidationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @ParameterizedTest
    @CsvSource({"4", "5", "6", "7", "8", "9"})
    void 자동차_전진_테스트() {
        Car car = new Car("joel");
        car.moving(4);

        assertThat(car.getDistance().getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2", "3"})
    void 자동차_멈춤_테스트() {
        Car car = new Car("joel");
        car.moving(2);

        assertThat(car.getDistance().getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"123456", "joelel", "한글이름이다"})
    void 자동차_이름_입력_오류_테스트(String name) throws ValidationException {
        assertThrows(ValidationException.class, () -> {
            new Car(name);
        });
    }

}
