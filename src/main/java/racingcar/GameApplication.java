package racingcar;

import java.util.List;
import java.util.Scanner;

public class GameApplication {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String carsName = scanner.nextLine();
        List<RacingCar> racingCars = RacingCarFactory.create(carsName);
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCount = scanner.nextInt();

        Game game = new Game(racingCars, gameCount);
        game.play();
    }
}
