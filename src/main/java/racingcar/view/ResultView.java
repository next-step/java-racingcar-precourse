package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;

import java.util.List;

public class ResultView {
    private List<Car> resultList;

    public ResultView(List<Car> resultList) {
        this.resultList = resultList;
    }

    public void printWinner() {
        String winners = Winner.findWinners(this.resultList);
        System.out.println("최종 우승자: " + winners.trim().replaceAll(",$", ""));
    }

    public void printRecordResult() {
        System.out.println("실행결과");

        for (int i = 0; i < this.resultList.size(); i++) {
            if (this.resultList.get(i) == null) {
                System.out.println();
                continue;
            }
            System.out.println(this.resultList.get(i).getName() + " : " + drawRoad(this.resultList.get(i)));
        }
    }

    private String drawRoad(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.maxPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
