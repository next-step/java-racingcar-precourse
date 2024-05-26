import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("3개의 차가 있을 때, 우승자의 postion보다 다른 차들의 position이 적은지 확인하는 테스트")
    void raceWinners() {
        Race race = new Race(Arrays.asList("car1", "car2", "car3"), 5);
        race.start();

        List<Car> winners = race.getWinners();
        int maxPosition = winners.get(0).getPosition();

        for (Car car : race.getCars()) {
            assertThat(car.getPosition()).isLessThanOrEqualTo(maxPosition);
        }
    }
}