package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.entity.CarEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarEntityTest {

    @Test
    public void newCarEntityTest() {
        String name = "car";
        CarEntity car = new CarEntity(name);
        assertThat(car.getName()).contains(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void setCarPosition() {
        String name = "car";
        int pos = 10;
        CarEntity car = new CarEntity(name);
        car.setPosition(pos);
        assertThat(car.getPosition()).isEqualTo(pos);
    }

    @Test
    public void setCarPositionMinusTest() {
        String name = "car";
        int pos = -10;
        CarEntity car = new CarEntity(name);

        assertThatThrownBy(() -> { car.setPosition(pos); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 위치값이 음수입니다.");
    }

    @Test
    public void setCarNameLengthTest() {
        String name = "car123";
        assertThatThrownBy(() -> { new CarEntity(name); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름의 길이는 5자 이하만 가능합니다.");
    }
    @Test
    public void setCarNameNullTest() {
        assertThatThrownBy(() -> { new CarEntity(null); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 문자열이 null 입니다.");
    }


}
