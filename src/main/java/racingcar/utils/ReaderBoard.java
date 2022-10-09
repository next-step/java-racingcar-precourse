package racingcar.utils;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ReaderBoard {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_SEPARATOR = ",";
    private static final String DRIVE_SEPARATOR = "-";
    private static final String RESUILT_SEPARATOR = " : ";

    public void round(final Car car) {
        System.out.print(car.getCarName().getName() + RESUILT_SEPARATOR);
        for (int i = 0; i < car.getPosition().getPositionNumber(); i++) {
            System.out.print(DRIVE_SEPARATOR);
        }
        System.out.println();
    }

    public void winners(final List<Car> winners) {
        System.out.print(WINNER_MESSAGE);
        List<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.add(winners.get(i).getCarName().getName());
        }
        System.out.print(String.join(WINNER_SEPARATOR, winnerNames));
    }

    public void newLine() {
        System.out.println();
    }

    public void notice() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }
}
