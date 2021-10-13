package racinggame.dto;

public class PlayerNamesDTO {
    private String playerNames;

    public PlayerNamesDTO(String playerNames) {
        this.playerNames = playerNames;
    }

    public String get() {
        return this.playerNames;
    }
}
