package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Cars;

public class Game {

    public static final int ZERO = 0;

    private Cars cars;
    private PlayResult playResult = new PlayResult();
    private MovePoint movePoint;

    public Game() {
        inputCarNamesFromUser();
        inputMovePointFromUser();
    }

    public void start() {
        System.out.println("실행 결과");
        for(int move = ZERO; move < movePoint.getMovePoint(); move++) {
            cars.play(playResult);
            playResult.printPlayResult();
        }
        playResult.printWinners();
    }

    private void inputCarNamesFromUser() {
        try {
            System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
            String strCarNames = Console.readLine();
            cars = new Cars(strCarNames);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            inputCarNamesFromUser();
        }
    }

    private void inputMovePointFromUser() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String point = Console.readLine();
            movePoint = new MovePoint(point);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            inputMovePointFromUser();
        }
    }
}
