package domain.race.service;

import domain.race.model.Car;
import domain.race.model.Race;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RaceServiceTest {
    Race race;

    @BeforeEach
    void setUpRace() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            carList.add(new Car("test" + i));
        }

        race = new Race(carList, 100);
    }

    @AfterEach
    void cleanRace() {
        race = null;
    }

    @Test
    @DisplayName("게임이 끝나면 경주 내부적으로 currRound 는 사용자가 입력한 round 와 같아야 한다.")
    void winnerTest() {
        race.game();

        Assertions.assertThat(race.isFinished()).isTrue();
    }
}