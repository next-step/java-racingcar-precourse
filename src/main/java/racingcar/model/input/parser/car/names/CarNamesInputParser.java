package racingcar.model.input.parser.car.names;

import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.Delimiter;
import racingcar.model.input.parser.InputParser;
import racingcar.model.input.parser.ParseResult;
import racingcar.model.input.parser.ParseResultValue;

import java.util.ArrayList;

public class CarNamesInputParser implements InputParser<ArrayList<String>> {
    private final UserInput userInput;
    private final Delimiter delimiter;

    public CarNamesInputParser(UserInput userInput, Delimiter delimiter) {
        this.userInput = userInput;
        this.delimiter = delimiter;
    }

    @Override
    public ParseResult<ArrayList<String>> parse() {
        final String[] splitTrimmedUserInput = splitUserInputString();
        final ArrayList<String> carNamesList = new ArrayList<>();
        for (int i = 0; i < splitTrimmedUserInput.length; ++i) {
            trimAndAdd(carNamesList, splitTrimmedUserInput, i);
        }
        ParseResultValue<ArrayList<String>> parseResultValue = new ParseResultValue<>(carNamesList);
        return new CarNamesInputParseResult(parseResultValue);
    }

    private String[] splitUserInputString() {
        final String trimmedString = userInput.getUserInputValue().getValue().trim();
        return trimmedString.split(delimiter.get());
    }

    private void trimAndAdd(ArrayList<String> carNamesList, String[] splitTrimmedUserInput, int i) {
        final String currentCarName = splitTrimmedUserInput[i].trim();
        carNamesList.add(currentCarName);
    }
}
