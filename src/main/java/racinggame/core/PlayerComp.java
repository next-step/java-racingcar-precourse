package racinggame.core;

import java.util.Comparator;

public class PlayerComp implements Comparator<Player> {
    @Override
    public int compare(Player Player1, Player Player2) {
        return Integer.compare(
            Player1.getPlayerScore().getScore(),
            Player2.getPlayerScore().getScore()
        );
    }
}
