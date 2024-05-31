import Controller.*;
import Model.*;
import View.*;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        RacingViews views = new RacingViews();
        InputProcessing inputProcessing = new InputProcessing(views, new FindErrors());
        MovingCars movingCars = new MovingCars(views, new Random());
        WinnerCalculator winnerCalculator = new WinnerCalculator();
        String carNames = inputProcessing.getValidCarNames();
        String[] carNamesArray = carNames.split(",");
        RacingCarsVO[] cars = new RacingCarsVO[carNamesArray.length];
        for (int i = 0; i < carNamesArray.length; i++) {
            cars[i] = new RacingCarsVO(carNamesArray[i]);
        }
        int attempts = inputProcessing.getValidAttempts();
        movingCars.movingCar(cars, attempts);
        List<String> winners = winnerCalculator.calculateWinners(cars);
        views.displayWinners(String.join(", ", winners));
    }

}
