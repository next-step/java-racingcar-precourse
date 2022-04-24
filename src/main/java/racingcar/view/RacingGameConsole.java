package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.StringJoiner;

public class RacingGameConsole {

    private static final String CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_ROUND_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String COLON = ":";
    private static final String POSITION_STRING = "-";

    private static final String WINNERS_DELIMITER = ",";
    private static final String WINNERS_PREFIX = "최종 우승자: ";
    private static final String WINNERS_SUFFIX = "";

    public String getCarNames() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public String getGameRound() {
        System.out.println(GAME_ROUND_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printCurrentPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(createCurrentPositionMessage(car));
        }
        System.out.println();
    }

    private String createCurrentPositionMessage(Car car) {
        StringBuffer sb = new StringBuffer(car.getName());
        sb.append(COLON);
        int position = car.getPosition().getValue();
        for (int i = 0; i < position; i++) {
            sb.append(POSITION_STRING);
        }
        return sb.toString();
    }

    public void printWinners(Cars winners) {
        StringJoiner stringJoiner = new StringJoiner(WINNERS_DELIMITER, WINNERS_PREFIX, WINNERS_SUFFIX);
        for (Car car : winners.getCars()) {
            stringJoiner.add(car.getName());
        }
        System.out.println(stringJoiner);
    }
}
