package racingcar.controller;

import racingcar.controller.input.acceptor.CarNamesInputAcceptor;
import racingcar.controller.input.acceptor.InputAcceptor;
import racingcar.controller.message.printer.MessagePrinter;
import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.CarNamesInputDelimiter;
import racingcar.model.delimiter.Delimiter;
import racingcar.model.input.parser.InputParser;
import racingcar.model.input.parser.ParseResult;
import racingcar.model.input.parser.car.names.CarNamesInputParser;
import racingcar.model.input.validator.InputValidator;
import racingcar.model.input.validator.car.names.CarNamesInputValidator;
import racingcar.view.Message;
import racingcar.view.error.message.CarNamesErrorMessage;
import racingcar.view.require.message.CarNamesRequireInputMessage;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CarNamesInputController {
    private final Runnable stopReceivingCarNames;
    private final Consumer<ParseResult<ArrayList<String>>> setCarNamesParseResult;

    public CarNamesInputController(Runnable stopReceivingCarNames,
                                   Consumer<ParseResult<ArrayList<String>>> setCarNamesParseResult) {
        this.stopReceivingCarNames = stopReceivingCarNames;
        this.setCarNamesParseResult = setCarNamesParseResult;
    }

    public void whileLoop() {
        Message carNamesRequireInputMessage = new CarNamesRequireInputMessage();
        MessagePrinter.println(carNamesRequireInputMessage);
        InputAcceptor carNamesInputAcceptor = new CarNamesInputAcceptor();
        UserInput carNamesInput = carNamesInputAcceptor.accept();
        Delimiter carNamesInputDelimiter = new CarNamesInputDelimiter(",");
        InputValidator inputValidator = new CarNamesInputValidator(carNamesInput, carNamesInputDelimiter);
        try {
            inputValidator.validate();
        } catch (IllegalArgumentException e) {
            Message carNamesErrorMessage = new CarNamesErrorMessage();
            MessagePrinter.println(carNamesErrorMessage);
            return;
        }
        InputParser<ArrayList<String>> carNamesInputParser = new CarNamesInputParser(carNamesInput,
                carNamesInputDelimiter);
        ParseResult<ArrayList<String>> carNamesParseResult = carNamesInputParser.parse();
        setCarNamesParseResult.accept(carNamesParseResult);
        stopReceivingCarNames.run();
    }
}
