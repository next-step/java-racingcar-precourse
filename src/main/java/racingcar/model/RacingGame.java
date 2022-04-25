package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.primitive.GameCount;
import racingcar.model.primitive.Name;
import racingcar.strategy.MovementStrategy;

public class RacingGame {
    public static final String NEW_LINE = "\n" ;
    public static final String WINNER_DELIMITER = "," ;
    public static final int LAST_INDEX = 1;
    private final Players players;
    private final GameCount gameCount;
    private final MovementStrategy movementStrategy;
    private final List<String> scoreBoards;

    public RacingGame(Players players, GameCount gameCount, MovementStrategy movementStrategy) {
        this.players = players;
        this.gameCount = gameCount;
        this.movementStrategy = movementStrategy;
        this.scoreBoards = new ArrayList<>();
    }

    public void playGames() {
        for (int loop = 0; loop < gameCount.getValue(); loop++) {
            playGame();
        }
    }

    private void playGame() {
        players.moveWithStrategy(movementStrategy);
        scoreBoards.add(players.currentScores());
    }

    public String totalScoreBoards() {
        StringBuilder sb = new StringBuilder();
        for (int loop = 0; loop < gameCount.getValue(); loop++) {
            sb.append(showScoreBoard(loop)).append(NEW_LINE);
        }
        return sb.toString();
    }

    private String showScoreBoard(int round) {
        return ScoreBoard.scoreBoardWithTemplate(scoreBoards.get(round));
    }

    public String winnerList() {
        StringBuilder sb = new StringBuilder();
        for (Name name : players.firstPlayerNames()) {
            sb.append(name.getName()).append(WINNER_DELIMITER);
        }
        deleteLastDelimiter(sb);
        return sb.toString();
    }

    private void deleteLastDelimiter(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - LAST_INDEX);
    }
}
