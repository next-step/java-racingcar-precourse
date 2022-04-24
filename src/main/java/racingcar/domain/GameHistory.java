package racingcar.domain;

import racingcar.util.ExceptionMessageUtil;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    public static final String NOT_EXCEPT_HISTORY_EXCEPTION_MESSAGE = "history가 존재하지 않습니다.";
    private final List<Cars> history = new ArrayList<>();
    private Names winnerNames;

    public void save(Cars tempHistory) {
        history.add(tempHistory);
    }

    private Cars getTimeHistory(Integer time) {
        Cars log = history.get(time);
        if (log == null) {
            throw new IllegalArgumentException(ExceptionMessageUtil.errorMessage(NOT_EXCEPT_HISTORY_EXCEPTION_MESSAGE));
        }
        return log;
    }


    public void makeWinner(Integer lastTime) {
        Cars lastHistory = getTimeHistory(lastTime);

        this.winnerNames = lastHistory.winnerNames();
    }

    public List<Cars> getHistory() {
        return history;
    }

    public Names getWinnerNames() {
        return winnerNames;
    }

}