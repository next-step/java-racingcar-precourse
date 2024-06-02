import view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView.printCarInputQuestion();
        System.out.println(InputView.inputCarName());
        InputView.printIterationInputQuestion();
        System.out.println(InputView.inputGameIteration());
        InputView.closeScanner();
    }
}
