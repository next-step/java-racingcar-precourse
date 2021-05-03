import domain.Cars;
import view.InputView;

public class CarClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String names = inputView.question("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
    }
}
