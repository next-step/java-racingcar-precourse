package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @DisplayName("Name은 5자 이하의 값을 갖는다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "weno"})
    void construct_valid(String source){
        Name name = new Name(source);
        assertThat(name).isEqualTo(new Name(source));
    }

    @DisplayName("Name은 6자 이상의 값을 입력받으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiabc", "wenoabc"})
    void construct_invalid(String source){
        assertThatThrownBy(() -> {
            new Name(source);
        }).isInstanceOf(NoSuchElementException.class);
    }
}
