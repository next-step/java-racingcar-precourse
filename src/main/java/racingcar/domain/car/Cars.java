package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Moving;
import racingcar.domain.Track;

public class Cars {
    private List<Car> values;

    private Cars(List<Car> values) {
        this.values = values;
    }

    public static Cars from(List<Car> values) {
        return new Cars(values);
    }

    public static Cars of(List<CarName> names, Moving moving) {
        List<Car> results = new ArrayList<>();
        for (CarName name : names) {
            results.add(Car.of(name, moving));
        }

        return new Cars(results);
    }

    public void add(Car car) {
        this.values.add(car);
    }

    public void run() {
        for (Car car : this.values) {
            car.move();
        }
    }

    public List<Car> getValue() {
        return this.values;
    }

    private Track findMostMovedTrack() {
        Track mostTrackMoved = Track.initialize();
        for (Car car : this.values) {
            mostTrackMoved = Track.from(
                    mostTrackMoved.getValue() < car.getTrack() ? car.getTrack() : mostTrackMoved.getValue());
        }

        return mostTrackMoved;
    }

    public List<Car> findMostMovedCars() {
        List<Car> winners = new ArrayList<>();
        Track mostMovedTrack = findMostMovedTrack();
        for (Car car : this.values) {
            addIfWinner(car, mostMovedTrack, winners);
        }

        return winners;
    }

    private void addIfWinner(Car car, Track mostMovedTrack, List<Car> winners) {
        if (car.getTrack().equals(mostMovedTrack.getValue())) {
            winners.add(car);
        }
    }
}
