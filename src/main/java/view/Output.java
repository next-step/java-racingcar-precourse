package view;

import java.util.Map;

public class Output {

    public static void printCarNamesProgress() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberProgress() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printResultProgress() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(Map<String, String> cars) {
        for (String carName : cars.keySet()) {
            System.out.println(carName + " : " + cars.get(carName));
        }
        System.out.println();
    }

    public static void printWinners(String[] winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.length; i++) {
            System.out.print(winners[i]);
            if (i < winners.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void printException() {
        System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
    }
}
