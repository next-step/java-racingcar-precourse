package app;

import java.util.ArrayList;
import java.util.List;
import race.PrepareRace;
import race.Race;
import validator.CarNameValidator;
import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {
        PrepareRace prepareRace = new PrepareRace();
        List<String> carNames = prepareRace.prepareCar();
        int number = prepareRace.prepareNumber();
        Race race = new Race(carNames, number);
        race.run();
        List<String> winnerNames = race.getWinners();
        Output.printWinners(winnerNames);
    }
}
