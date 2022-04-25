package racingcar.Model.Racing;

import racingcar.Model.Racing.Car.Car;
import racingcar.Model.Racing.Car.Cars;
import racingcar.Model.Racing.Result.ResultViewer;
import racingcar.Model.User;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final User user;
    private Cars cars;

    public Racing(User user) {
        this.user = user;

        createCar();
    }

    private void createCar() {
        List<Car> carList = new ArrayList<>();
        for (String carName : this.user.getCarNameArray()) {
            carList.add(new Car(carName));
        }

        this.cars = new Cars(carList, user.getMovingAmount());
    }

    public ResultViewer gameStart() {
        return this.cars.play();
    }
}
