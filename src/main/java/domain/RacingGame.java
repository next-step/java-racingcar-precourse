package domain;

import static domain.ExceptionMessage.INVALID_NAME_LENGTH;
import static domain.GameMessage.ASK_CAR_NAME;
import static domain.GameMessage.ASK_GAME_COUNT;

import java.util.ArrayList;
import java.util.Arrays;
import util.IOHandler;

public class RacingGame {

    static final IOHandler ioHandler = new IOHandler();
    static final ArrayList<RacingCar> cars = new ArrayList<>();

    public void start() {
        ioHandler.println(ASK_CAR_NAME.getMessage());

        generateCar();

        askTrialCount();
    }

    private void generateCar() {
        String carNames = askCarNames();

        ArrayList<String> validatedCarNames = validateCarNames(carNames);
        createCars(validatedCarNames);
    }

    private String askCarNames() {
        return ioHandler.getStringInput();
    }

    private ArrayList<String> validateCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (String name : carNameArray) {
            if (name.length() > RacingCar.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
            }
        }


        return new ArrayList<>(Arrays.asList(carNameArray));
    }


    private void createCars(ArrayList<String> validCarNames) {
        for (String name : validCarNames) {
            cars.add(new RacingCar(name));
        }
    }

    public void askTrialCount() {
        ioHandler.print(ASK_GAME_COUNT.getMessage());
    }

}
