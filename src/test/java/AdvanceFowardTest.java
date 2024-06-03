import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdvanceFowardTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    public void testAdvanceForward() {
        // 초기 상태 설정
        Vector<Car> cars = new Vector<>();
        cars.add(new Car("car1", 0));
        cars.add(new Car("car2", 0));
        cars.add(new Car("car3", 0));

        AdvanceFoward.advanceFoward(cars);

        // 결과 검증
        for (Car car : cars) {
            assertTrue(car.getNumber() <= 5); // 시도 횟수보다 큰 수로 전진하지 않음을 확인
            assertTrue(car.getNumber() >= 0); // 0보다 작은 값을 가지지 않음을 확인
        }
    }
}
