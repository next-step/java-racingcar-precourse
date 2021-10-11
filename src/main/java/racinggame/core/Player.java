package racinggame.core;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final PlayerName playerName;
    private final PlayerScore playerScore;

    public Player(final String name) {
        this.playerName = new PlayerName(name);
        this.playerScore = new PlayerScore();
    }

    public static List<Player> getPlayersByPlayerNames(List<PlayerName> playerNames) {
        List<Player> Players = new ArrayList<>();
        for (PlayerName playerName : playerNames) {
            Players.add(new Player(playerName.getName()));
        }
        return Players;
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
