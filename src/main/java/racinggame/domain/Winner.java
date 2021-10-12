package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Winner {
    public SortedMap<Integer, String> winner;

    public Winner(Result result) {
        winner = mapWinner(result);

    }

    public SortedMap<Integer, String> mapWinner(Result result) {
        SortedMap<Integer, String> retMap = new TreeMap<>();
        for (int i = 0; i < result.result.size(); i++) {
            retMap.put(result.result.get(i).getMoveCnt(), result.result.get(i).getCarName());
        }

        return filterWinner(retMap);
    }

    private SortedMap<Integer, String> filterWinner(SortedMap retMap) {
        int winnerCnt = Integer.parseInt(retMap.lastKey().toString());
        List<Integer> remove = new ArrayList<>();
        for (Object key : retMap.keySet()) {
            remove = findRemoveElements(remove, winnerCnt, Integer.parseInt(key.toString()));
        }

        for(int i = 0; i < remove.size(); i++) {
            retMap.remove(remove.get(i));
        }
        return retMap;
    }

    private List<Integer> findRemoveElements(List remove, int winnerCnt, int key) {
        if (key != winnerCnt) {
            remove.add(key);
        }
        return remove;
    }
}
