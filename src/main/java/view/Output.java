package view;

import java.util.HashMap;

public class Output {

    public void printCarNamesProgress() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumberProgress() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printResultProgress() {
        System.out.println("\n실행 결과");
    }

    public void printResult(HashMap<String, String> cars) {
        for (String carName : cars.keySet()) {
            System.out.println(carName + " : " + cars.get(carName));
        }
        System.out.println();
    }

    public void printWinners(String[] winners) {
        System.out.print("\n최종 우승자 : ");
        for (int i = 0; i < winners.length; i++) {
            System.out.print(winners[i]);
            if (i < winners.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public void printException() {
        System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");
    }
}
