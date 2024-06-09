package model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class RaceTest {
    @Test
    public void shouldCreateAndInitializeCars() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Race race = new Race(carNames);

        assertThat(race.getCars()).hasSize(3);
        assertThat(race.getCars()).extracting("name", "position")
            .containsExactly(
                tuple("pobi", 0),
                tuple("woni", 0),
                tuple("jun", 0)
            );
    }

    @Test
    public void shouldDetermineWinners() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Race race = new Race(carNames);

        // 강제로 차를 움직여 우승자 결정
        race.getCars().get(0).move();
        race.getCars().get(0).move();
        race.getCars().get(1).move();
        race.getCars().get(2).move();
        race.getCars().get(2).move();

        List<Car> winners = race.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name")
            .contains("pobi", "jun");
    }

    @Test
    public void shouldRunRaceAndMoveCars() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Race race = new Race(carNames);

        race.run(5);

        assertThat(race.getCars()).allSatisfy(car ->
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0)
        );
    }

    @Test
    public void shouldHaveMultipleWinnersIfTied() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Race race = new Race(carNames);

        race.getCars().get(0).move();
        race.getCars().get(1).move();
        race.getCars().get(1).move();
        race.getCars().get(2).move();
        race.getCars().get(2).move();

        List<Car> winners = race.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name")
            .contains("woni", "jun");
    }

    @Test
    public void shouldHaveSingleWinnerWhenOnlyOneCarHasMaxPosition() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Race race = new Race(carNames);

        race.getCars().get(0).move();
        race.getCars().get(0).move(); // pobi moves twice
        race.getCars().get(1).move(); // woni moves once
        race.getCars().get(2).move();

        List<Car> winners = race.getWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners).extracting("name")
            .contains("pobi");
    }
}
