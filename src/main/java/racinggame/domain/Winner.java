package racinggame.domain;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Winner {
    public SortedMap<String, Integer> winner;
    private int winnerCnt;

    public Winner(RacingResult racingResult) {
        this.winnerCnt = findWinnerCnt(racingResult);
        winner = mapWinner(racingResult);
    }

    public SortedMap<String, Integer> mapWinner(RacingResult racingResult) {
        SortedMap<String, Integer> resultMap = new TreeMap<>();
        for (int i = 0; i < racingResult.result.size(); i++) {
            if (this.winnerCnt == racingResult.result.get(i).getMoveCnt()) {
                resultMap.put(racingResult.result.get(i).getCarName(), racingResult.result.get(i).getMoveCnt());
            }
        }
        return resultMap;
    }

    public int findWinnerCnt (RacingResult racingResult) {
        Collections.sort(racingResult.result);
        return racingResult.result.get(racingResult.result.size() - 1).getMoveCnt();
    }
}
