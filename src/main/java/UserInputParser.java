import java.util.Optional;

public class UserInputParser {

    public Optional<CarNameContainer> parseCarNames(String userInput) {
        CarNameContainer carNameContainer = null;

        try {
            carNameContainer = new CarNameContainer(userInput.split(","));
        } catch (IllegalArgumentException e) {
        }

        return Optional.ofNullable(carNameContainer);
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