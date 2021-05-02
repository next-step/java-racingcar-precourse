import java.util.Optional;

public class RacingCarGame {
    private UserInputParser userInputParser;

    public RacingCarGame() {
        this.userInputParser = new UserInputParser();
    }

    public PlayResult play(String carNamesInput, String moveCountInput) {
        Optional<CarNameContainer> mayCarNameContainer = this.userInputParser.parseCarNames(carNamesInput);
        Optional<MovementCount> mayMoveCount = this.userInputParser.parseMoveCount(moveCountInput);

        if (!mayCarNameContainer.isPresent() || !mayMoveCount.isPresent()) {
            return PlayResult.INVALID_INPUT;
        }

        return PlayResult.PLAYED;
    }
}
