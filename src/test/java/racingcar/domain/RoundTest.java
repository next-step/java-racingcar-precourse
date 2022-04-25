package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @DisplayName("자동차의 주행 거리를 기록한다.")
    @Test
    public void record() {
        // given
        Round round = new Round();
        CarName carName = new CarName("그랜져");
        Mileage mileage = Mileage.init().plus();
        // when
        round.record(carName, mileage);
        // then
        assertThat(mileage).isEqualTo(round.getMileage(carName));
    }

    @DisplayName("주행 거리가 가장 긴 자동차를 찾는다.")
    @MethodSource
    @ParameterizedTest
    public void getWinners(Round round, CarName carName) {
        // when
        Winners winners = round.getWinners();
        // then
        assertThat(carName).isEqualTo(winners.getWinners().get(0));
    }

    private static Stream<Arguments> getWinners() {
        // given
        Round round = new Round();
        CarName grandeur = new CarName("그랜져");
        CarName genesis = new CarName("제네시스");
        CarName sorento = new CarName("쏘렌토");

        Mileage mileageOfGrandeur = Mileage.init().plus().plus().plus();
        Mileage mileageOfGenesis = Mileage.init();
        Mileage mileageOfSorento = Mileage.init().plus();

        round.record(grandeur, mileageOfGrandeur);
        round.record(genesis, mileageOfGenesis);
        round.record(sorento, mileageOfSorento);

        Round round2 = new Round();

        mileageOfGenesis = Mileage.init().plus().plus().plus().plus();

        round2.record(grandeur, mileageOfGrandeur);
        round2.record(genesis, mileageOfGenesis);
        round2.record(sorento, mileageOfSorento);
        // then
        return Stream.of(
                Arguments.of(round, grandeur),
                Arguments.of(round2, genesis)
        );
    }

    @DisplayName("주행 거리가 같을 경우 공동 우승자로 선정한다.")
    @Test
    public void coWinner() {
        // given
        Round round = new Round();
        CarName grandeur = new CarName("그랜져");
        CarName genesis = new CarName("제네시스");

        Mileage mileageOfGrandeur = Mileage.init().plus().plus();
        Mileage mileageOfGenesis = Mileage.init().plus().plus();

        round.record(grandeur, mileageOfGrandeur);
        round.record(genesis, mileageOfGenesis);
        // when
        Winners winners = round.getWinners();
        // then
        assertThat(Arrays.asList(grandeur, genesis)).isEqualTo(winners.getWinners());
    }

}