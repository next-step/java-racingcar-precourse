import java.util.Optional;

public class UserInputParser {

    public Optional<PlayerNameContainer> parsePlayerNames(String userInput) {
        PlayerNameContainer playerNames = null;

        try {
            playerNames = new PlayerNameContainer(userInput.split(","));
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