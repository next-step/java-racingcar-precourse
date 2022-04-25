package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberPicker;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("레이싱 경기는 n회차(round) 진행된다.")
    @Test
    public void play() {
        // given
        int totalRound = 3;
        MockCars mockCars = new MockCars(new RandomNumberPicker());
        Racing racing = new Racing(mockCars, totalRound);
        // when
        racing.play();
        // then
        assertThat(totalRound).isEqualTo(mockCars.count);
    }

    static class MockCars extends RacingCars {

        int count;

        public MockCars(RandomNumberPicker picker, String... carNames) {
            super(picker, carNames);
        }

        @Override
        public void run(Round round) {
            count++;
        }
    }

    @DisplayName("레이싱 경기 우승자를 찾는다.")
    @Test
    public void getWinners() {
        // given
        int totalRound = 2;
        RacingCars racingCars = new RacingCars(new ArrayNumberPicker(),new String[] {"그랜저","제네시스"});
        Racing racing = new Racing(racingCars, totalRound);
        racing.play();
        // when
        Winners winners = racing.getWinners();
        // then
        assertThat(new CarName("제네시스")).isEqualTo(winners.getWinners().get(0));
    }

    static class ArrayNumberPicker extends RandomNumberPicker {

        int index;
        int[] pick = {1,5,2,6};

        @Override
        public int pick() {
            return pick[index++];
        }
    }


}
