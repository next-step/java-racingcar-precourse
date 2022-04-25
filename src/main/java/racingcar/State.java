package racingcar;

public interface State {
    void viewUpdate();
    Context readInput();
    void evaluateData(Context context);
    void nextState();
}
