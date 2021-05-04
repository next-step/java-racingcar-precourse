import java.util.Optional;

public class UserInputParser {
    private static final String INPUT_PLAYER_NAME_SEPERATOR = ",";

    public Optional<PlayerNameContainer> parsePlayerNames(String userInput) {
        PlayerNameContainer playerNames = null;

        try {
            playerNames = new PlayerNameContainer(userInput.split(INPUT_PLAYER_NAME_SEPERATOR));
        } catch (IllegalArgumentException e) {
        }

        return Optional.ofNullable(playerNames);
    }

    public Optional<TrialCount> parseTrialCount(String trialCntInput) {
        TrialCount trialCount = null;

        try {
            trialCount = new TrialCount(trialCntInput);
        } catch (NumberFormatException e) {
        }

        return Optional.ofNullable(trialCount);
    }
}