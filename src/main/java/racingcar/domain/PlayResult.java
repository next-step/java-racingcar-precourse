package racingcar.domain;

import java.util.List;

public class PlayResult {
    private final List<CarDTO> results;

    public PlayResult(final List<CarDTO> results) {
        this.results = results;
    }

    public List<CarDTO> getResults() {
        return results;
    }
}
