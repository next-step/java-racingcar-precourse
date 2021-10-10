package racinggame.controller;

import racinggame.domain.*;
import racinggame.message.MessageType;
import racinggame.message.Number;
import racinggame.service.RaceService;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    private final RaceService raceService;

    public RacingGameController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void gameStart() {
        final Player player = new Player();
        final Cars cars = InputNameAndCreateRacingCar(player);
        final RaceNumber raceNumber = InputRaceNumber(player);
        Racing(raceNumber, cars);
        findWinner(cars);
    }

    private RaceNumber InputRaceNumber(Player player) {
        try {
            return raceService.inputRaceNumber(player);
        } catch (IllegalStateException e) {
            printErrorMessage(e.getMessage());
            return InputRaceNumber(player);
        }
    }

    private Cars InputNameAndCreateRacingCar(Player player) {
        try {
            raceService.inputCarsName(player);
            return createRacingCar(player.getInputCarsName());
        } catch (IllegalStateException e) {
            printErrorMessage(e.getMessage());
            return InputNameAndCreateRacingCar(player);
        }
    }


    public void Racing(RaceNumber raceNumber, Cars cars) {
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
