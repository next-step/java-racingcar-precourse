import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackTest {
    @Test
    void race_메서드를_실행하면_모든_자동차를_1번씩_이동시킨다() throws InvalidCarNameException {

        // given
        Track track = new Track();
        Car car = new Car("test2");
        Car car2 = new Car("test2");
        Car car3 = new Car("test3");
        Car car4 = new Car("test4");
        Car car5 = new Car("test5");
        track.addCar(car);
        track.addCar(car2);
        track.addCar(car3);
        track.addCar(car4);
        track.addCar(car5);

        // when
        track.race();

        // then
        assertEquals(track.getCar(0).getMoveCount(), 1);
        assertEquals(track.getCar(1).getMoveCount(), 1);
        assertEquals(track.getCar(2).getMoveCount(), 1);
        assertEquals(track.getCar(3).getMoveCount(), 1);
        assertEquals(track.getCar(4).getMoveCount(), 1);

        // when
        track.race();

        // then
        assertEquals(track.getCar(0).getMoveCount(), 2);
        assertEquals(track.getCar(1).getMoveCount(), 2);
        assertEquals(track.getCar(2).getMoveCount(), 2);
        assertEquals(track.getCar(3).getMoveCount(), 2);
        assertEquals(track.getCar(4).getMoveCount(), 2);
    }

    @Test
    void test_get_result_메서드를_실행하면_가장_멀리있는_차량을_리턴한다() throws InvalidCarNameException, NoSuchFieldException, IllegalAccessException {
        //given
        Car car = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");
        Car car5 = new Car("5");

        //when
        Field field = Car.class.getDeclaredField("position");
        field.set(car, 1);
        field.set(car2, 2);
        field.set(car3, 3);
        field.set(car4, 4);
        field.set(car5, 5);
        Track track = new Track();
        track.addCar(car);
        track.addCar(car2);
        track.addCar(car3);
        track.addCar(car4);
        track.addCar(car5);

        //then
        List<Car> winners = track.getWinners();
        assertEquals(winners.get(0).getPosition(), 5);
        assertEquals(winners.get(0).getName(), "5");

        //when
        field.set(car, 1);
        field.set(car2, 2);
        field.set(car3, 5);
        field.set(car4, 5);
        field.set(car5, 5);
        track.getWinners().sort(Comparator.comparing(o -> o.name));
        winners = track.getWinners();

        //then
        assertEquals(winners.get(0).getPosition(), 5);
        assertEquals(winners.size(), 3);
        assertEquals(winners.get(0).getName(), "5");
        assertEquals(winners.get(1).getName(), "4");
        assertEquals(winners.get(2).getName(), "3");


    }
}
