import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("Car 생성 테스트")
    public void testCarCreate() {
        Car car = new Car("car1");
        assertEquals("car1", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("Car Move 테스트")
    public void testCarMove() {
        Car car = new Car("car1");
        car.move();
        assertEquals(1, car.getPosition());
        car.move();
        assertEquals(2, car.getPosition());
    }
}
