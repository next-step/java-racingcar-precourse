import Controller.InputHandler;
import Model.Car;
import Model.Race;
import View.ResultHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        List<String> carNames = inputHandler.getCarNames();
        int trialCount = inputHandler.getTrialCount();

        Race race = new Race(carNames);
        race.start(trialCount);

        List<Car> winners = race.getWinners();
        ResultHandler.printWinners(winners);

    }


}
