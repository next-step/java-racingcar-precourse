package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.firstcollections.Positive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositiveTest {

    @Test
    @DisplayName("기본 생성자 생성")
    void get() {
        Positive p = new Positive();
        assertThat(p.get()).isEqualTo(0L);
    }

    @Test
    @DisplayName("음수 값 입력 생성")
    void get2() {
        assertThrows(IllegalArgumentException.class, () -> new Positive(-1));
    }

    @Test
    @DisplayName("문자열 값 입력 생성")
    void get3() {
        Positive p = new Positive("1");
        assertThat(p.get()).isEqualTo(1L);
    }

    @Test
    @DisplayName("잘못된 문자열 값 입력 생성")
    void get4() {
        assertThrows(IllegalArgumentException.class, () -> {
            Positive p = new Positive("-1");
        });
    }

    @Test
    @DisplayName("더하기 테스트")
    void add() {
        Positive p = new Positive("100");
        p.add();
        assertThat(p.get()).isEqualTo(101);
    }

    @Test
    @DisplayName("0에서 빼기 테스트")
    void sub() {
        Positive p = new Positive(0);
        p.sub();
        assertThat(p.get()).isEqualTo(0);
    }

    @Test
    @DisplayName("1에서 빼기 테스트")
    void sub2() {
        Positive p = new Positive(1);
        p.sub();
        assertThat(p.get()).isEqualTo(0);
    }
}