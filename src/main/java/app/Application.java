package app;

import java.util.List;
import race.PrepareRace;
import race.Race;
import validator.CarNameValidator;
import view.Input;

public class Application {
    public static void main(String[] args) {
        PrepareRace prepareRace = new PrepareRace();
        List<String> carNames = prepareRace.prepareCar();
        int number = prepareRace.prepareNumber();
        Race race = new Race(carNames, number);
    }
}
