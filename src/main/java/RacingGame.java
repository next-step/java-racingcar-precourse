import java.util.*;
import java.util.stream.Collectors;

class RacingGame {
    private List<Car> cars;
    private int rounds;

    public void initializeCars(String input) {
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }
        this.cars = cars;
    }

    public void setRounds(String input) {
        try {
            int rounds = Integer.parseInt(input.trim());
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            this.rounds = rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }

    public void race() {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            Output.printRaceStatus(cars);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxDistance = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == maxDistance)
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}