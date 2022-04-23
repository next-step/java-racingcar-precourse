package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public interface RacingGameView {

    String CREATE_CARS_MSG = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    String INSERT_COUNT_MSG = "시도할 횟수는 몇회인가요?";
    String EXECUTE_MSG = "실행 결과";
    String WINNER_MSG_HOLDER = "최종 우승자: %s%n";
    String SPLIT_DELIMITER = ",";

    Cars createCars();

    int insertTryCount();

    void printExecute();

    void printExecuteResult(List<Car> carList);

    void printWinner(List<Car> carList);
}
