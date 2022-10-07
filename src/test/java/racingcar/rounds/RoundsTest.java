package racingcar.rounds;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.cars.Cars;

import java.util.ArrayList;
import java.util.List;

public class RoundsTest {

    private Rounds rounds;
    Cars cars;

    @BeforeEach
    void beforeEach() throws IllegalArgumentException {
        String input = "pobi,javaj,crong,honux";
        cars = Cars.generateRacingCarsFromInputString(input);
        List<Round> roundList = new ArrayList<>();
        Round round1 = new Round(cars.race(), 1);
        System.out.println();
        Round round2 = new Round(cars.race(), 2);
        System.out.println();
        Round round3 = new Round(cars.race(), 3);
        System.out.println();
        roundList.add(round1);
        roundList.add(round2);
        roundList.add(round3);
        rounds = new Rounds(roundList);
    }

    @Test
    void 라운드_객체_생성() {
        rounds = Rounds.playRacingCars(cars, 4);
        Assertions.assertThat(rounds.getRounds().size()).isEqualTo(4);

    }
}
