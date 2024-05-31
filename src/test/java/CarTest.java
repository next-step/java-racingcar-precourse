import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("목적: 자동차 이름이 5자를 초과할 경우 IllegalArgumentException 예외가 발생하는지 확인.")
    public void carNameShouldNotExceedFiveCharacters() {
        assertThatThrownBy(() -> new Car("sixletters"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("목적: 무작위 값이 4 이상일 때 자동차가 전진하는지 확인.")
    public void carShouldMoveWhenRandomValueIsFourOrGreater() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("목적: 무작위 값이 4 미만일 때 자동차가 움직이지 않는지 확인.")
    public void carShouldNotMoveWhenRandomValueIsLessThanFour() {
        Car car = new Car("test");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("목적: 자동차의 이름이 올바르게 반환되는지 확인.")
    public void carNameShouldBeReturnedCorrectly() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
    }
}
