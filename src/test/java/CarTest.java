import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("TestCar");
    }

    @Test
    @DisplayName("Car 클래스 생성 이후 초기값 설정 확인")
    public void testInitialValues() {
        assertEquals("TestCar", car.getName());
        assertEquals(0, car.getDistance());
        assertEquals("", car.getProgressLine());
    }

    @Test
    @DisplayName("moveForward 한 번 실행 이후 결과 확인")
    public void testMoveForwardOnce() {
        car.moveForward();
        assertEquals(1, car.getDistance());
        assertEquals("-", car.getProgressLine());
    }

    @Test
    @DisplayName("moveForward 세 번 실행 이후 결과 확인")
    public void testMoveForwardMultipleTimes() {
        car.moveForward();
        car.moveForward();
        car.moveForward();
        assertEquals(3, car.getDistance());
        assertEquals("---", car.getProgressLine());
    }
}
