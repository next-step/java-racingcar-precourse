package racingcar.game;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.function.Function;
import racingcar.model.function.ReadyToStart;
import racingcar.utils.InputNumber;
import racingcar.utils.InputString;
import racingcar.view.io.InputFunction;
import racingcar.view.io.OutputFunction;

import java.util.List;

public class GameManager {

    Function nextStep;

    public GameManager(Function function) {
        nextStep = function;
    }

    private List<Car> carList;
    public void next() {
        this.nextStep = this.nextStep.next(this);
    }

    public void init(){
        OutputFunction.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strCars = InputFunction.readLine();

        Cars cars = new Cars(new InputString(strCars));
        this.carList = cars.splitCars(cars);
    }

    public InputNumber iterationInput(){
        OutputFunction.println("시도할 회수는 몇회인가요?");
        String iterCount = InputFunction.readLine().trim();
        InputNumber inputNumber = new InputNumber(iterCount);

        return inputNumber;
    }

    public void showResult(){
        GameResult gameResult = new GameResult(this.carList);
        gameResult.printWinnerList();
    }

    public void iterationRacing(InputNumber inputNumber) {

        int count = inputNumber.getIterationCount();
        for(int i=0; i<count; i++){
            runRacing();
        }
    }

    private void runRacing() {
        for (Car car : this.carList) {
            car.isGoAndStop();
            car.printGoResult();
        }
        OutputFunction.println("");
    }

    public boolean isPlay(){
        return this.nextStep.isPlay();
    }
}
