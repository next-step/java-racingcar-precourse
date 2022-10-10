package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.StringJoiner;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.StringUtils;

public class ConsoleGameView implements GameView {

    private static final String ERROR_TAG = "[ERROR]";
    private static final String DRIVE_TOKEN = "-";
    private static final String WINNER_DELIMITER = ", ";

    @Override
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String inputTurn() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Console.readLine();
    }

    @Override
    public void responseError(IllegalArgumentException iae) {
        System.out.println(ERROR_TAG + iae.getMessage());
    }

    @Override
    public void showGameProgress(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf("%s : %s\n", car.getCarName(), StringUtils.repeat(DRIVE_TOKEN, car.getPosition()));
        }
        System.out.println();
    }

    @Override
    public void notifyStartGame() {
        System.out.println("실행 결과");
    }

    @Override
    public void responseWinner(List<Car> cars) {
        StringJoiner sj = new StringJoiner(WINNER_DELIMITER);
        for (Car car : cars) {
            sj.add(car.getCarName());
        }
        System.out.printf("최종 우승자 : %s", sj);
    }
}
