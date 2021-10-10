package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.Cars;
import racinggame.domain.Player;
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
        raceService.inputCarsName(player);
        final Cars cars = createRacingCar(player);
        raceService.inputRaceNumber(player);
        moveAndStop(player, cars);
        findWinner(cars);
    }


    public void moveAndStop(Player player, Cars cars) {
        System.out.println(MessageType.RACING_RESULT.getMessage());
        for (int i = Number.MIN_VALUE.getValue(); i < player.getRaceNumber().getValue(); i++) {
            cars.racing();
            cars.printResult();
            System.out.println();
        }

    }

    public Cars createRacingCar(Player player) {
        final String[] carNameList = raceService.splitNameWithComma(player.getInputCarsName());
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
}
