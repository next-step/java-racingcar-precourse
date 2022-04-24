package racingcar.domain.model;

import racingcar.core.common.error.CarErrorCode;
import racingcar.core.common.error.CommonErrorCode;
import racingcar.core.common.helper.PickNumberStrategy;
import racingcar.domain.dto.PlayHistories;
import racingcar.domain.dto.PlayHistory;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final PickNumberStrategy pickNumberStrategy;
    private final List<Car> cars;

    public Cars(final String carNames, final PickNumberStrategy pickNumberStrategy) {
        validate(carNames, pickNumberStrategy);
        this.pickNumberStrategy = pickNumberStrategy;
        this.cars = createCars(carNames.split(","));
    }

    public PlayHistories racing() {
        final List<PlayHistory> playHistories = cars.stream()
                .map(car -> car.moveForward(pickNumberStrategy.pickNumber()))
                .collect(Collectors.toList());

        return new PlayHistories(playHistories);
    }

    public List<String> getWinnersCarNames() {
        final int greatestDistance = findGreatestDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == greatestDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> createCars(final String[] carNames) {
        final List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private int findGreatestDistance() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .orElseThrow(() -> new IllegalStateException(CarErrorCode.UNABLE_TO_FIND_MAX_DISTANCE.getErrorMessage()))
                .getDistance();
    }

    private void validate(String carNames, PickNumberStrategy pickNumberStrategy) {
        validateNull(carNames, pickNumberStrategy);
        validateEmpty(carNames);
        validateDuplicate(carNames);
    }

    private void validateNull(String carNames, PickNumberStrategy pickNumberStrategy) {
        if (Objects.isNull(carNames) || Objects.isNull(pickNumberStrategy)) {
            throw new IllegalArgumentException(CommonErrorCode.NOT_ALLOW_NULL.getErrorMessage());
        }
    }

    private void validateEmpty(String carNames) {
        String trimNames = carNames.trim();

        if (trimNames.isEmpty()) {
            throw new IllegalArgumentException(CommonErrorCode.NOT_ALLOW_EMPTY.getErrorMessage());
        }
    }

    private void validateDuplicate(String carNames) {
        String[] splitNames = carNames.split(",");
        Set<String> nonDuplicatedNames = new HashSet<>(Arrays.asList(splitNames));

        if (!Objects.equals(splitNames.length, nonDuplicatedNames.size())) {
            throw new IllegalArgumentException(CarErrorCode.EXIST_DUPLICATE_CAR_NAME.getErrorMessage());
        }
    }
}