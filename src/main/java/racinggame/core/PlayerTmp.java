package racinggame.core;

import java.util.ArrayList;
import java.util.List;

public class PlayerTmp {

    private final PlayerName playerName;
    private final PlayerScore playerScore;

    public PlayerTmp(final String name) {
        this.playerName = new PlayerName(name);
        this.playerScore = new PlayerScore();
    }

    public static List<PlayerTmp> getPlayerTmpsByPlayerNames(List<PlayerName> playerNames) {
        List<PlayerTmp> playerTmps = new ArrayList<>();
        for (PlayerName playerName : playerNames) {
            playerTmps.add(new PlayerTmp(playerName.getName()));
        }
        return playerTmps;
    }

    public PlayerName getPlayerName() {
        return this.playerName;
    }

    public PlayerScore getPlayerScore() {
        return this.playerScore;
    }

    public void printResult() {
        System.out.println(this.playerName.getName() + " : " + getScoreString());
    }

    private String getScoreString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.playerScore.getScore(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
