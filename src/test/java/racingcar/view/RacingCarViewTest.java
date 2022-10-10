package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarViewTest {

    @Test
    @DisplayName("RacingCarView는 전진하지 못해도 이름은 나타내야 함")
    void test2() {
        RaceCarView car1 = RaceCarView.of(UserString.of("car1"), NaturalNumber.of(0));

        assertThat(car1.toString()).isEqualTo("car1 : ");
    }

    @Test
    @DisplayName("RacingCarView는 이름과 위치를 문자열로 나타냄(5칸 전진)")
    void test1() {
        RaceCarView car1 = RaceCarView.of(UserString.of("car1"), NaturalNumber.of(5));

        assertThat(car1.toString()).isEqualTo("car1 : -----");
    }
}