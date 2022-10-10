package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingSystem {

    public static final int RANDOM_NO_MIN = 0;
    public static final int RANDOM_NO_MAX = 9;
    private List<Car> cars;
    private int randomNo;
    private Position finishPosition;

    public RacingSystem() {
    }

    public RacingSystem(String cars, String finishPosition) {
        setUpCars(cars);
        setUpFinishPosition(finishPosition);
    }

    public void setUpCars(String cars) {
        this.cars = addCarsName(cars);
    }

    public void setUpFinishPosition(String finishPosition) {
        this.finishPosition = new Position(finishPosition);
    }


    public String[] splitCarsName(String carsName, String regex) {
        return carsName.split(",");
    }

    public List<Car> addCarsName(String name) {
        isValidNullCar(name);
        List<Car> cars = new ArrayList<>();

        for (String carName : name.split(",")) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void createRandomNo() {
        this.randomNo = Randoms.pickNumberInRange(RANDOM_NO_MIN, RANDOM_NO_MAX);
    }


    public int getRandomNo() {
        createRandomNo();
        return this.randomNo;
    }

    public boolean isVictoryCar(int maxCount, int position) {
        if (maxCount == position) {
            return true;
        }
        return false;
    }

    public String getVictoryCars(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int maxCount = maxMoveCount(cars);

        for (Car car : cars) {
            if (isVictoryCar(maxCount, car.getPosition())) {
                sb.append(makeVictoryCarString(car.getName(), index));
                index++;
            }
        }

        return sb.toString();
    }


    private String makeVictoryCarString(String name, int index) {
        if (index != 0) {
            name = ", " + name;
        }
        return name;
    }

    private int maxMoveCount(List<Car> cars) {
        int max = 0;
        for (int i = 0; i < cars.size(); i++) {
            int position = cars.get(i).getPosition();
            if (max < position) {
                max = position;
            }
        }
        return max;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void racingCar(Car car, String randomNo) {
        int no = Integer.parseInt(randomNo);
        car.move(no);
    }

    public void isValidNullCar(String cars) {
        if (cars == null || cars.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.getMessage());
        }
    }

    public int getFinishPosition() {
        return finishPosition.getPosition();
    }


}
