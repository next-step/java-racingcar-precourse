import domain.Cars;
import view.ResultView;

public class Racing {
    private final Cars cars;

    public Racing(String names) {
        this.cars = new Cars(names);
    }

    public void start(int moveCount) {
        this.cars.start(moveCount);
    }

    public void result(ResultView resultView) {
        resultView.print(cars.resultString());
    }
}
