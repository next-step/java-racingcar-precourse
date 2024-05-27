package domain.race.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class RaceTest {
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
    @DisplayName("첫번째 이용자만 100번의 랜덤 전진을 수행했을때, winner 는 1명이고, 그 한명은 첫번째 이용자여야 한다.")
    void winnerTest() {
        for (int i = 0; i < 100; i++) {
            race.getCarList().get(0).move();
        }
        String movedCarName = race.getCarList().get(0).getName();

        Assertions.assertThat(race.getWinner().size()).isEqualTo(1);
        Assertions.assertThat(movedCarName).isEqualTo(race.getWinner().get(0));
        System.out.println(race.getWinner().get(0));
    }

    @Test
    @DisplayName("모든 이용자가 랜덤 전진을 수행하지 않았을 경우, winner 는 모두가 된다.")
    void printAll() {
        Assertions.assertThat(race.getWinner().size()).isEqualTo(10);
    }
}