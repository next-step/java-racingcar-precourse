package racingcar.mvc.domain;

import java.util.*;
import java.util.Map.Entry;

public class ScoreBoard {

    public static ScoreBoard from(String[] playerNames) {
        ScoreBoard scoreBoard = new ScoreBoard();

        for (String name : playerNames) {
            scoreBoard.scoreMap.put(name, 0);
        }

        return scoreBoard;
    }

    private Map<String, Integer> scoreMap;

    public ScoreBoard() {
        this.scoreMap = new HashMap<>();
    }

    public void scoreOne(String playerName) {
        int myScore = this.scoreMap.get(playerName);
        this.scoreMap.replace(playerName, ++myScore);
    }

    public String[] whoAreTopScorer() {
        int max = 0;
        for (Entry<String, Integer> entry: this.scoreMap.entrySet()) {
            max = max < entry.getValue() ? entry.getValue() : max;
        }

        ArrayList<String> playerNames = new ArrayList<String>();
        for (Entry<String, Integer> entry: this.scoreMap.entrySet()) {
            if(entry.getValue() == max) playerNames.add(entry.getKey());
        }

        return playerNames.toArray(new String[playerNames.size()]);
    }

    public Set<String> keyset() {
        return this.scoreMap.keySet();
    }

    public Integer getScore(String playerName) {
        return this.scoreMap.get(playerName);
    }
}
