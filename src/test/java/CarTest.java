import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 숫자가 4 이상일 때 이동 검증")
    void move(int randomNumber) {
        Car car = new Car("Test");
        car.setFixedRandomNumber(randomNumber);
        car.move();
        assertEquals(1, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 숫자가 4 미만일 때 움직이지 않는 것 검증")
    void stop(int randomNumber) {
        Car car = new Car("Test");
        car.setFixedRandomNumber(randomNumber);
        car.move();
        assertEquals(0, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "123456", "longname"})
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생 검증")
    void nameEx(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12345", "long"})
    @DisplayName("자동차 이름이 5자 이하면 예외가 없음")
    void nameOk(String name) {
        new Car(name); // 예외가 발생하지 않으면 테스트 통과
    }
}
