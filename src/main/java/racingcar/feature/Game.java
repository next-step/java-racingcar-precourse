package racingcar.feature;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static String INPUT_CAR_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static String INPUT_COUNT_MESSAGE = "시도할 회수";

    public void startGame() {
        progress(makeRacing(), makeCount());
    }

    private void progress(Racing cars, GameCount gameCount) {
        System.out.println("실행 결과");
        cars.progressAll(gameCount);
        cars.printWinner();
    }

    private Racing makeRacing() {
        try {
            String input = input(INPUT_CAR_MESSAGE);
            return new Racing(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeRacing();
        }
    }

    private GameCount makeCount() {
        try {
            String input = input(INPUT_COUNT_MESSAGE);
            return new GameCount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeCount();
        }
    }

    private String input(String message) {
        System.out.println(message);
        return readLine();
    }
}
