package racingcar.model.input.parser;

import racingcar.controller.user.input.UserInput;
import racingcar.model.delimiter.Delimiter;

public interface InputParser<T> {
    ParseResult<T> parse();
}
