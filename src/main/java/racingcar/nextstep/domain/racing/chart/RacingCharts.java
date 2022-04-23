package racingcar.nextstep.domain.racing.chart;

import java.util.List;

public class RacingCharts {

    private List<RacingChart> racingCharts;

    public RacingCharts(List<RacingChart> racingCharts) {
        this.racingCharts = racingCharts;
    }

    public List<RacingChart> getRacingResults() {
        return racingCharts;
    }

    public static RacingCharts of(List<RacingChart> racingCharts) {
        return new RacingCharts(racingCharts);
    }


}
