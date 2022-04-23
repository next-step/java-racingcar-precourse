package racingcar.car.model.domain;

import racingcar.car.constant.Constant;
import racingcar.car.model.dto.CarDTO;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarsManager {
    private final List<Car> cars;

    public CarsManager(String namesInput) {
        String[] names = namesInput.split(Constant.CAR_NAMES_DELIMITER);
        cars = createCarsByInput(names);
    }

    private List<Car> createCarsByInput(String[] names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public ArrayList<CarDTO> move() {
        for (Car car : cars) {
            car.move(pickNumberInRange(Constant.RANGE_FOR_CAR_MOVING_MIN, Constant.RANGE_FOR_CAR_MOVING_MAX));
        }
        return getCarDTOList();
    }

    public ArrayList<CarDTO> electWinner() {
        int maxLocation = getMaxLocation();
        return getWinnerList(maxLocation);
    }

    private ArrayList<CarDTO> getWinnerList(int scoreForWin) {
        ArrayList<CarDTO> carsCopy = getCarDTOList();
        carsCopy.removeIf(car -> car.getLocation() != scoreForWin);
        return carsCopy;
    }

    private int getMaxLocation() {
        int maxLocation = -1;
        for (Car car : cars) {
            maxLocation = Math.max(maxLocation, car.getLocation());
        }
        return maxLocation;
    }

    private ArrayList<CarDTO> getCarDTOList() {
        ArrayList<CarDTO> carsCopy = new ArrayList<>();
        for (Car car : cars) {
            carsCopy.add(car.carToDTO());
        }
        return carsCopy;
    }
}
