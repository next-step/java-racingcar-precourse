package racingcar.domain;

import racingcar.domain.wrapper.Racer;
import racingcar.domain.wrapper.Racers;
import racingcar.domain.wrapper.RoundCount;
import racingcar.domain.wrapper.Winners;
import racingcar.util.RandomUtil;
import racingcar.view.OutputView;

public class Racing {
    private final Racers racers;
    private final RoundCount roundCount;

    public Racing(final Racers racers, final RoundCount roundCount) {
        this.racers = racers;
        this.roundCount = roundCount;
    }

    public void start() {
        for (int i = 0; i < roundCount.getCount(); i++) {
            runEachRound();
        }
        OutputView.printResult(result());
    }

    private void runEachRound() {
        for (Racer racer : racers.getRacers()) {
            racer.move(RandomUtil.random());
        }
        OutputView.printLine();
    }

    private String result() {
        final int maxInstance = racers.getMaxInstance();
        Winners winners = new Winners();

        for (Racer racer : racers.getRacers()) {
            winners.add(racer.getWinnerName(maxInstance));
        }
        return winners.getWinners();
    }
}
