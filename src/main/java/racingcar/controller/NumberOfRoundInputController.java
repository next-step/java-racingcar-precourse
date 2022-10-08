package racingcar.controller;

import racingcar.controller.input.acceptor.InputAcceptor;
import racingcar.controller.input.acceptor.NumberOfRoundInputAcceptor;
import racingcar.controller.message.printer.MessagePrinter;
import racingcar.controller.user.input.UserInput;
import racingcar.model.input.parser.InputParser;
import racingcar.model.input.parser.ParseResult;
import racingcar.model.input.parser.number.of.round.NumberOfRoundInputParser;
import racingcar.model.input.validator.InputValidator;
import racingcar.model.input.validator.number.of.round.NumberOfRoundInputValidator;
import racingcar.view.Message;
import racingcar.view.error.message.NumberOfRoundErrorMessage;
import racingcar.view.require.message.NumberOfRoundRequireInputMessage;

import java.util.function.Consumer;

public class NumberOfRoundInputController {
    private final Runnable stopReceivingNumberOfCounts;
    private final Consumer<ParseResult<Integer>> setNumberOfRoundParseResult;

    public NumberOfRoundInputController(Runnable stopReceivingNumberOfCounts,
                                        Consumer<ParseResult<Integer>> setNumberOfRoundParseResult) {
        this.stopReceivingNumberOfCounts = stopReceivingNumberOfCounts;
        this.setNumberOfRoundParseResult = setNumberOfRoundParseResult;
    }

    public void whileLoop() {
        Message numberOfRoundRequireInputMessage = new NumberOfRoundRequireInputMessage();
        MessagePrinter.println(numberOfRoundRequireInputMessage);
        InputAcceptor numberOfRoundInputAcceptor = new NumberOfRoundInputAcceptor();
        UserInput numberOfRoundInput = numberOfRoundInputAcceptor.accept();
        InputValidator inputValidator = new NumberOfRoundInputValidator(numberOfRoundInput);
        try {
            inputValidator.validate();
        } catch (IllegalArgumentException e) {
            Message numberOfRoundErrorMessage = new NumberOfRoundErrorMessage();
            MessagePrinter.println(numberOfRoundErrorMessage);
            return;
        }
        InputParser<Integer> numberOfRoundInputParser = new NumberOfRoundInputParser(numberOfRoundInput);
        ParseResult<Integer> numberOfRoundParseResult = numberOfRoundInputParser.parse();
        setNumberOfRoundParseResult.accept(numberOfRoundParseResult);
        stopReceivingNumberOfCounts.run();
    }
}
