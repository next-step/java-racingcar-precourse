package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.car.CarPosition;
import racingcar.model.car.Cars;
import racingcar.model.race.Race;
import racingcar.model.race.RaceManager;
import racingcar.model.race.Trial;
import racingcar.model.race.Winners;
import racingcar.model.strategy.RandomNumberMoveStrategy;
import racingcar.model.value.ErrorMsg;

public class RaceControllerTest {

    private RandomNumberMoveStrategy strategy;
    private RaceManager manager;
    private Race race;
    private Cars cars;
    private Trial trial;

    @BeforeEach
    void setup() {
        strategy = new RandomNumberMoveStrategy();
        manager = new RaceManager();
        cars = manager.addCars("테슬라,마이바흐");
        trial = manager.addTrial("2");
        race = new Race(strategy);
    }

    @Test
    void 레이스_상태변화_테스트() {
        assertFalse(race.isRaceReady());
        race.setupCars(cars);
        race.setupTrial(trial);
        assertTrue(race.isRaceReady());
        race.start();
        assertTrue(race.isRaceOver());
    }


    @Test
    void 공동우승_통합_테스트() {
        strategy.setMoveLimit(0);
        race.setupCars(cars);
        race.setupTrial(trial);
        race.start();
        assertEquals(race.getRaceRecord().getRecordSize(), 2);
        assertThat(cars.getCarList().get(0).getCarPosition().equals(new CarPosition(2)));
        assertThat(cars.getCarList().get(1).getCarPosition().equals(new CarPosition(2)));
        Winners winners = race.getRaceRecord().getFinalResult().getWinners();
        assertEquals(winners.getWinnerCount(), 2);
    }

    @Test
    void 공동패배_통합_테스트() {
        strategy.setMoveLimit(10);
        race.setupCars(cars);
        race.setupTrial(trial);
        race.start();
        assertEquals(race.getRaceRecord().getRecordSize(), 2);
        assertThat(cars.getCarList().get(0).getCarPosition().equals(new CarPosition(0)));
        assertThat(cars.getCarList().get(1).getCarPosition().equals(new CarPosition(0)));
        Winners winners = race.getRaceRecord().getFinalResult().getWinners();
        assertEquals(winners.getWinnerCount(), 2);
    }

    @Test
    void 준비안된_경우_레이스_스타트_실패() {
        assertFalse(race.isRaceReady());

        assertThatThrownBy(() -> {
            race.start();
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMsg.CANNOT_START_RACE_NO_READY);
    }

    @Test
    void 경기가_시작하지_않은_경우_우승자_발표_실패() {
        race.setupCars(cars);
        assertThatThrownBy(() -> {
            race.announceFinalWinner();
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage(ErrorMsg.CANNOT_ANNOUNCE_FINAL_WINNER);
    }

}
