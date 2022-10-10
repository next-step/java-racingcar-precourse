package racingcar.model;

import java.util.ArrayList;

public class PlayerGroup {
    private final ArrayList<Player> playerGroup;

    public PlayerGroup() {
        playerGroup = new ArrayList<>();
    }

    public void append(Player player) {
        playerGroup.add(player);
    }

    public void reset() {
        playerGroup.clear();
    }

    public void runARace() {
        for (Player player : playerGroup) {
            player.drive();
        }
    }

    public ArrayList<Player> getPlayerGroup() {
        return playerGroup;
    }

    public String toStringCarDistanceByPlayer() {
        StringBuilder scoreboard = new StringBuilder();
        String newLine = "\n";
        for (Player player: playerGroup) {
            scoreboard.append(player.getCar().toStringCarDistance()).append(newLine);
        }

        return scoreboard.toString();
    }

}