package racing;

public interface OnRoundStepListener {
    void onStep(CarSet carset);
    void onComplete(CarSet winners);
}
