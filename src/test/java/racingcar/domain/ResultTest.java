package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    void 단독_우승_결과() {
        String[] racingCarsName = {"alice", "lisa", "paul"};
        RacingCars racaingCars = new RacingCars(racingCarsName);
        RacingCar racingCar = racaingCars.getRacingCarByIndex(1);
        racingCar.goRacingCar();

        Result result = new Result(racaingCars);
        assertThat(result.getResult()).contains("alice");
    }


}
