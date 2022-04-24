package racingcar.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class RacingCarTest {

    private MockedStatic<Randoms> randomUtils;
    private RacingCar racingCar;


    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(new Car("phobi"));
    }

    @Test
    @DisplayName("레이싱카는 이름을 가지고 있는가")
    void has_name() {
        assertThat(racingCar.getName()).isNotNull();
    }

    @Test
    @DisplayName("레이싱카는 레이스를 할 수 있다: 전진하거나 혹은 멈출 수 있다.")
    void race() {
        randomUtils = mockStatic(Randoms.class);
        assertThat(RaceResult.values()).contains(racingCar.race());

        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        assertThat(racingCar.race()).isEqualTo(RaceResult.GO);

        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(3);
        assertThat(racingCar.race()).isEqualTo(RaceResult.STOP);
    }


}
