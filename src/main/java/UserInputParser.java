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

    public Optional<MovementCount> parseMoveCount(String moveCntInput) {
        MovementCount movementCount = null;

        try {
            movementCount = new MovementCount(moveCntInput);
        } catch (NumberFormatException e) {
        }

        return Optional.ofNullable(movementCount);
    }
}