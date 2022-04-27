package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Driven;

public class DrivenTest {
    
    @Test
    @DisplayName("거리 증가 테스트")
    void driven_add_test() {
        Driven driven = new Driven();

        driven.addDriven(1);
        driven.addDriven(1);
        driven.addDriven(1);
        driven.addDriven(1);
        driven.addDriven(1);

        assertThat(driven.getDriven()).isEqualTo(5);
    }
}
