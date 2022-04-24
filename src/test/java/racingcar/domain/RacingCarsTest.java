package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("RacingCars클래스")
public class RacingCarsTest {

    @DisplayName("getWinners() 는")
    @Nested
    class Describe_Get_Winners {

        @DisplayName("가장 많이 이동한 자동차가 있다면")
        @Nested
        class Context_Has_Max_And_Same_Distance {

            private RacingCars racingCars;

            @BeforeEach
            void setup() {
                final List<RacingCar> racingCarList = new ArrayList<>();
                racingCarList.add(new RacingCar("pobi", 4));
                racingCarList.add(new RacingCar("honux", 2));
                racingCarList.add(new RacingCar("woni", 3));
                racingCarList.add(new RacingCar("jun", 4));
                racingCars = new RacingCars(racingCarList);

            }

            @DisplayName("우승자를 반환한다. (같은 경우에는 공동 우승자들을 같이 반환)")
            @Test
            void it_Returns_Winners() {

                final RacingCars winners = racingCars.getWinners();
                assertThat(winners.size()).isEqualTo(2);
                assertThat(winners.get(0).getName()).isEqualTo("pobi");
                assertThat(winners.get(1).getName()).isEqualTo("jun");

            }

        }

    }

}
