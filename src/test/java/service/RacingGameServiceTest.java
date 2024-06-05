package service;

import domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.impl.RacingGameServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingGameServiceTest {

    private RacingGameService racingGameService;

    @BeforeAll
    public void init() {
        racingGameService = new RacingGameServiceImpl();
    }

    @Test
    public void race_whenTrialNumberIsZero_thenCarCanHaveZeroInMoveRound() {
        //given
        Car testCar1 = Car.from("testCar1");
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(testCar1);

        //when
        racingGameService.race(carList, 0);

        //then
        if (carList.get(0).getMoveRound().size() == 1) {
            assertThat(carList.get(0).getMoveRound().get(0)).isEqualTo(Integer.valueOf(0));
        }
    }

    @Test
    public void decideWinner_whenAllCarHasSameMoveCount_thenReturnAllCar() {
        //given
        Car testCar1 = Car.from("testCar1");
        Car testCar2 = Car.from("testCar2");
        Car testCar3 = Car.from("testCar3");

        ArrayList<Car> player = new ArrayList<>();
        player.add(testCar1);
        player.add(testCar2);
        player.add(testCar3);

        //when
        List<Car> winner = racingGameService.decideWinner(player);

        //then
        assertThat(winner.size()).isEqualTo(3);
    }

    @Test
    public void decideWinner_whenOneCarHasMaxMoveCount_thenReturnOneCar() {
        //given
        Car testCar1 = Car.from("testCar1");
        Car testCar2 = Car.from("testCar2");
        Car testCar3 = Car.from("testCar3");

        testCar1.move(0);

        ArrayList<Car> player = new ArrayList<>();
        player.add(testCar1);
        player.add(testCar2);
        player.add(testCar3);

        //when
        List<Car> winner = racingGameService.decideWinner(player);

        //then
        assertThat(winner.size()).isEqualTo(1);
    }
}
