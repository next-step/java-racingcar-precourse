package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

class RacingCarTest {

    private static MockedStatic<Randoms> randomsMock;

    @BeforeAll
    static void before() {
        randomsMock = mockStatic(Randoms.class);
    }

    @AfterAll
    static void after() {
        randomsMock.close();
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4 이상일 경우, 차량의 오프셋이 증가한다")
    @ValueSource(ints = {4,5,6,7,8,9})
    void 랜덤_값이_4_이상일_경우_차량의_오프셋이_증가한다(Integer randomValue) {
        // given
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomValue);
        RacingCar racingCar = RacingCar.of("name");

        // when
        racingCar.move();

        // then
        assertThat(racingCar.getOffset()).isGreaterThan(0);
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 4 미만일 경우, 차량의 오프셋이 증가하지 않는다")
    @ValueSource(ints = {0,1,2,3})
    void 랜덤_값이_4_미만일_경우_차량의_오프셋이_증가하지_않는다(Integer randomValue) {
        // given
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(randomValue);
        RacingCar racingCar = RacingCar.of("name");

        // when
        racingCar.move();

        // then
        assertThat(racingCar.getOffset()).isEqualTo(0);
    }

}
