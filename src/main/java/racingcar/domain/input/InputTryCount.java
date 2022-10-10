package racingcar.domain.input;

import racingcar.domain.TryCount;

public class InputTryCount implements Input<TryCount> {

    private final String input;

    public InputTryCount(String input) {
        this.validateBlank(input);
        this.input = input;
    }

    @Override
    public TryCount create() {
        return new TryCount(this.input);
    }
}
