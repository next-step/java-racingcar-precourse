package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LocationsTest {
    @Test
    void 차들을_셋팅할_수_있다() {
        Assertions.assertDoesNotThrow(() -> {
            new Locations(new Cars());
        });
    }

    @Test
    void 등록된_차의_위치를_가져올_수_있다() {
        Car added_car = new Car(new CarName("mock"));

        Cars cars = new Cars();
        cars.add(added_car);
        Locations locations = new Locations(cars);

        Assertions.assertDoesNotThrow(() -> locations.getPosition(added_car));
    }

    @Test
    void 등록되지_않은_차의_위치를_가져올_수_없다() {
        Car not_added_car = new Car(new CarName("mock"));

        Cars cars = new Cars();
        Locations locations = new Locations(cars);

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> locations.getPosition(not_added_car));
    }

    @Test
    void 등록된_차의_위치를_업데이트할_수_있다() {
        Car added_car = new Car(new CarName("mock"));

        Cars cars = new Cars();
        cars.add(added_car);
        Locations locations = new Locations(cars);

        Assertions.assertDoesNotThrow(() -> locations.update(added_car));

    }

    @Test
    void 등록되지_않은_차의_위치를_업데이트할_수_없다() {
        Car not_added_car = new Car(new CarName("mock"));

        Cars cars = new Cars();
        Locations locations = new Locations(cars);

        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> locations.update(not_added_car));
    }

    @Test
    void 등록된_모든_차들을_가져올_수_있다() {
        Car car1 = new Car(new CarName("1"));
        Car car2 = new Car(new CarName("2"));

        Car not_added_car = new Car(new CarName("3"));

        Cars cars = new Cars();
        cars.add(car1);
        cars.add(car2);

        Cars added_cars = new Locations(cars).getAll();
        Assertions.assertEquals(added_cars.size(), 2);
        Assertions.assertFalse(added_cars.contains(not_added_car));
        Assertions.assertEquals(added_cars.get(0).toString(), car1.toString());
        Assertions.assertEquals(added_cars.get(1).toString(), car2.toString());
    }

    @Test
    void 등록된_모든_차들_중_winners_를_가져올_수_있다() {
        Car car1 = new Car(new CarName("1"));
        Car car2 = new Car(new CarName("2"));

        Cars cars = new Cars();
        cars.add(car1);
        cars.add(car2);

        Cars winners = new Locations(cars).winners();
        Assertions.assertEquals(winners.size(), 2);
        Assertions.assertEquals(winners.get(0).toString(), car1.toString());
        Assertions.assertEquals(winners.get(1).toString(), car2.toString());
    }

}
