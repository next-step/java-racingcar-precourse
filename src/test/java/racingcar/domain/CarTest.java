package racingcar.domain;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;


public class CarTest {
    @ParameterizedTest(name = "Car play execute => given {0} is return : {1}")
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    void car_play_execute(String input, boolean expected) {
        Car car = new Car("name");
        int expect = Integer.parseInt(input);
        MockedStatic<Randoms> mockUtils = mockStatic(Randoms.class);
        given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(expect);
        Assertions.assertThat(car.play()).isEqualTo(expected);
        mockUtils.close();
    }
}
