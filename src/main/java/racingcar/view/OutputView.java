package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static void printCarNamesInputGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberOfTryInputGuide() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultGuide() {
        System.out.println("실행결과");
    }

    public static void printBlank() {
        System.out.println("");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printPlayerMove(Car car) {
        System.out.println(car.getName() + " : " + car.getMove().replaceMoveCount());
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}