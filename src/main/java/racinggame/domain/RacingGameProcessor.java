package racinggame.domain;

import nextstep.utils.Console;
import nextstep.utils.io.Input;
import nextstep.utils.io.Output;
import racinggame.error.ValidationFailureException;
import racinggame.type.Messages;

import java.util.Optional;

public class RacingGameProcessor {

    Input input;
    Output output;

    public RacingGameProcessor(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        carNamingProcess();
    }

    private void carNamingProcess() {
        RacingGame racingGame = readCarNamesUntilWithoutThrow();
        TryTimes tryTimes = readTryTimesUntilWithoutThrow();
        displayResult(racingGame.startNTimes(tryTimes));
    }

    private RacingGame readCarNamesUntilWithoutThrow() {
        Optional<RacingGame> optionalRacingGame = optionalRacingGameFromInput();
        while (!optionalRacingGame.isPresent()) {
            optionalRacingGame = optionalRacingGameFromInput();
        }
        return optionalRacingGame.get();
    }

    private TryTimes readTryTimesUntilWithoutThrow() {
        Optional<TryTimes> optionalTryTimes = readTryTimes();
        while (!optionalTryTimes.isPresent()) {
            optionalTryTimes = readTryTimes();
        }
        return optionalTryTimes.get();
    }

    private void displayResult(RacingResult result) {
        output.writeLine(result.toString());
    }

    private Optional<TryTimes> readTryTimes() {
        try {
            displayTryTimesRequireMessage();
            return Optional.of(new TryTimes(readInputAndToInt()));
        } catch (ValidationFailureException vfe) {
            output.writeLine(vfe.getMessage());
            return Optional.empty();
        }
    }

    private Optional<RacingGame> optionalRacingGameFromInput() {
        try {
            displayNameRequireMessage();
            return Optional.of(RacingGame.from(Console.readLine()));
        } catch (ValidationFailureException vfe) {
            output.writeLine(vfe.getMessage());
            return Optional.empty();
        }
    }

    private void displayNameRequireMessage() {
        output.writeLine(Messages.INFO_REQUIRE_CAR_NAMES.getMessage());
    }

    private void displayTryTimesRequireMessage() {
        output.writeLine(Messages.INFO_REQUIRE_TRY_TIMES.getMessage());
    }

    private int readInputAndToInt() {
        try {
            return Integer.parseInt(input.read());
        } catch (NumberFormatException ignored) {
            throw new ValidationFailureException(Messages.ERROR_STRING_CANNOT_CONVERT_TO_INT.getMessage());
        }
    }
}
