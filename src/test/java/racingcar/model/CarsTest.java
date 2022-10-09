package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.utils.InputString;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {



    @Test
    void 자동차이름을_입력했을떄_최소_두대이상인가(){

        Cars cars = new Cars(new InputString("pobi,woni"));

        List<Car> list = cars.splitCars(cars);

        assertThat(list).hasSize(2);
    }

    @Test
    void 자동차이름을_입력했을떄_최소_두대미만이면_에러(){

        Cars cars = new Cars(new InputString("pobi"));

        try {
            List<Car> list = cars.splitCars(cars);
        }catch (IllegalArgumentException e) {
            assertThat(e).
                    isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최소 2대 이상 입력해야 합니다.");
        }
    }


}
