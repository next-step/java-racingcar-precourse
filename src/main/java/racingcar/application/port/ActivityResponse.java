package racingcar.application.port;

import java.util.List;
import racingcar.domain.Activity;

public class ActivityResponse {
    private final List<CarResponse> carResponses;

    public ActivityResponse(final Activity activity) {
        this.carResponses = activity.value().stream()
                .map(CarResponse::new)
                .toList();
    }

    public List<CarResponse> carResponses() {
        return carResponses;
    }
}
