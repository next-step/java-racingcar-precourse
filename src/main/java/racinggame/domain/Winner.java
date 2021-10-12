package racinggame.domain;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

public class Winner {
    public SortedMap<String, Integer> winner;

    public Winner(Result result) {
        winner = mapWinner(result);

    }

    public SortedMap<String, Integer> mapWinner(Result result) {
        SortedMap<String, Integer> resultMap = new TreeMap<>();
        Collections.sort(result.result);
        int winnerCnt = result.result.get(result.result.size() - 1).getMoveCnt();

        for (int i = 0; i < result.result.size(); i++) {
            if (winnerCnt == result.result.get(i).getMoveCnt()) {
                resultMap.put(result.result.get(i).getCarName(), result.result.get(i).getMoveCnt());
            }
        }
        return resultMap;
    }
}
