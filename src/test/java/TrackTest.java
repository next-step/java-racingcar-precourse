import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackTest {
    @Test
    void race_메서드를_실행하면_모든_자동차를_1번씩_이동시킨다() throws InvalidCarNameException {

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
        track.race();

        assertEquals(track.getCar(0).getMoveCount(), 1);
        assertEquals(track.getCar(1).getMoveCount(), 1);
        assertEquals(track.getCar(2).getMoveCount(), 1);
        assertEquals(track.getCar(3).getMoveCount(), 1);
        assertEquals(track.getCar(4).getMoveCount(), 1);
        track.race();

        assertEquals(track.getCar(0).getMoveCount(), 2);
        assertEquals(track.getCar(1).getMoveCount(), 2);
        assertEquals(track.getCar(2).getMoveCount(), 2);
        assertEquals(track.getCar(3).getMoveCount(), 2);
        assertEquals(track.getCar(4).getMoveCount(), 2);
    }
}
