import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void testMove() {
        Car car = new Car("car1");
        car.move(4); // 조건에 따라 이동
        assertEquals(1, car.getPosition());
        car.move(3); // 이동하지 않음
        assertEquals(1, car.getPosition());
    }
}
