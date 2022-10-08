package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setup() {
        racingCars = new RacingCars("pony,benz,rebo");
    }

    @Test
    void 자동차이름_중복_에러발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars("pony,benz,pony");
        });
    }

    @Test
    void 자동차이름_5글자초과시_에러발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCars("pony,benz,reboooo");
        });
    }

    @Test
    void 포니_우승() {

        racingCars.cars.get(0).drive(DriveStatus.DRIVE);
        racingCars.cars.get(0).drive(DriveStatus.DRIVE);

        racingCars.cars.get(1).drive(DriveStatus.DRIVE);

        List<Car> winners = racingCars.winners();
        assertThat(winners.contains(new Car("pony"))).isTrue();
        assertThat(winners.contains(new Car("benz"))).isFalse();
        assertThat(winners.contains(new Car("rebo"))).isFalse();
    }

    @Test
    void 포니_벤츠_공동우승() {

        racingCars.cars.get(0).drive(DriveStatus.DRIVE);
        racingCars.cars.get(0).drive(DriveStatus.DRIVE);

        racingCars.cars.get(1).drive(DriveStatus.DRIVE);
        racingCars.cars.get(1).drive(DriveStatus.DRIVE);

        List<Car> winners = racingCars.winners();
        assertThat(winners.contains(new Car("pony"))).isTrue();
        assertThat(winners.contains(new Car("benz"))).isTrue();
        assertThat(winners.contains(new Car("rebo"))).isFalse();
    }

    @Test
    void 레보_우승() {

        racingCars.cars.get(0).drive(DriveStatus.DRIVE);
        racingCars.cars.get(0).drive(DriveStatus.DRIVE);

        racingCars.cars.get(1).drive(DriveStatus.DRIVE);

        racingCars.cars.get(2).drive(DriveStatus.DRIVE);
        racingCars.cars.get(2).drive(DriveStatus.DRIVE);
        racingCars.cars.get(2).drive(DriveStatus.DRIVE);

        List<Car> winners = racingCars.winners();
        assertThat(winners.contains(new Car("pony"))).isFalse();
        assertThat(winners.contains(new Car("benz"))).isFalse();
        assertThat(winners.contains(new Car("rebo"))).isTrue();
    }

}
