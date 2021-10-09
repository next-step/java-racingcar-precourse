package racinggame.core;

import java.util.Comparator;

public class PlayerComp implements Comparator<Player> {

    @Override
    public int compare(Player player1, Player player2) {
        return player1.getScore().compareTo(player2.getScore());
    }

}
