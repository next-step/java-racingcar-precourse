import Model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private final Car car = new Car("car");

    @Test
    @DisplayName("move() 메서드 정상작동 검사")
    void moveTest(){
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        //move() 5번 호출 시 car.getProgress()의 값은 5
        assertThat(car.getProgress()).isEqualTo(5);
    }
}
