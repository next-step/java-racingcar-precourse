package race.view;

public class InputView {
    private InputView() {}

    // 내부 클래스가 호출될 때, Instance 가 생성된다
    private static class SingletonHelper {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
