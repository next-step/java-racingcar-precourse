package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    public static final int MOVING_FORWARD = 4;
    public static final int STOP = 3;
    Car car;

    @BeforeEach
    void beforeEach(){
        car = new Car(new CarName("dong"), new Movement());
    }

    @Test
    void 차_생성_테스트(){
        assertThat(car).isNotNull();
    }

    @Test
    void 차_주행_테스트(){
        car.drive(4);
        car.drive(5);
        car.drive(6);
        car.drive(7);
        car.drive(8);
        car.drive(9);
        assertThat(car.mileage()).isEqualTo(6);
    }

    @Test
    void 차_미주행_테스트(){
        car.drive(0);
        car.drive(1);
        car.drive(2);
        car.drive(3);
        assertThat(car.mileage()).isEqualTo(0);
    }

    @Test
    void 차_주행거리_비교(){
        Car dong = new Car("dong");
        Car ha = new Car("ha");

        dong.drive(STOP);
        ha.drive(MOVING_FORWARD);

        List<Car> cars = new ArrayList<>();
        cars.add(dong); cars.add(ha);

        cars.sort(new DistanceComparator().reversed());

        assertThat(cars.get(0).getCarName()).isEqualTo("ha");
        assertThat(cars.get(1).getCarName()).isEqualTo("dong");
    }

    @Test
    void 현_주행_상황_출력(){
        Car car = new Car("dong");

        car.drive(Car.MOVE_MIN_VALUE);
        car.drive(Car.MOVE_MIN_VALUE);

        assertThat(car.printRacingState()).isEqualTo("dong : --");
    }
}
