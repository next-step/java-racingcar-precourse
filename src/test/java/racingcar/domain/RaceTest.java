package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void 경주를_진행하고_경주_결과를_반환() {
        Race race = new Race(
                Arrays.asList(new Car("씽씽이"), new Car("쌩썡이")),
                new GameCount(1),
                new AlwaysMovingStrategy());
        List<Car> cars = race.run();
        Assertions.assertThat(cars)
                .isEqualTo(
                        Arrays.asList(
                                new Car("씽씽이", new Location(1)),
                                new Car("쌩썡이", new Location(1))
                        ));
    }

    @Test
    void 경주_진행_여부를_확인한다() {
        Race race = new Race(
                Arrays.asList(new Car("씽씽이"), new Car("쌩썡이")),
                new GameCount(1),
                new AlwaysMovingStrategy());
        race.run();
        Assertions.assertThat(race.onPlay()).isFalse();
    }

    @Test
    void 경주의_우승자를_조회한다() {
        Race race = new Race(
                Arrays.asList(new Car("씽씽이"), new Car("쌩썡이")),
                new GameCount(1),
                new AlwaysMovingStrategy());
        race.run();
        Assertions.assertThat(race.getWinners())
                .isEqualTo(
                        Arrays.asList(
                                new Car("씽씽이", new Location(1)),
                                new Car("쌩썡이", new Location(1))
                        ));
    }
}
