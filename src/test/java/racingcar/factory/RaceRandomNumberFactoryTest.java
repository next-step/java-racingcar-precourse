package racingcar.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.vo.racenumber.RaceNumber;

class RaceRandomNumberFactoryTest {

    @DisplayName("1 - 9 범위의 랜덤 숫자 정상 생성")
    @RepeatedTest(100)
    public void 일_부터_구_랜덤_테스트() {
        assertThat(RaceRandomNumberFactory.create()).isInstanceOf(RaceNumber.class);
    }

}