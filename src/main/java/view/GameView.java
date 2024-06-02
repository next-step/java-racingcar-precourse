package view;

import java.util.List;
import java.util.Scanner;
import model.RacingCar;

public class GameView {

    public String inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        return scanner.nextLine();
    }

    public void outputException(IllegalArgumentException e) {
        System.out.println("[Error]" + e.getMessage());
    }

    public int inputRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void displayCurrentRound(List<RacingCar> racingCars) {
        System.out.println("실행 결과");
        for (RacingCar racingCar : racingCars) {
            System.out.printf("%s : ", racingCar.getCarName());
            System.out.println("-".repeat(racingCar.getPosition()));
        }
    }
}
