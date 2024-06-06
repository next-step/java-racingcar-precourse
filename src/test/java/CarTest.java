import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 테스트")
    public void carMove(){
        Car car = new Car("tesla");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름 테스트")
    public void carNameShouldBeValid() {
        assertThatThrownBy(() -> new Car("tesla model x"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }
}
