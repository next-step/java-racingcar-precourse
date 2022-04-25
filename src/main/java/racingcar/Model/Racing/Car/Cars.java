package racingcar.Model.Racing.Car;

import racingcar.Model.Racing.Result.MovementViewer;
import racingcar.Model.Racing.Result.WinnerViewer;
import racingcar.Model.Racing.Result.ResultViewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    private final WinnerViewer winnerViewer = new WinnerViewer();
    private final MovementViewer movementViewer = new MovementViewer();
    private final int movingAmount;

    public Cars(List<Car> carList, int movingAmount) {
        this.carList = carList;
        this.movingAmount = movingAmount;
    }

    public ResultViewer play() {
        this.carList.forEach(this::moveCar);
        makePlayResult();

        return new ResultViewer(this.movementViewer, this.winnerViewer);
    }

    private void moveCar(Car car) {
        for (int i = 0; i < this.movingAmount; i++) {
            car.move();
        }

        car.setAmountOfGO();
    }

    private void makePlayResult() {
        makeMovementView();
        findWinner();
    }

    private void makeMovementView() {
        for (int round = 1; round <= this.movingAmount; round++) {
            makeRoundOfMovement(round);
        }
    }

    private void makeRoundOfMovement(int round) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.carList) {
            stringBuilder.append(String.format("%s \n", car.getMovementStatusString(0, round)));
        }

        this.movementViewer.setMovementsView(stringBuilder.toString());
    }

    private void findWinner() {
        int maxAmountOfGO = findMaxAmountOfGO();
        for (Car car : this.carList) {
            findWinnerCarName(maxAmountOfGO, car);
        }
    }

    private int findMaxAmountOfGO() {
        List<Integer> movingAmountList = new ArrayList<>();
        for (Car car : this.carList) {
            movingAmountList.add(car.getAmountOfGO());
        }

        return Collections.max(movingAmountList);
    }

    private void findWinnerCarName(int maxAmountOfGO, Car car) {
        if (car.isEqualMaxAmountOfGO(maxAmountOfGO)) {
            this.winnerViewer.addWinner(car.getName());
        }
    }
}
