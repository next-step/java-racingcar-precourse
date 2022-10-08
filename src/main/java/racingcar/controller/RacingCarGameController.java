package racingcar.controller;

import racingcar.controller.message.printer.MessagePrinter;
import racingcar.model.input.parser.ParseResult;
import racingcar.model.racing.car.RacingCarsInGame;
import racingcar.model.round.NumberOfRound;
import racingcar.view.Message;
import racingcar.view.result.message.CurrentRaceResultResultMessage;

import java.util.ArrayList;

public class RacingCarGameController {
    private final ParseResult<ArrayList<String>> carNamesParseResult;
    private final ParseResult<Integer> numberOfRoundParseResult;

    public RacingCarGameController(ParseResult<ArrayList<String>> parseResult, ParseResult<Integer> numberOfRoundParseResult) {
        carNamesParseResult = parseResult;
        this.numberOfRoundParseResult = numberOfRoundParseResult;
    }

    public RacingCarsInGame run() {
        RacingCarsInGame racingCarsInGame = new RacingCarsInGame(carNamesParseResult);
        NumberOfRound numberOfRound = new NumberOfRound(numberOfRoundParseResult);
        while (numberOfRound.hasNext()) {
            racingCarsInGame.playOneRound();
            Message currentRaceResultResultMessage = new CurrentRaceResultResultMessage(racingCarsInGame);
            MessagePrinter.println(currentRaceResultResultMessage);
            numberOfRound.next();
        }
        return racingCarsInGame;
    }
}
