package racingcar.model.progress;

import racingcar.model.laps.Laps;
import racingcar.model.laps.LapsManager;

public class Race {
    private final LapsManager lapsManager;
    private final Chairman chairman;

    public Race(Laps laps, Participants participants, Judge judge) {
        this.lapsManager = new LapsManager(laps);
        this.chairman = new Chairman(participants, judge);
    }

    public void go() {
        chairman.progress();
        lapsManager.next();
    }

    public boolean isFinished() {
        return lapsManager.isFinished();
    }

    public RaceScore report() {
        return chairman.report();
    }

    public RaceScore reportWinner() {
        if (!lapsManager.isFinished()) {
            throw new IllegalStateException();
        }
        return chairman.reportLeads();
    }
}
