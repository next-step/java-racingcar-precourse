package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NameTest {
    private Name name;

    @BeforeEach
    public void setUp() {
        name = new Name("aaa");
    }
    @DisplayName("생성시 String 값을 받는다.")
    @Test
    public void create() {
        assertThat(name).isNotNull();
    }

    @DisplayName("Name class 는 VO 객체이다")
    @Test
    public void voTest() {
        assertThat(name).isEqualTo(new Name("aaa"));
        assertThat(new Name("b")).isNotEqualTo(name);
    }

    @DisplayName("String 출력")
    @Test
    public void toStringTest() {
        assertThat(name.toString()).isEqualTo("aaa").usingComparator(String::compareToIgnoreCase);
    }
}
