package racingcar;

import java.util.List;

import static racingcar.RacingMessage.*;

public class RacingContest {
    private final Laps laps;
    private final int lapCount;

    public RacingContest(int lapCount) {
        this.laps = new Laps();
        this.lapCount = lapCount;
    }

    public void start(Cars cars) {
        for (int i = 0; i < lapCount; i++) {
            Lap lap = new Lap(cars);
            lap.start();
            this.laps.addLap(lap);
        }
    }

    public void result() {
        Lap finalLap = laps.getFinalLap();
        List<Car> winners = finalLap.getWinners();
        String printWinner = getResultMessage(winners);
        System.out.println(printWinner);
    }

    private String getResultMessage(List<Car> winners) {
        StringBuilder sb = new StringBuilder(MESSAGE_WINNERS_PRE_FIX);
        for (Car winner : winners) {
            sb.append(winner.getName()).append(MESSAGE_COMMA).append(MESSAGE_SPACE);
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString().trim();
    }

}
