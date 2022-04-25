package racingcar.model;

import racingcar.model.vo.Car;
import racingcar.model.vo.CarName;
import racingcar.model.vo.CarPosition;
import racingcar.service.ValidateService;
import racingcar.service.impl.ValidateServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> listCar;

    public Cars(String carNames) {
        listCar = new ArrayList<>();
        setCars(Arrays.asList(carNames.split(",")));
    }

    private void setCars(List<String> carNames) {
        ValidateService validateService = new ValidateServiceImpl();
        for (String carName : carNames) {
            validateService.validateCarName(this, carName.trim());
            listCar.add(new Car(new CarName(carName.trim()), new CarPosition(0)));
        }
    }

    public List<Car> toList() {
        return listCar;
    }

    public String getCarName(int index) {
        return toList().get(index).getCarName().getName();
    }

    public List<String> getListCarName() {
        List<String> listCarName = new ArrayList<>();
        for (Car car : toList()) {
            listCarName.add(car.getCarName().getName());
        }
        return listCarName;
    }

    public int isMaxPosition() {
        Collections.sort(toList());
        return toList().get(0).getCarPosition().getPosition();
    }

    public List<String> winnerName(int max) {
        List<String> listWinner = new ArrayList<>();
        for (Car car : listCar) {
            listWinner.add(car.winnerCar(max));
        }
        listWinner.removeAll(Arrays.asList(""));

        return listWinner;
    }
}
