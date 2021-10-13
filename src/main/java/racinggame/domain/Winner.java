package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    public List<String> winner;
    private int winnerCnt;

    public Winner(RacingResult racingResult) {
        this.winnerCnt = findWinnerCnt(racingResult);
        winner = findWinner(racingResult);
    }

    public List<String> findWinner(RacingResult racingResult) {
        List<String> resultMap = new ArrayList<>();
        for (int i = 0; i < racingResult.result.size(); i++) {
            if (this.winnerCnt == racingResult.result.get(i).getMoveCnt()) {
                resultMap.add(racingResult.result.get(i).getCarName());
            }
        }
        return resultMap;
    }

    public int findWinnerCnt (RacingResult racingResult) {
        Collections.sort(racingResult.result);
        return racingResult.result.get(racingResult.result.size() - 1).getMoveCnt();
    }
}
