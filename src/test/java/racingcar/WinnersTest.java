package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    private RacingCar sae;
    private RacingCar rang;
    private RacingCar free;

    @BeforeEach
    void setUp() {
        sae = new RacingCar("sae");
        rang = new RacingCar("rang");
        free = new RacingCar("free");
    }

    @Test
    void 우승자_1명의_경우() {
        sae.moveOnCondition(3);
        rang.moveOnCondition(2);
        free.moveOnCondition(4);

        Winners winners = getWinners();

        List<RacingCarName> winnerNames = winners.getWinnerNames();

        assertThat(winnerNames).hasSize(1)
                               .extracting("value")
                               .containsExactly("free");
    }

    @Test
    void 우승자_2명의_경우() {
        sae.moveOnCondition(3);
        rang.moveOnCondition(4);
        free.moveOnCondition(4);

        Winners winners = getWinners();

        List<RacingCarName> winnerNames = winners.getWinnerNames();

        assertThat(winnerNames).hasSize(2)
                               .extracting("value")
                               .containsExactly("rang", "free");
    }

    private Winners getWinners() {
        List<RacingCar> racingCars = Arrays.asList(sae, rang, free);

        return new Winners(racingCars);
    }

}
