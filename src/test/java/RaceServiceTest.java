import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import service.RaceService;
import service.RaceServiceInterface;

public class RaceServiceTest {

    @Test
    void addCarsTest() {
        RaceServiceInterface raceService = new RaceService();
        String[] cars = {"jih", "hyu", "abc", "xyz"};
        raceService.addCars(cars);
        int numberOfCars = raceService.getNumberOfCars();
        Assertions.assertThat(numberOfCars).isEqualTo(4);
    }
}
