package racinggame.dto;

public class GameTurnCntDTO {
    private String gameTurnCntInput;

    public GameTurnCntDTO(String gameTurnCntInput) {
        this.gameTurnCntInput = gameTurnCntInput;
    }

    public String get() {
        return this.gameTurnCntInput;
    }
}
