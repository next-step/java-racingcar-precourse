package racingcar;

import java.util.List;
import java.util.Scanner;

public class GameApplication {

    public static void main(String[] args) {

        Print.write(GameMessage.INPUT_RACING_CAR_NAME);
        Scanner scanner = new Scanner(System.in);
        String carsName = scanner.nextLine();
        RacingCars racingCars = RacingCarFactory.create(carsName);
        Print.write(GameMessage.INPUT_NUMBER_OF_ADVANCES);
        GameCount gameCount = new GameCount(scanner.nextInt());
        Game game = new Game(racingCars, gameCount);
        game.play();
    }
}
