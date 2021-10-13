package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RacingResult;
import racinggame.domain.Winner;

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

        pororoCar.setMoveCnt(3);
        rupiCar.setMoveCnt(2);
        ediCar.setMoveCnt(1);

        racingResult = new RacingResult();
        racingResult.addResult(pororoCar);
        racingResult.addResult(rupiCar);
        racingResult.addResult(ediCar);
    }

    @Nested
    @DisplayName("mapWinner 메소드는")
    class Describe_mapWinner {
        @Nested
        @DisplayName("pororoCars가 우승자이므로")
        class Context_with_winner_car {
            @Test
            @DisplayName("prr를 매핑한다.")
            void return_winner_map() {
                Winner winner = new Winner(racingResult);
                assertThat(winner.findWinner(racingResult)).contains("prr").doesNotContain("rupi", "edi");
            }
        }
    }

    @Nested
    @DisplayName("findWinnerCnt 메소드는")
    class Describe_findWinnerCnt {
        @Nested
        @DisplayName("가장 멀리간 우승자의 이동 거리를 찾아주므로")
        class Context_with_winner_car_move_cnt {
            @Test
            @DisplayName("prr의 이동거리인 3을 반환한다.")
            void return_winner_car_move_count() {
                Winner winner = new Winner(racingResult);
                assertThat(winner.findWinnerCnt(racingResult)).isEqualTo(3);
            }
        }
    }

}
