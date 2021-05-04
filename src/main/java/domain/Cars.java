package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    List<Car> carList;
    List<Car> currentFirstCarList;

    public Cars(List<Car> carList) {
        this.carList = carList;
        checkDuplicateCar();
    }

    public List<Car> carList() {
        return this.carList;
    }

    public List<Car> currentFirstCarList() {
        int farthestDistanceValue = farthestDistance();
        currentFirstCarList = new ArrayList<>();

        for (Car car : this.carList) {
            addFarthestMatchedCar(car, farthestDistanceValue);
        }
        return currentFirstCarList;
    }

    private void addFarthestMatchedCar(Car car, int farthestDistanceValue) {
        if (car.distance() == farthestDistanceValue) {
            currentFirstCarList.add(car);
        }
    }


    private int findFarthestThanFarthestDistanceValue(Car car, int farthestDistanceValue) {
        if (farthestDistanceValue < car.distance()) {
            return car.distance();
        }
        return farthestDistanceValue;

    }

    private int farthestDistance() {
        int farthestDistanceValue = 0;
        for (Car car : carList) {
            farthestDistanceValue = findFarthestThanFarthestDistanceValue(car, farthestDistanceValue);
        }
        return farthestDistanceValue;
    }


    private Set<String> changeListToSet(List<Car> carList) {
        Set<String> carNameSet = new HashSet<>();
        for (Car car : carList) {
            carNameSet.add(car.carName());
        }
        return carNameSet;
    }

    private void checkDuplicateCar() {
        Set<String> carNameSet = changeListToSet(this.carList);
        if (!isSameSize(carNameSet)) {
            throw new IllegalArgumentException("자동차 이름이 같은 자동차가 있습니다.");
        }
    }

    private boolean isSameSize(Set<String> carSet) {
        return carSet.size() == this.carList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : currentFirstCarList()) {
            sb.append(car.carName() + ",");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
