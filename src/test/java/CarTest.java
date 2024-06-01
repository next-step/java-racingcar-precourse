import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자 이하일 때 생성자 테스트")
    void testCarNameLengthValid() {
        Car car = new Car("Audi");
        assertEquals("Audi", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 때 예외 테스트")
    void testCarNameLengthInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("Morning");
        });
        assertEquals("[ERROR] 자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함될 때 예외 테스트")
    void testCarNameWithSpace() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("B M W");
        });
        assertEquals("[ERROR] 자동차 이름에 공백을 포함할 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("randomValue가 4 이상일 때 자동차가 움직이는지 테스트")
    void testCarMove() {
        Car car = new Car("Kia");
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("randomValue가 4 미만일 때 자동차가 움직이지 않는지 테스트")
    void testCarDoesNotMove() {
        Car car = new Car("Kia");
        car.move(3);
        assertEquals(0, car.getPosition());
    }
}
