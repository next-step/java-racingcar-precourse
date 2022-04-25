package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PositionTest {
    private Position zero;
    @BeforeEach
    public void setUp() {
        zero = new Position(0);
    }
    @DisplayName("Position 는 VO 객체다")
    @Test
    public void createTest() {
        assertThat(zero).isEqualTo(new Position(0));
        assertThat(zero).isNotEqualTo(new Position(1));
    }

    @DisplayName("move 호출시 입력한 정보에 따라 새로운 Position 객체를 리턴한다")
    @Test
    public void moveTest() {
        assertThat(zero.move(0)).isEqualTo(zero);
        Position one = zero.move(1);
        assertThat(one).isEqualTo(new Position(1));
        Position two = one.move(1);
        assertThat(two).isEqualTo(new Position(2));
    }

    @DisplayName("String 출력시 distance 크기 맞게 막대기로 출력한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "0:"}, delimiter=':')
    public void printTest(final int dist, String expectedStr) {
        if (dist == 0) expectedStr = "";
        assertThat(new Position(dist).toString()).isEqualTo(expectedStr).usingComparator(String::compareTo);
    }

    @DisplayName("비교 테스트")
    @Test
    public void compare() {
        assertThat(zero.compareTo(new Position(1)) < 0).isTrue();
    }

    @DisplayName("Comapre 시 입력값은 null 이 되면 안된다.")
    @Test
    public void invalidCompare() {
        assertThatThrownBy(() -> zero.compareTo(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
