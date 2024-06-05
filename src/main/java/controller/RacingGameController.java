package controller;

import domain.Car;
import dto.RacingRequest;
import dto.RacingResponse;
import service.RacingGameService;
import service.impl.RacingGameServiceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameController {

    private RacingGameService racingGameService;

    private void init() {
        racingGameService = new RacingGameServiceImpl();
    }

    public RacingResponse playGame(RacingRequest request) {

        init();
        List<Car> player = Arrays.stream(request.getCarNameStringArray()).map(Car::from).toList();

        racingGameService.race(player, request.getTrialNumber());
        List<Car> winnerCar = racingGameService.decideWinner(player);

        Map<String, List<Integer>> raceResult = new HashMap<>();
        player.stream().forEach(car ->  raceResult.put(car.getName(), car.getMoveRound()));

        List<String> winnerName = winnerCar.stream().map(Car::getName).toList();

        return RacingResponse.of(raceResult, winnerName);
    }
}
