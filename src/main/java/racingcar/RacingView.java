package racingcar;

import java.util.Scanner;

public class RacingView {
    Scanner scanner = new Scanner(System.in);
    private String[] cars;
    private int eventCount;

    public void getRacingInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = scanner.nextLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        eventCount = Integer.parseInt(scanner.nextLine());
    }

    public String[] getCars() {
        return cars;
    }

    public int getEventCount() {
        return eventCount;
    }
}
