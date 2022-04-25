package racingcar.attendgroup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AttendGroupTest {
    @ParameterizedTest
    @DisplayName("참가 그룹 생성 테스트")
    @ValueSource(strings = {"a,b,c", "a", "b,c", "aa,aa"})
    void 참가_그룹_생성_정상_테스트(String input) {
        String[] attendCars = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String car : attendCars) {
            cars.add(new Car(car));
        }
        AttendGroup attendGroup = new AttendGroup(cars);
        assertThat(attendGroup.getAttendCarList().size()).isEqualTo(cars.size());
    }

    @ParameterizedTest
    @DisplayName("참가 그룹 생성 비정상 테스트")
    @ValueSource(strings = {",", ",,", ""})
    void 참가_그룹_생성_비정상_테스트(String input) {
        assertThatThrownBy(() -> {
            String[] attendCars = input.split(",");
            List<Car> cars = new ArrayList<>();
            for (String car : attendCars) {
                cars.add(new Car(car));
            }
            AttendGroup attendGroup = new AttendGroup(cars);
        }).isInstanceOfAny(IllegalStateException.class, IllegalArgumentException.class);
    }
}
