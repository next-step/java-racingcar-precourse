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
        RacingCarsVO[] cars = inputProcessing.initializeCars();
        int attempts = inputProcessing.getValidAttempts();
        movingCars.movingCar(cars, attempts);
        views.displayWinners(winnerCalculator,cars);
    }

}
