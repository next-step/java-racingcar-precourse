package view;

import java.util.Map;

public class Output {

    public static void printCarNamesProgress() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberProgress() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printResult(Map<String, String> cars) {
        System.out.println("실행 결과");
        for (String carName : cars.keySet()) {
            System.out.println(carName + " : " + cars.get(carName));
        }
        System.out.println();
    }
}
