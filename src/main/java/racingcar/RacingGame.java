package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private int attemptCount = 0;

    public RacingGame() {
        boolean isExceptionOccur = true;
        while (isExceptionOccur) {
            isExceptionOccur = inputCarName();
        }
        System.out.println("시도할 회수는 몇회인가요?");
        this.attemptCount = Integer.parseInt(Console.readLine());
    }

    private boolean inputCarName() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            this.cars = new Cars(Console.readLine());
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void start() {
        System.out.println("실행결과");
        List<String> winners = new ArrayList<>();
        while (winners.isEmpty()) {
            this.cars.play();
            winners = this.cars.getWinners(attemptCount);
        }
        printWinners(winners);
    }

    private void printWinners(List<String> winners) {
        System.out.println(String.format("최종 우승자: %s", convertString(winners)));
    }

    private String convertString(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
