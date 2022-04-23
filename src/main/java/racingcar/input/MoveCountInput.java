package racingcar.input;

import racingcar.domain.MoveCount;
import racingcar.input.validator.InputValidator;
import racingcar.view.output.OutputView;
import racingcar.view.input.MoveCountInputMessageInput;

public class MoveCountInput {
    private final InputValidator inputValidator;
    private final Input input;
    private final int moveCountInteger;

    public MoveCountInput(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        this.input = new Input(new MoveCountInputMessageInput());
        this.moveCountInteger = Integer.parseInt(receiveMoveCountInput());
    }

    private String receiveMoveCountInput() {
        String moveCountInput = "";

        try {
            moveCountInput = input.getMessage();
            inputValidator.validate(moveCountInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return receiveMoveCountInput();
        }

        return moveCountInput;
    }

    public MoveCount getMoveCount() {
        return new MoveCount(moveCountInteger);
    }
}
