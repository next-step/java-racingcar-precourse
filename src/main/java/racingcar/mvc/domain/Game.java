package racingcar.mvc.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private String playerNames[];
    private ScoreBoard scoreBoard;
    private int numberOfRound;
    private int currentRound;

    public Game(String[] playerNames, int numberOfRound) {
        this.playerNames = playerNames;
        this.scoreBoard = ScoreBoard.from(playerNames);
        this.numberOfRound = numberOfRound;
        this.currentRound = 0;
    }

    public void runOneRound() {
        for (int j = 0; j < this.playerNames.length; j++) {
            String name = this.playerNames[j];
            int temp = Randoms.pickNumberInRange(0, 9);
            if (4 <= temp) this.scoreBoard.scoreOne(name);
        }

        this.currentRound++;
    }

    public ScoreBoard getScoreBoard() {
        return this.scoreBoard;
    }

    public boolean hasNextRound() {
        if (currentRound < this.numberOfRound) return true;
        else return false;
    }

    public String[] getWinnerNames() {
        return scoreBoard.whoAreTopScorer();
    }
}
