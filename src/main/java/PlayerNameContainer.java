import java.util.ArrayList;
import java.util.List;

public class PlayerNameContainer {
    private List<PlayerName> playerNames;

    public PlayerNameContainer(String[] playerNameStrings) {
        this.playerNames = new ArrayList<>();

        for (String playerNameString : playerNameStrings) {
            this.playerNames.add(new PlayerName(playerNameString));
        }
    }

    public List<PlayerName> getNames() {
        return this.playerNames;
    }

    public int size() {
        return this.playerNames.size();
    }
}
