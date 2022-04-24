package racingcar.view;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static final String RACE_RESULT = "실행결과";
    public static final String COLON = " : ";
    public static final String WINNER = "최종 우승자 : ";
    public static final String COMMA = ",";

    /**
     * 에러 출력
     *
     * @param e exception
     */
    public void error(Exception e) {
        System.out.println(e.getMessage());
    }

    /**
     * 결과 출력
     */
    public void resultPrint() {
        System.out.println(RACE_RESULT);
    }

    /**
     * 라운드 결과
     *
     * @param car 자동차
     */
    public void raceRoundResult(Car car) {
        System.out.println(car.getCarName() + COLON + car.dashPosition());
    }

    /**
     * 우승자
     *
     * @param winner 우승 자동차
     */
    public void printWinner(List<Car> winner) {
        System.out.println(WINNER + winnerComma(winner));
    }

    /**
     * 우승자 콤마
     *
     * @param winner 우승차
     * @return 자동차 이름 들
     */
    public String winnerComma(List<Car> winner) {
        List<String> list = new ArrayList<>();
        for (Car car : winner) {
            list.add(car.getCarName());
        }
        return winner.size() > 0 ? String.join(COMMA, list) : "";
    }
}
