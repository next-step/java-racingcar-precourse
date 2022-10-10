package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Cars.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.rule.GoStopRule;

class CarsTest {
    @Test
    void String_List_입력받아_Car_List_멤버변수_초기화() {
        Cars cars = new Cars(Arrays.asList("yubi", "zozo", "son", "yeopo"));
        assertThat(cars.getSize()).isEqualTo(4);
    }

    @Test
    void 자동차이름_중복발생시_예외처리() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("yubi", "yubi")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INPUT_ERROR_CAR_NAME_DUPLICATE);
    }

    @Test
    void 우승자가_한명인_경우() {
        Cars cars = new Cars(Arrays.asList("yubi", "zozo", "yeopo"));
        GoStopRule rule = new GoStopRule(cars.getSize());
        rule.determineGoStop(0, 4);
        rule.determineGoStop(1, 0);
        rule.determineGoStop(2, 0);
        cars.process(rule);
        cars.process(rule);
        cars.process(rule);

        Distance maxDistance = cars.getMaxDistance();
        assertThat(maxDistance.get()).isEqualTo(3);
        List<Name> names = cars.getNames(maxDistance);
        assertThat(names).hasSize(1);
        assertThat(names.get(0).getNameString()).isEqualTo("yubi");
    }

    @Test
    void 우승자가_복수인_경우() {
        Cars cars = new Cars(Arrays.asList("yubi", "zozo", "yeopo"));
        GoStopRule rule = new GoStopRule(cars.getSize());
        rule.determineGoStop(0, 4);
        rule.determineGoStop(1, 4);
        rule.determineGoStop(2, 0);
        cars.process(rule);
        cars.process(rule);
        cars.process(rule);

        Distance maxDistance = cars.getMaxDistance();
        assertThat(maxDistance.get()).isEqualTo(3);
        List<Name> names = cars.getNames(maxDistance);
        assertThat(names).hasSize(2);
        for (Name name : names) {
            assertThat(Arrays.asList("yubi", "zozo")).contains(name.getNameString());
        }
    }
}