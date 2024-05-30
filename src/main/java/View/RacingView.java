package View;

import Model.Car;

import java.util.List;

public class RacingView {
    private RacingView() {}

    public static void printCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRacingRoundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRacingRoundResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printOneRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPositon()));
            System.out.println();
        }
    }

    public static void printWinners(List<String> winnerNames) {
        String result = "최종 우승자 : ";
        System.out.println(result + String.join(", ", winnerNames));
    }
}
