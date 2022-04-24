package racingcar.view;

import racingcar.Constant;
import racingcar.domain.Car;
import racingcar.domain.PlayCars;

import java.util.List;

public class ResultView {

    private ResultView() {
    }
    public static void printStartResult(){
        System.out.println(Constant.RACE_PROCESS);
    }
    public static void printCars(PlayCars playCars) {
        System.out.println(playCars.getCarsStatus());
    }

    public static void printWinners(PlayCars playCars) {
        final StringBuilder sb = new StringBuilder();
        sb.append(Constant.FINAL_WINNER);
        List<Car> winners = playCars.isWinners();
        sb.append(winners.get(0).getCarName());
        for (int i = 1; i < winners.size(); i++) {
            sb.append(Constant.COMMA + winners.get(i).getCarName());
        }
        System.out.println(sb);
    }
}
