package service;

import model.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameServiceTest {

    private RacingGameService racingGameService;

    @BeforeEach
    public void setUp() {
        racingGameService = new RacingGameService();
    }

//    @Test
//    public void testMoveCar() {
//        ArrayList<RacingCar> racingCars = new ArrayList<>();
//        racingCars.add(new RacingCar("pobi"));
//        racingCars.add(new RacingCar("woni"));
//
//        racingGameService.moveCar(racingCars);
//
//        assertTrue(racingCars.get(0).getPosition() > 0);
//        assertTrue(racingCars.get(1).getPosition() > 0);
//    }

    @Test
    public void testFindWinners() {
        ArrayList<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(new RacingCar("pobi"));
        racingCars.add(new RacingCar("woni"));
        racingCars.add(new RacingCar("jun"));

        racingCars.get(0).setPosition(3);
        racingCars.get(1).setPosition(5);
        racingCars.get(2).setPosition(5);

        String[] winners = racingGameService.findWinners(racingCars);

        assertArrayEquals(new String[]{"woni", "jun"}, winners);
    }

}
