package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RacingResult;
import racinggame.domain.Winner;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private RacingResult racingResult;
    private Car pororoCar;
    private Car rupiCar;
    private Car ediCar;

    @BeforeEach
    void setup() {
        Cars cars = new Cars("prr,rupi,edi");
        pororoCar = new Car(cars.cars.get(0));
        rupiCar = new Car(cars.cars.get(1));
        ediCar = new Car(cars.cars.get(2));
        for (int i = 0; i < 5; i++) {
            pororoCar.play();
            rupiCar.play();
            ediCar.play();
        }
        racingResult = new RacingResult();
        racingResult.addResult(pororoCar);
        racingResult.addResult(rupiCar);
        racingResult.addResult(ediCar);
    }

    @Nested
    @DisplayName("mapWinner 메소드는")
    class Describe_mapWinner {
        @Nested
        @DisplayName("5번의 시도를 했을 때")
        class Context_with_five_move {
            @Test
            @DisplayName("우승자를 생성한다.")
            void return_winner_map() {
                Winner winner = new Winner(racingResult);
                assertThat(winner).isNotNull();
            }
        }
    }

}
