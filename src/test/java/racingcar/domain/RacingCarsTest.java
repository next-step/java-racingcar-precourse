package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    @DisplayName("RacingCars 생성 테스트")
    @Nested
    class CreateTest {

        @DisplayName("자동차 이름 리스트로 RacingCars를 생성할 수 있다.")
        @Test
        void createSuccessTest() {
            assertThatNoException()
                    .isThrownBy(() -> RacingCars.of(Arrays.asList("aaa", "bbb", "ccc")));
        }

        @DisplayName("중복된 이름으로 RacingCars 생성 시, IllegalArgumentException 예외가 발생한다.")
        @Test
        void duplicateNameTest() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> RacingCars.of(Arrays.asList("aaa", "aaa")))
                    .withMessageContaining("aaa");
        }

        @ParameterizedTest(name = "null 또는 빈 리스트로 RacingCars 생성 시, IllegalArgumentException 예외가 발생한다. [{index}]")
        @NullAndEmptySource
        void nullAndEmptyListTest(final List<String> carNameList) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> RacingCars.of(carNameList))
                    .withMessageContaining(String.valueOf(carNameList));
        }
    }

    @DisplayName("우승자 테스트")
    @Nested
    class GetWinnersTest {

        @DisplayName("가장 많이 전진한 자동차가 우승한다.")
        @Test
        void getWinnersTest() {
            final RacingCar winner1 = new RacingCar(new RacingCarName("aaa"), new RacingCarPosition(3));
            final RacingCar winner2 = new RacingCar(new RacingCarName("bbb"), new RacingCarPosition(3));
            final RacingCar looser1 = new RacingCar(new RacingCarName("ccc"), new RacingCarPosition(2));
            final RacingCar looser2 = new RacingCar(new RacingCarName("ddd"), new RacingCarPosition(1));
            final RacingCars racingCars = new RacingCars(Arrays.asList(winner1, winner2, looser1, looser2));

            final List<RacingCar> winners = racingCars.getWinners();

            assertThat(winners)
                    .containsExactly(winner1, winner2);
        }
    }

}