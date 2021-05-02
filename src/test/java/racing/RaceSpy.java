package racing;

public class RaceSpy extends Race {
    boolean isStart = false;
    @Override
    public void start() {
        isStart = true;
    }
}
