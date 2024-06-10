package domain;

import util.RandomGeneratingMove;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int MINIMUM_CAR_COUNT = 2;
    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        isDifferentCarName(cars);
        minimumNumofCars(cars.size());
        this.cars = cars;
    }

    public void moveAll(final RandomGeneratingMove randomGeneratingMove) {
        for (final RacingCar car : cars) {
            int engine = randomGeneratingMove.generateRandomInt();
            car.move(engine);
        }
    }

    private void isDifferentCarName(List<RacingCar> cars) {
        List<String> carName = cars.stream()
                .map(idx -> idx.getRacingCarName())
                .collect(Collectors.toList());

        HashSet<String> carNameDuplicateSet = new HashSet<>(carName);

        if (carNameDuplicateSet.size() != carName.size()) {
            throw new IllegalArgumentException("자동차 이름을 중복으로 사용할 수 없습니다.");
        }
    }

    private void minimumNumofCars(int size) {
        if (size < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException("자동차 경주를 위해서는 최소 2대 이상의 자동차를 만들어야 합니다.");
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public List<String> findWinners(){
        RacingCar maxDistanceCar = findMaxDistanceCar();
        List<String> winnerCarNameList = findSameDistanceList(maxDistanceCar);
        return winnerCarNameList;
    }

    private RacingCar findMaxDistanceCar() {
        return cars.stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    private List<String> findSameDistanceList(RacingCar maxDistanceCar) {
        return cars.stream()
                .filter(maxDistanceCar::isSameDistance)
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.toList());
    }
}
