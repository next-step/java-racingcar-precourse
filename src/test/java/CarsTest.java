import model.Car;
import model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {
    @Test
    @DisplayName("Test object creation")
    public void createCars() {
        Cars cars = new Cars("Car1,Car2,Car3");
        List<Car> carList = cars.getCars();
        assertThat(carList.get(0).getName()).isEqualTo("Car1");
        assertThat(carList.get(1).getName()).isEqualTo("Car2");
        assertThat(carList.get(2).getName()).isEqualTo("Car3");
    }


    @Test
    @DisplayName("Test 1 winner")
    public void getWinnersReturnsCorrectWinner() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.move();
        car1.move(); // Car1 moves 2 steps

        car2.move(); // Car2 moves 1 step

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        List<Car> winners = cars.getWinners();
        assertThat(winners.get(0).getName()).isEqualTo("Car1");
    }

    @Test
    @DisplayName("Test multiple winner")
    public void getWinnersReturnsMultipleWinners() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        car1.move();
        car2.move(); // Both cars move 1 step

        Cars cars = new Cars(Arrays.asList(car1, car2));

        List<Car> winners = cars.getWinners();
        assertThat(winners.get(0).getName()).isEqualTo("Car1");
        assertThat(winners.get(1).getName()).isEqualTo("Car2");
    }

}
