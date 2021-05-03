package racingcar;

import java.util.List;
import java.util.Scanner;

public class GameApplication {

    public static void main(String[] args) {

        System.out.println(GameMessage.INPUT_RACING_CAR_NAME);
        Scanner scanner = new Scanner(System.in);
        String carsName = scanner.nextLine();
        List<RacingCar> racingCars = RacingCarFactory.create(carsName);
        System.out.println(GameMessage.INPUT_NUMBER_OF_ADVANCES);
        int gameCount = scanner.nextInt();

        Game game = new Game(racingCars, gameCount);
        game.play();
    }
}
