package racingcar.domain.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRoundResults {

    private List<GameRoundResult> gameRoundResults;

    public GameRoundResults(List<GameRoundResult> gameRoundResults) {
        this.gameRoundResults = gameRoundResults;
    }

    public static GameRoundResults createEmptyGameRoundResults() {
        return new GameRoundResults(new ArrayList<>());
    }

    public void addGameRoundResult(GameRoundResult gameRoundResult) {
        gameRoundResults.add(gameRoundResult);
    }

    public List<GameRoundResult> getGameRoundResults() {
        return Collections.unmodifiableList(gameRoundResults);
    }
}
