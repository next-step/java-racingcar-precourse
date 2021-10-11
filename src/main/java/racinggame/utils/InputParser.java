package racinggame.utils;

public class InputParser {
    private InputValidator inputValidator;

    public InputParser(){
        this.inputValidator = new InputValidator();
    }

    public String[] splitPlayerNames(String playerNamesInput) {
        try {
            String[] playerNames = playerNamesInput.split(",", 0);

            this.inputValidator.validatePlayerNames(playerNames);

            return playerNames;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
