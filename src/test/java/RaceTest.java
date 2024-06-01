import Model.Car;
import Model.Race;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class RaceTest {
    @Test
    void 경주_우승자_테스트() {

        Race race = new Race(Arrays.asList("pobi", "woni", "jun"));

        race.start(0);

        List<Car> cars = getCarsFromRace(race);

        cars.get(0).move(4);
        cars.get(0).move(4);
        cars.get(1).move(4);
        cars.get(2).move(4);

        List<Car> winners = race.getWinners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    private List<Car> getCarsFromRace(Race race) {
        try {
            var field = Race.class.getDeclaredField("cars");
            field.setAccessible(true);
            return (List<Car>) field.get(race);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
