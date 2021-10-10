package nextstep.domain;

import java.util.List;

public class Race {

    private final Cars cars;

    public Race(String names) {
        this.cars = new Cars(names);
    }

    public List<MoveResult> move() {
        return cars.move();
    }

    public RaceResult result() {
        int max = 0;
        for (Car car : cars.getCars()) {
            if (car.isGreaterThanEqual(max)) {
                max = car.getDistance();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getCars()) {
            if (car.isEqual(max)) {
                sb.append(car.getName()).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return new RaceResult(sb.toString());
    }

}
