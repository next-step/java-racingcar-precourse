package racingcar.application.port;

import java.util.List;
import racingcar.domain.Activity;
import racingcar.domain.Car;

public class RacingCarResultResponse {
    private final List<ActivityResponse> activities;
    private final List<CarResponse> winners;

    public RacingCarResultResponse(final List<Activity> activities, final List<Car> winners) {
        this.activities = activities.stream().map(ActivityResponse::new).toList();
        this.winners = winners.stream().map(CarResponse::new).toList();
    }

    public List<ActivityResponse> activities() {
        return this.activities;
    }

    public List<CarResponse> winners() {
        return this.winners;
    }
}
