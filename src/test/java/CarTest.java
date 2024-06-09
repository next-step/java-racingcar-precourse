
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {
    @Test
    public void carNameShouldNotExceedFiveCharacters() {
            assertThatThrownBy(() -> new Car("sixletters"))
                    .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test

    }
}
