package racing;

import java.util.List;

public interface OnRoundStepListener {
    void onStep(CarSet carset);
    void onComplete(List<Car> winners);
}
