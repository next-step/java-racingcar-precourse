package app.view;

import app.model.RacingCar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameInterface {
    private Scanner scanner = new Scanner(System.in);

    public String getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public String getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }

    public void printAttemptResult(List<RacingCar> carList) {
        carList.stream().forEach(RacingCar::printCurLocation);
        System.out.println();
    }

    public void printWinner(List<RacingCar> winnerList) {
        System.out.println("최종 우승자 : " + winnerList.stream()
                                            .map(RacingCar::getName)
                                            .collect(Collectors.joining(", ")));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printErrorMessage(String message) {
        System.out.println("[Error] " + message);
    }
}
