import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    @DisplayName("3개의 차가 있을 때, 2회 시도시 우승자의 수가 맞는지 확인하는 테스트")
    void raceWinners() {

        Race race = new Race(List.of("Car1", "Car2", "Car3"), 2);
        List<Car> cars = race.getCars();

        cars.get(0).move(4);
        cars.get(0).move(5);
        cars.get(1).move(5);
        cars.get(1).move(1);
        cars.get(2).move(2);
        cars.get(2).move(3);

        List<Car> winners = race.getWinners();

        assertEquals(1,winners.size());
    }
}