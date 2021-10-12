package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    public void CarName은_이름을_가지고_있다() {
        String name = "정기";
        CarName carName = new CarName(name);
        Assertions.assertThat(carName.getName()).isEqualTo(name);
    }
}
