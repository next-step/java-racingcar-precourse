import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void testMove() {
        Car car = new Car("MyCar");
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    public void testGetName() {
        String name = "Test";
        Car car = new Car(name);
        assertEquals(name, car.getName());
    }
}
