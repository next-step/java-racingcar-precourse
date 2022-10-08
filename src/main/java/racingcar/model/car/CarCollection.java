package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.MessageMaker;
import racingcar.utils.StringUtils;

import java.util.*;

public class CarCollection {

    private static final String NULL_CARNAMES = "자동차이름이 존재해야합니다";
    private static final String INVALID_CARNAMES = "자동차이름은 쉼표를 기준으로 구분할 수 있어야합니다";
    private static final String DUPLICATE_CARNAME = "자동차이름은 중복될 수 없습니다";
    private static final String CARNAME_DELIMITER = ",";
    private static final int MIN_MOVABLE_NUMBER = 0;
    private static final int MAX_MOVABLE_NUMBER = 9;
    private final List<Car> cars;

    private CarCollection(String carNames) {
        validateNames(carNames);
        validateDuplicate(carNames);
        this.cars = createCars(carNames);
    }

    public static CarCollection create(String carNames) {
        return new CarCollection(carNames);
    }

    private void validateDuplicate(String carNames) {
        String[] carNameTokens = carNames.split(CARNAME_DELIMITER);
        if (new HashSet(Arrays.asList(carNameTokens)).size() != carNameTokens.length)
            throw new IllegalArgumentException(MessageMaker.getMessage(DUPLICATE_CARNAME));
    }

    private void validateNames(String carNames) {
        if (carNames == null) throw new NullPointerException(MessageMaker.getMessage(NULL_CARNAMES));
        int delimiterCount = StringUtils.getCharacterCount(carNames, CARNAME_DELIMITER.charAt(0));
        String[] carNameTokens = carNames.split(CARNAME_DELIMITER);
        if (carNameTokens.length != delimiterCount + 1)
            throw new IllegalArgumentException(MessageMaker.getMessage(INVALID_CARNAMES));
    }

    private List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();
        String[] carNameTokens = names.split(CARNAME_DELIMITER);
        for (String carNameToken : carNameTokens) {
            cars.add(new Car(carNameToken));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(MIN_MOVABLE_NUMBER, MAX_MOVABLE_NUMBER));
        }
    }

    public List<Car> getCarsWithMaxPosition() {
        int maxPosition = getMaxPositionOfCars();
        List<Car> maxPositionCars = new ArrayList<>();
        for (Car car : cars) {
            addRacingCarWithPosition(maxPosition, car, maxPositionCars);
        }
        return maxPositionCars;
    }

    private int getMaxPositionOfCars() {
        return Collections
                .max(cars, Comparator.comparingInt(Car::getPosition))
                .getPosition();
    }


    public void addRacingCarWithPosition(int position, Car car, List<Car> cars) {
        if (car.getPosition() == position)
            cars.add(car);
    }
}
