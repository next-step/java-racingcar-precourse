package racingcar.domain;

import org.assertj.core.util.Lists;

import java.util.List;

public class Winners {
    private final List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    public void addRacingCar(String winner) {
        winners.add(winner);
    }

    public void printWinners() {
        String builder = "최종 우승자: " +
                String.join(",", winners);
        System.out.println(builder);
    }
}
