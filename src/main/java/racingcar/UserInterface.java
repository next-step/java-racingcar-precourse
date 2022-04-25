package racingcar;

import java.util.List;

public class UserInterface {

    public void printCarNamesPrompt() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printDriveNumberPrompt() {
        System.out.println("시도할 횟수");
    }

    public void printCar(String name, int distance) {
        StringBuilder builder = new StringBuilder();
        builder.append(name + " : ");
        for (int i = 0; i < distance; i++) {
            builder.append("-");
        }
        System.out.println(builder);
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winners));
    }

    public void printExceptionMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
