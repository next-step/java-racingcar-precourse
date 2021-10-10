package racinggame.controller;

import racinggame.domain.*;
import racinggame.message.MessageType;
import racinggame.message.Number;
import racinggame.service.RaceService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RacingGameController {

    private final RaceService raceService;

    public RacingGameController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void gameStart() {
        final Player player = new Player();
        final Cars cars = InputNameAndCreateRacingCar(player);
        final RaceNumber raceNumber = InputRaceNumber(player);
        moveAndStop(raceNumber, cars);
        findWinner(cars);
    }

    private RaceNumber InputRaceNumber(Player player) {
        try {
            raceService.inputRaceNumber(player);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return InputRaceNumber(player);
        }
        return player.getRaceNumber();
    }

    private Cars InputNameAndCreateRacingCar(Player player) {
        Cars cars = null;
        try {
            raceService.inputCarsName(player);
            cars = createRacingCar(player.getInputCarsName());
        } catch (NoSuchElementException e) {
            printErrorMessage(e.getMessage());
            InputNameAndCreateRacingCar(player);
        }
        return cars;
    }


    public void moveAndStop(RaceNumber raceNumber, Cars cars) {
        printErrorMessage(MessageType.RACING_RESULT.getMessage());
        for (int i = Number.MIN_VALUE.getValue(); i < raceNumber.getValue(); i++) {
            cars.racing();
            cars.printResult();
            System.out.println();
        }

    }

    public Cars createRacingCar(InputCarsName inputCarsName) {
        final String[] carNameList = raceService.splitNameWithComma(inputCarsName);
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(Car.of(CarName.of(name)));
        }
        return Cars.of(carList);
    }

    public void findWinner(Cars cars) {
        final String winner = raceService.getWinner(cars);
        raceService.printWinner(winner);

    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }

}
