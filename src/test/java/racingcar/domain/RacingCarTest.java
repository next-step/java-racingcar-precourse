package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void beforeEach(){
        racingCar = new RacingCar(
                Arrays.asList(
                        //new Car(new CarName("dong"), new Movement()),
                        //new Car(new CarName("kim"), new Movement()),
                        //new Car(new CarName("su"), new Movement()),
                        new Car(new CarName("ha"), new Movement())
                )
        );
    }

    @Test
    void 레이싱_객체_생성_테스트(){
        assertThat(racingCar).isNotNull();
    }

    @Test
    void 한_라운드_테스트(){
        racingCar.race();
        assertThat(racingCar.getCars().get(0).mileage()).isGreaterThanOrEqualTo(0);
        assertThat(racingCar.getCars().get(0).mileage()).isLessThanOrEqualTo(1);
    }

    @Test
    void 경주_테스트(){
        racingCar.startRace(2);
        assertThat(racingCar.getCars().get(0).mileage()).isGreaterThanOrEqualTo(0);
        assertThat(racingCar.getCars().get(0).mileage()).isLessThanOrEqualTo(2);
    }

    @Test
    void 순위_선정_테스트(){

        Car car1 = new Car("dong");
        Car car2 = new Car("ha");
        Car car3 = new Car("kim");
        Car car4 = new Car("su");

        car1.drive(Car.STOP_MAX_VALUE);car1.drive(Car.STOP_MAX_VALUE);
        car2.drive(Car.MOVE_MIN_VALUE);car2.drive(Car.MOVE_MIN_VALUE);car2.drive(Car.MOVE_MIN_VALUE);
        car3.drive(Car.STOP_MAX_VALUE);car3.drive(Car.MOVE_MIN_VALUE);
        car4.drive(Car.MOVE_MIN_VALUE);car4.drive(Car.STOP_MAX_VALUE);car4.drive(Car.MOVE_MIN_VALUE);

        RacingCar racingCar = new RacingCar(Arrays.asList(car1, car2, car3, car4));
        List<Car> rank = racingCar.rank();
        assertThat(rank.get(0).getCarName()).isEqualTo("ha");
        assertThat(rank.get(1).getCarName()).isEqualTo("su");
        assertThat(rank.get(2).getCarName()).isEqualTo("kim");
    }

    @Test
    void 우승자_선정_테스트(){
        //given
        Car car1 = new Car("dong");
        Car car2 = new Car("ha");
        Car car3 = new Car("kim");
        Car car4 = new Car("su");

        car1.drive(Car.STOP_MAX_VALUE);car1.drive(Car.STOP_MAX_VALUE);
        car2.drive(Car.MOVE_MIN_VALUE);car2.drive(Car.MOVE_MIN_VALUE);car2.drive(Car.MOVE_MIN_VALUE);
        car3.drive(Car.STOP_MAX_VALUE);car3.drive(Car.MOVE_MIN_VALUE);
        car4.drive(Car.MOVE_MIN_VALUE);car4.drive(Car.MOVE_MIN_VALUE);car4.drive(Car.MOVE_MIN_VALUE);

        RacingCar racingCar = new RacingCar(Arrays.asList(car1, car2, car3, car4));

        // when
        String result = racingCar.getWinner();

        // then
        assertThat(result).isEqualTo("ha,su");
    }
}
