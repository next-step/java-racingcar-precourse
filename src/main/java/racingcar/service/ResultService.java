package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Position;
import racingcar.domain.Winners;

public class ResultService {

    private Position maxPosition;
    private Winners winners;

    public void determineMaxPosition(Game game) {
        winners = new Winners();
        maxPosition = new Position(0);
        Cars cars = game.getCars();
        for (Car car : cars.getCarList()) {
            maxPosition.setCarPosition(Math.max(maxPosition.getCarPosition(), car.getPosition().getCarPosition()));
        }
    }

    public void determineWinners(Game game) {
        Cars cars = game.getCars();
        for (Car car : cars.getCarList()) {
            addEachWinner(car);
        }
    }

    private void addEachWinner(Car car) {
        if (car.getPosition().getCarPosition() == maxPosition.getCarPosition()) {
            winners.addWinnerList(car);
        }
    }

    public Winners getWinners() {
        return this.winners;
    }

}
