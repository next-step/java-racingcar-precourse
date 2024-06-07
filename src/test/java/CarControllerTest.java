import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Car;
import model.CarRepository;
import view.CarView;
import controller.CarController;

class CarControllerTest {
  private CarRepository carRepository;
  private CarView carView;
  private CarController carController;

  @BeforeEach
  void setUp() {
    carRepository = new CarRepository();
    carView = new CarView();
    carController = new CarController(carRepository, carView);
  }

  @Test
  void addCar() {
    this.carController.AddCar("Car1", 0);
    this.carController.AddCar("Car2", 0);
    this.carController.AddCar("Car3", 0);
    assertEquals(3, carRepository.GetAllCar().size());
  }

  @Test
  void trial() {
    this.carController.AddCar("Car1", 0);
    this.carController.AddCar("Car2", 0);
    this.carController.AddCar("Car3", 0);
    this.carController.Trial();
    this.carController.Trial();
    for (Car car : this.carRepository.GetAllCar()) {
      assertTrue(car.GetForwardStep() >= 0 && car.GetForwardStep() <= 10);
    }
    this.carController.printWinners(); // This should print the names of cars with the highest forward steps.
  }
}