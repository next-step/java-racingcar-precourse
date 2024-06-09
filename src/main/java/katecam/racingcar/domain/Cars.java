package katecam.racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames){
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList())); //Cars를 불변 객체로 만들지 않았으므로 수정될 수 있는 List를 만들어야 함
    }

    public void moveAll(){
        IntStream.range(0, cars.size())
                .forEach(i-> cars.set(i, cars.get(i).move()));
    }
    public List<Car> getWinners(){
        return this.cars.stream()
                .collect(Collectors.groupingBy(Car::getPosition))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Entry::getValue)
                .orElseGet(List::of);
    }
    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }
}
