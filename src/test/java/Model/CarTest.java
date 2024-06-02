package Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("올바른 이름으로 자동차 생성")
    public void testConstructorWithValidName() {
        Car car1 = new Car("Kia");
        assertEquals("Kia", car1.getName());
        assertEquals(0, car1.getPosition());
    }

    @Test
    @DisplayName("긴 이름으로 자동차 생성 시 예외 발생 확인")
    public void testConstructorWithLongName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Car("Mercedes");
        });
        assertEquals("[ERROR] 자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    public void testMove() {
        Car car = new Car("Hyundai");

        assertEquals(0, car.getPosition());

        car.move();
        assertEquals(1, car.getPosition());

        car.move();
        assertEquals(2, car.getPosition());
    }
}