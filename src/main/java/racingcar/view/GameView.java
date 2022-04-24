package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Distance;
import racingcar.domain.RacingReport;

public class GameView {

    public void carNamesEnterMessage() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }


    public void numOfTrialMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void playMessage() {
        System.out.println("실행 결과");
    }

    public void printReport(RacingReport racingReport) {
        Map<Car, Distance> report = racingReport.getReport();
        for (Car car : report.keySet()) {
            System.out.println(car.getName() + " : " + distanceDash(report.get(car)));
        }
        System.out.println();
    }

    private String distanceDash(Distance distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance.getAmount(); i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void printFinal(RacingReport finalReport) {
        List<Car> winners = finalReport.winners();
        System.out.println("최종 우승자: " + joinNames(winners));
    }

    private String joinNames(List<Car> cars) {
        List<String> names = new ArrayList<>();
        cars.forEach(car -> names.add(car.getName()));
        return String.join(", ", names);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
