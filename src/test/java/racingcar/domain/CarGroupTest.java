package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarGroupTest {
    @Test
    @DisplayName("중복되지않은 자동차 이름 입력")
    void nonDuplicateCarName(){
        List<Car> cars = Arrays.asList(
            new Car("ara"),
            new Car("minoo"),
            new Car("tobi")
        );

        assertThat(new CarGroup(cars)).isNotNull();
    }

    @Test
    @DisplayName("중복된 자동차 이름 입력")
    void duplicateCarName(){
        List<Car> cars = Arrays.asList(
                new Car("ara"),
                new Car("ara"),
                new Car("tobi")
        );

        try {
            CarGroup carGroup = new CarGroup(cars);
        }catch (Exception E){
            assertThat(E).isEqualTo(IllegalArgumentException.class);
        }
//        assertThatIllegalArgumentException().isThrownBy(()->new CarGroup(cars));
    }
}
