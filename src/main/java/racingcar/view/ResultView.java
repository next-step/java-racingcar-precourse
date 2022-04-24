package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.PlayCars;

import java.util.List;

public class ResultView {

    private ResultView() {
    }
    public static void printStartResult(){
        System.out.println("실행 결과");
    }
    public static void printCars(PlayCars playCars) {
        System.out.println(playCars.getCarsStatus());
    }

    public static void printWinners(PlayCars playCars) {
        final StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자: ");
        List<Car> winners = playCars.isWinners();
        sb.append(winners.get(0).getCarName());
        for (int i = 1; i < winners.size(); i++) {
            sb.append(", " + winners.get(i).getCarName());
        }
        System.out.println(sb);
    }
}
