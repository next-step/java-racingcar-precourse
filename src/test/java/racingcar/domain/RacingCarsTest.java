package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    void 객체_복사_테스트() {

        List<RacingCar> carList = Stream.of(new RacingCar(new RacingCarName("a")),
                new RacingCar(new RacingCarName("b"))).collect(Collectors.toList());

        RacingCars racingCars = new RacingCars(carList);
        RacingCars racingCars1 = RacingCars.newInstance(racingCars);

        for (int i = 0; i < carList.size(); i++) {
            assertEquals(racingCars.getSortedRacingCars().get(i), racingCars1.getSortedRacingCars().get(i));
        }
    }
}