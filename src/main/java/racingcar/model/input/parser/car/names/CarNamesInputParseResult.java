package racingcar.model.input.parser.car.names;

import racingcar.model.input.parser.ParseResult;
import racingcar.model.input.parser.ParseResultValue;

import java.util.ArrayList;

public class CarNamesInputParseResult implements ParseResult<ArrayList<String>> {
    private final ParseResultValue<ArrayList<String>> carNamesList;

    public CarNamesInputParseResult(ParseResultValue<ArrayList<String>> carNamesList) {
        this.carNamesList = carNamesList;
    }

    @Override
    public ParseResultValue<ArrayList<String>> getParseResultValue() {
        return carNamesList;
    }

    public ArrayList<String> getCarNamesList() {
        return carNamesList.getValue();
    }
}
