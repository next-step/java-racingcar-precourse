package racinggame.view;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public void setInputView(InputView inputView) {
        this.inputView = inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }
}
