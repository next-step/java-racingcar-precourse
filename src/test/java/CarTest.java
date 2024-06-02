import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void carShouldHaveInitialPositionZero() {
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void carShouldMoveForwardWhenConditionIsMet() {
        car.move();
        assertThat(car.getPosition()).isBetween(0, 1);
    }

    @Test
    void carShouldHaveName() {
        assertThat(car.getName()).isEqualTo("test");
    }

}