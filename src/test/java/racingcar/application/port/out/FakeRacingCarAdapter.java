package racingcar.application.port.out;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;

public class FakeRacingCarAdapter implements GetRacingCarPort {

    private final RacingCars racingCars;

    public FakeRacingCarAdapter() {
        RacingCar winner1 = new RacingCar(new RacingCarName("a"));
        winner1.move();
        winner1.move();
        RacingCar winner2 = new RacingCar(new RacingCarName("b"));
        winner2.move();
        winner2.move();

        List<RacingCar> racingCarList = Stream.of(winner1, winner2, new RacingCar(new RacingCarName("c")),
                new RacingCar(new RacingCarName("d"))).collect(Collectors.toList());

        racingCars = new RacingCars(racingCarList);
    }

    @Override
    public RacingCars getRacingCars() {
        return racingCars;
    }
}