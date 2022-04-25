package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    @DisplayName("여러개의 Name으로 구성된다.")
    @Test
    void construct(){
        Names names = new Names(Arrays.asList(new Name("pobi"), new Name("weno")));

        assertThat(names).isNotNull();
    }
}
