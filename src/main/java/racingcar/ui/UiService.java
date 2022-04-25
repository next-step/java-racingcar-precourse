package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class UiService {

    public static final String NAME_DELIMITER = ",";

    public void printNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printMoveTimesInput() {
        System.out.println("시도할회수");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public void printMoveStart() {
        System.out.println("실행 결과");
    }

    public void printWinners(List<Car> winners) {
        System.out.println("최종 우승자: " + convertNames(winners));
    }

    private String convertNames(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winners) {
            winnerNames.append(winner.printName());
            winnerNames.append(NAME_DELIMITER);
        }
        return winnerNames.substring(0, winnerNames.length() - 1);
    }

    public List<String> readNames() {
        String input = Console.readLine();
        String[] split = input.split(NAME_DELIMITER);
        return Arrays.asList(split);
    }

    public int readMoveTimes() {
        return Integer.parseInt(Console.readLine());
    }

    public void printPosition(List<String> positions) {
        for (String position : positions) {
            System.out.println(position);
        }
        System.out.println();
    }
}
