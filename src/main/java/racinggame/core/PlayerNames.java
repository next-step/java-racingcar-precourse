package racinggame.core;

import java.util.ArrayList;
import java.util.List;

public class PlayerNames {

    private final List<PlayerName> playerNames;

    public PlayerNames(final String names) {
        this.playerNames = getPlayerNamesByString(names);
    }

    public List<PlayerName> getPlayerNames() {
        return this.playerNames;
    }

    private List<PlayerName> getPlayerNamesByString(final String names) {
        List<PlayerName> playerNames = new ArrayList<>();
        for (String name : getNameArray(names)) {
            playerNames.add(new PlayerName(name));
        }
        return playerNames;
    }

    private String[] getNameArray(final String names) {
        return names.replaceAll(" ", "").split(",");
    }

}
