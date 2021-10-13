package racinggame.vo;

import java.util.ArrayList;

public class PlayerNames extends ArrayList<PlayerName> {
    public PlayerNames(String[] strPlayerNames) {
        for (int i = 0; i < strPlayerNames.length; i++) {
            this.add(new PlayerName(strPlayerNames[i]));
        }
    }
}
