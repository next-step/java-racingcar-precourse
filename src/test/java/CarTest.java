
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Car;
class CarTest {

  @Test
  void setCarName() {
    Car car = new Car("test", 0);
    car.SetCarName("test2");
    assertEquals("test2", car.GetCarName());

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      car.SetCarName("toolongname");
    });
    assertEquals("[ERROR] length of car name is under 5 charcters.", exception.getMessage());
  }

  @Test
  void getCarName() {
    Car car = new Car("test", 0);
    assertEquals("test", car.GetCarName());
  }

  @Test
  void setForwardStep() {
    Car car = new Car("test", 0);
    car.SetForwardStep(5);
    assertEquals(5, car.GetForwardStep());
  }

  @Test
  void getForwardStep() {
    Car car = new Car("test", 0);
    assertEquals(0, car.GetForwardStep());
    car.SetForwardStep(5);
    assertEquals(5, car.GetForwardStep());
  }
}
