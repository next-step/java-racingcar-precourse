import view.InputView;
import view.ResultView;

public class CarClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String names = inputView.questionToString("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");

        Racing racing = new Racing(names);
        int moveCount = inputView.questionToInt("시도할 회수는 몇회인가요?");

        racing.start(moveCount);

        resultView.print("실행결과");
        racing.result(resultView);
    }
}
