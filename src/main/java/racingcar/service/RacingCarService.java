package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.constants.OptionConstants;
import racingcar.domain.Car;
import racingcar.domain.CarNamesInput;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;
import racingcar.domain.IndexNumber;
import racingcar.domain.Winners;
import racingcar.enums.CarMovingStateEnum;
import racingcar.util.CarMovingStateUtil;

public class RacingCarService {

    private Cars cars;

    public void initService(CarNamesInput carNamesInput) {
        String[] nameArray = carNamesInput.getNames().split(OptionConstants.CAR_NAME_SPLIT_REGEX);
        List<Car> carList = new ArrayList<>();

        for (String name : nameArray) {
            carList.add(new Car(name));
        }

        cars = new Cars(carList);
    }

    public Cars playRace() {
        for (IndexNumber idx = new IndexNumber(); idx.getIndexNumber() < cars.size(); idx.increaseIndex()) {
            moveCar(cars.get(idx));
        }

        return cars;
    }

    private void moveCar(Car car) {
        if(CarMovingStateUtil.judgeMovingState() == CarMovingStateEnum.MOVE) {
            car.getCarPosition().increasePosition();
        }
    }

    public Winners getWinners() {
        Winners winners = new Winners();
        CarPosition maxPosition = getMaxCarPosition();

        for (IndexNumber idx = new IndexNumber(); idx.getIndexNumber() < cars.size(); idx.increaseIndex()) {
            addConfirmedWinner(winners, cars.get(idx), maxPosition);
        }

        return winners;
    }

    private CarPosition getMaxCarPosition() {
        CarPosition maxPosition = null;
        for (IndexNumber idx = new IndexNumber(); idx.getIndexNumber() < cars.size(); idx.increaseIndex()) {
            maxPosition = selectBiggerPosition(maxPosition, cars.get(idx).getCarPosition());
        }

        return maxPosition;
    }

    private CarPosition selectBiggerPosition(CarPosition positionA, CarPosition positionB) {
        if(positionA == null) {
            return positionB;
        }

        if(positionA.getPosition() >= positionB.getPosition()) {
            return positionA;
        }

        return positionB;
    }

    private void addConfirmedWinner(Winners winners, Car car, CarPosition maxPosition) {
        if(car.getCarPosition().getPosition() == maxPosition.getPosition()) {
            winners.add(car.getCarName());
        }
    }
}
