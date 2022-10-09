package racingcar.controller;

import racingcar.common.CarMessage;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Position;
import racingcar.domain.Round;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
public class CarController {
    public void run(){
        List<Car> cars = createCars();
        int round = getRound();
        for (int i=0; i < round; i++) {
            for (Car car : cars) {
                car.getPosition().addPosition();
                OutputView.println(car.getCarName().getName() + " : " + car.getPosition().getPositionStr());
            }
            OutputView.println("");
        }
        getWinner(cars);
    }

    public List<Car> createCars(){
        List<Car> cars = new ArrayList<>();
        String carNames = InputView.inputCarNames();

        for (String car: carNames.split(CarMessage.SEPARATOR)
             ) {
            cars.add(new Car(new CarName(car.trim()),new Position(0)));
        }
        return cars;
    }

    public int getRound(){
        Integer input = Integer.valueOf(InputView.tryCar());
        Round round = new Round(input);
        return round.getRound();
    }

    public void getWinner(List<Car> cars){
        int maxScore = getMaxScore(cars);
        Winner winner = new Winner();
        String carName = winner.getCarName(cars,maxScore);
        OutputView.println(carName);
    }

    public int getMaxScore(List<Car> cars) {
        int maxScore = 0;
        for (Car car : cars) {
            if(maxScore < car.getPosition().getPosition()){
                maxScore = car.getPosition().getPosition();
            }
        }
        return maxScore;
    }

}
