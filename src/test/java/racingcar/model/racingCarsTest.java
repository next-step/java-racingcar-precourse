package racingcar.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class racingCarsTest {
    @Test
    void 자동차_여러대_사이즈_테스트(){
        racingCar car = new racingCar(new racingcarName("pobi"));
        racingCar car2 = new racingCar(new racingcarName("qwer"));
        racingCars cars = new racingCars(Arrays.asList(car,car2));
        assertThat(cars.getCars().size()).isEqualTo(2);
    }
    @Test
    void 자동차_여러대_길이_제한_5이상() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                new racingCars(Arrays.asList(new racingCar(new racingcarName("pobiiii")),new racingCar(new racingcarName("qwerrrrr")))));
        assertEquals("[ERROR] 자동차 이름의 길이가 5를 넘었습니다.", e.getMessage());
    }
    @Test
    void 자동차이름_여러대_길이_제한_0이하() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                new racingCars(Arrays.asList(new racingCar(new racingcarName("pobi")),new racingCar(new racingcarName("")))));
        assertEquals("[ERROR] 자동차 이름을 입력하지 않았습니다.", e.getMessage());
    }

}
