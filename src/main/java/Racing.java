import domain.Cars;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Racing {
    private final InputView inputView;
    private final ResultView resultView;

    private final Cars cars;
    private int count;

    public Racing(String startQuestion) {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.cars = new Cars(inputView.questionToString(startQuestion));
    }

    public void start() {
        resultView.print("실행결과");
        this.cars.start(count);
    }

    public List<String> getWinners() {
        return cars.winners();
    }

    public void count() {
        this.count = inputView.questionToInt("시도할 회수는 몇회인가요?");
    }

    public void winners() {
        resultView.printWinner(getWinners());
    }
}
