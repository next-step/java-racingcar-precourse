package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class CarEntryTest {
    @Test
    @DisplayName("엔트리에 출발 차량이 정상적으로 있는 경우")
    void createCarTest() {
        Car car1 = new Car("test",0);
        Car car2 = new Car("java",0);
        CarEntry carEntry = new CarEntry(Arrays.asList(car1, car2));
        assertThat(carEntry.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("엔트리에 차량이 없을 경우")
    void createCarTestWithInvalidEntry() {
        ThrowingCallable emptyEntry = () -> new CarEntry(Collections.emptyList());
        assertThatThrownBy(emptyEntry).isInstanceOf(IllegalArgumentException.class);
    }

}
