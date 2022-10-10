package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacinggameException;

public class CarList {

    private static final int CAR_LIST_MIN_SIZE = 2;
    private static final String CAR_NAME_LIST_SEPARATOR = ",";

    private final List<Car> carList;

    private CarList(List<Car> carList) {
        this.carList = carList;
    }

    public static CarList from(String multipleCarNameString) {
        List<String> carNameList = parseCarName(multipleCarNameString);

        validateCarListSize(carNameList);

        return new CarList(generateCarList(carNameList));
    }

    private static List<String> parseCarName(String multipleCarNameString) {
        return new ArrayList<>(Arrays.asList(multipleCarNameString.split(CAR_NAME_LIST_SEPARATOR)));
    }


    private static void validateCarListSize(List<String> carList) {
        if (carList.size() < CAR_LIST_MIN_SIZE) {
            throw new RacinggameException(ErrorMessage.INVALID_CAR_LIST_SIZE.getValue());
        }
    }

    private static List<Car> generateCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(Car.fromName(carName));
        }

        return carList;
    }

    public void forward() {
        for (Car car : this.carList) {
            car.forward();
        }
    }
    
    public List<Car> getLongestDistanceCarList() {
        int longestDistance = getLongestDistance();

        return extractLongestDistanceCarList(longestDistance);
    }

    private int getLongestDistance() {
        int longestDistance = 0;

        for (Car car : this.carList) {
            longestDistance = Math.max(longestDistance, car.getPosition());
        }

        return longestDistance;
    }

    private List<Car> extractLongestDistanceCarList(int longestDistance) {
        List<Car> carList = new ArrayList<>();

        for (Car car : this.carList) {
            if (isLongestDistanceCar(car, longestDistance)) {
                carList.add(car);
            }
        }

        return carList;
    }

    private boolean isLongestDistanceCar(Car car, int longestDistance) {
        return car.getPosition() == longestDistance;
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
