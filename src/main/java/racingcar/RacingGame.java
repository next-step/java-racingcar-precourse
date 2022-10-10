package racingcar;

import java.util.List;

public class RacingGame {

    public static void playGame(){
        List<String> carNames = ValidationUtils.getCarNames();
        int gameCount = ValidationUtils.getGameCount();
        List<RacingCar> racingCars = RacingCars.makeNamedCars(carNames);
        RacingCars cars = new RacingCars(racingCars);
        cars.playGames(gameCount);
        List<String> winners = cars.calculateWinner();
        cars.displayWinner(winners);


    }
}
