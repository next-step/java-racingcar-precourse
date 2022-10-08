package racingcar.controller;

import racingcar.controller.message.printer.MessagePrinter;
import racingcar.model.input.parser.ParseResult;
import racingcar.model.racing.car.RacingCarsInGame;
import racingcar.view.Message;
import racingcar.view.simple.line.BlankSimpleLine;
import racingcar.view.simple.line.StartOfRaceSimpleLine;

import java.util.ArrayList;

public class MainController {
    private boolean receivingCarNames;
    private ParseResult<ArrayList<String>> carNamesParseResult;
    private boolean receivingNumberOfCounts;
    private ParseResult<Integer> numberOfRoundParseResult;

    public MainController() {
        this.receivingCarNames = true;
        this.receivingNumberOfCounts = true;
    }

    public void run() {
        CarNamesInputController carNamesInputController = new CarNamesInputController(this::stopReceivingCarNames,
                this::setCarNamesParseResult);
        while (receivingCarNames) {
            carNamesInputController.whileLoop();
        }
        NumberOfRoundInputController numberOfRoundInputController =
                new NumberOfRoundInputController(this::stopReceivingNumberOfCounts, this::setNumberOfRoundParseResult);
        while (receivingNumberOfCounts) {
            numberOfRoundInputController.whileLoop();
        }
        Message blankSimpleLine = new BlankSimpleLine();
        MessagePrinter.print(blankSimpleLine);
        Message startOfRaceSimpleLine = new StartOfRaceSimpleLine();
        MessagePrinter.println(startOfRaceSimpleLine);
        RacingCarGameController racingCarGameController = new RacingCarGameController(carNamesParseResult,
                numberOfRoundParseResult);
        RacingCarsInGame racingCarsInGame = racingCarGameController.run();
        FinalWinnerPrintController finalWinnerPrintController = new FinalWinnerPrintController(racingCarsInGame);
        finalWinnerPrintController.run();
    }

    public void stopReceivingCarNames() {
        receivingCarNames = false;
    }

    public void setCarNamesParseResult(ParseResult<ArrayList<String>> carNamesParseResult) {
        this.carNamesParseResult = carNamesParseResult;
    }

    public void stopReceivingNumberOfCounts() {
        receivingNumberOfCounts = false;
    }

    public void setNumberOfRoundParseResult(ParseResult<Integer> numberOfRoundParseResult) {
        this.numberOfRoundParseResult = numberOfRoundParseResult;
    }
}
