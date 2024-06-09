package carRace;

import Model.Car;
import View.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class carRaceTest {

    public Car car;
    public Input input;

    @BeforeEach
    void setUp() {
        car = new Car("");
        car.setName("TEST");
    }

    // 초기화 테스트
    @Test
    void initializationTest() {
        car.setName("TEST");
        car.setDistance(3);
        assertThat(car.getName()).isEqualTo("TEST");
        assertThat(car.getDistance()).isEqualTo(3);
    }

    // 차량이동 테스트
    @Test
    void moveTest() {
        car.setName("TEST");
        car.setDistance(4);
        assertThat(car.toString()).isEqualTo("TEST : ----");
    }

    // 4 이상에서 전진하는지 테스트
    @Test
    void moveAboveFourTest() {
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);

        car.move(2);
        assertThat(car.getDistance()).isEqualTo(1);

        car.move(8);
        assertThat(car.getDistance()).isEqualTo(2);
    }

}
