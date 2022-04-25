package racingcar.domain;

import racingcar.view.OutputView;

import java.util.*;

public class CarGroup {
    private static final String ERROR_DUPLICATE_CAR_NAME = "중복된 자동차 이름은 허용하지 않습니다.";

    private List<Car> carGroup;

    public CarGroup(List<Car> carGroup) {
        validateDuplication(carGroup);
        this.carGroup = carGroup;
    }

    private void validateDuplication(List<Car> carGroup) {
        HashSet<Car> carSet = new HashSet<>(carGroup);
        if (carGroup.size() != carSet.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_CAR_NAME);
        }
    }

    public void startingDrive(int numberOfRound) {
        for (int i = 0; i < numberOfRound; i++) {
            carGroup.forEach(Car::goOrStopByRandom);
            carGroup.forEach(OutputView::printResultByCar);
            System.out.println();
        }
    }

    public void setFinalWinner() {
        PriorityQueue<Car> largePositionPq = new PriorityQueue<>(carGroup);
        int maxPosition = -1, nowPosition = -1;

        while (!largePositionPq.isEmpty() && maxPosition == nowPosition) {
            maxPosition = updateMaxPosition(maxPosition, getMaxPosition(largePositionPq, maxPosition), largePositionPq.poll());
            nowPosition = getMaxPosition(largePositionPq, maxPosition);
        }
    }

    private int getMaxPosition(PriorityQueue<Car> largePositionPq, int maxPosition) {
        if (largePositionPq.isEmpty()) {
            return maxPosition;
        }
        return largePositionPq.peek().getPosition().getCarPosition();
    }

    private int updateMaxPosition(int maxPosition, int nowPosition, Car nowCar) {
        if (maxPosition == -1) {
            maxPosition = nowPosition;
        }
        nowCar.setWinnerYn();
        return maxPosition;
    }

    public String getFinalWinner() {
        StringBuilder winnerList = new StringBuilder();
        for (Car car : carGroup) {
            nowWinnerList(winnerList, car);
        }
        return winnerList.toString();
    }

    private void nowWinnerList(StringBuilder winnerList, Car car) {
        if (car.getWinnerYn().isWinner()) {
            isFirst(winnerList);
            winnerList.append(car.getCar());
        }
    }

    private void isFirst(StringBuilder winnerList) {
        if (winnerList.length() > 0) {
            winnerList.append(",");
        }
    }
}
