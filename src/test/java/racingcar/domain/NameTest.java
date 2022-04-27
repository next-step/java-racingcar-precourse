package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Name;

public class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    void name_generate_test() {
        Name name = new Name("hello");

        assertThat(name.getName()).isEqualTo("hello");
    }
}
