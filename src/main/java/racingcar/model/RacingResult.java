package racingcar.model;

import Utils.MaxValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.view.ErrorMessageView;
import racingcar.view.ResultMessageView;

public class RacingResult {
    private List<Car> carList;
    private int playRoundCount;

    public RacingResult(String carNameList, String playRoundCount) {
        this.carList = Arrays.stream(carNameList.split(",")).map(Car::new).collect(Collectors.toList());

        checkDuplicatedCarName();

        try{
            this.playRoundCount = Integer.parseInt(playRoundCount);
        } catch (IllegalArgumentException e) {
            ErrorMessageView.throwErrorPleaseInputNumber();
        }
    }

    private void checkDuplicatedCarName() {
        if(this.carList.stream().map(Car::getCarName).distinct().count() != this.carList.size()) {
            ErrorMessageView.throwErrorDuplicateCarName();
        }
    }

    public void racing() {
        ResultMessageView.executionResultMessage();
        IntStream.range(0, this.playRoundCount).forEach(
                tryCount -> {
                    carList.forEach(car -> car.moveCar(new Racing().randomValue()));
                    ResultMessageView.nowCarDistanceMessage(carList);
                }
        );
    }

    public void getResult() {
        List<String> winCarList = this.carList.stream()
                .filter(car -> car.isWinner(MaxValue.getMaxValue(getDistanceList())))
                .map(Car::getCarName).collect(Collectors.toList());
        ResultMessageView.finalRacingWinnerMessage(winCarList);
    }

    public List<Integer> getDistanceList() {
        return this.carList.stream().map(Car::getDistance).collect(Collectors.toList());
    }
}
