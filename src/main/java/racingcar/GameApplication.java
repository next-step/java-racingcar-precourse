package racingcar;

import java.util.Scanner;

public class GameApplication {

    private static final Scanner SCANNER;
    private static String carsName;
    private static GameCount gameCount;

    static {
        SCANNER = new Scanner(System.in);
    }

    public static void main(String[] args) {
        inputRacingCarName();
        inputNumberOfAdvances();
        playGame();
    }

    private static void inputRacingCarName() {
        Print.write(GameMessage.INPUT_RACING_CAR_NAME);
        carsName = SCANNER.nextLine();
    }

    private static void inputNumberOfAdvances() {
        Print.write(GameMessage.INPUT_NUMBER_OF_ADVANCES);
        gameCount = new GameCount(SCANNER.nextInt());
    }

    private static void playGame() {
        RacingCars racingCars = RacingCarFactory.create(carsName);
        new Game(racingCars, gameCount).play();
    }
}
