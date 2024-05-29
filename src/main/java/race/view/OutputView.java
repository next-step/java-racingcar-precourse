package race.view;

public class OutputView {
    private OutputView() {}

    private static class SingleToneHelper {
        private static final OutputView INSTANCE = new OutputView();
    }

    public OutputView getInstance() {
        return SingleToneHelper.INSTANCE;
    }
}
