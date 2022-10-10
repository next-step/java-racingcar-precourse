package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EntryTest {

    @Test
    @DisplayName("자동차 이름 중복 확인")
    void 자동차_이름_중복_확인() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        assertThat(Entry.checkDuplication(cars)).isTrue();
        cars.add(new Car("woni"));
        assertThat(Entry.checkDuplication(cars)).isTrue();
        cars.add(new Car("pobi"));
        assertThat(Entry.checkDuplication(cars)).isFalse();
    }

    @Test
    @DisplayName("자동차 이름 중복 시 예외처리")
    void 자동차_이름_중복_예외처리() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("pobi"));
        assertThatThrownBy(() -> {
            new Entry(cars);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
