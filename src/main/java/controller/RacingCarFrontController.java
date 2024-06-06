package controller;

import controller.RacingCarRequest.CreateCarRequest;
import java.util.Scanner;

public class RacingCarFrontController {

    private final RacingCarController racingCarController;

    public RacingCarFrontController(RacingCarController racingCarController) {
        this.racingCarController = racingCarController;
    }

    private boolean CreateRacingCars(Scanner scanner) {
        System.out.println("자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        try {
            String input = scanner.nextLine();
            racingCarController.createRacingCar(new CreateCarRequest(input));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            CreateRacingCars(scanner);
            return false;
        }
    }

    private boolean ChooseRacingCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int input = scanner.nextInt();
            racingCarController.startRacing(new RacingCarRequest.RacingRoundRequest(input));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            ChooseRacingCount(scanner);
            return false;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (!CreateRacingCars(scanner)) {
        }
        while (!ChooseRacingCount(scanner)) {
        }
        scanner.close();
    }
}
