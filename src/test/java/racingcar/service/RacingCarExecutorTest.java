package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarExecutorTest {

    @DisplayName("정상 실행")
    @Test
    void success() {
        var executor = new RacingCarExecutor(new String[] {"foo", "bar"});
        assertThat(executor.getWinner())
                .hasSize(2)
                .extracting("name", "location")
                .contains(tuple("foo", 0), tuple("bar", 0));

        for (int i=0; i<5; i++) {
            executor.execute();
        }

        assertThat(executor.getWinner())
                .hasSizeGreaterThanOrEqualTo(1)
                .extracting("location")
                .doesNotContain(0);
    }

    @DisplayName("경주차량이 비어있음")
    @Test
    void failed1() {
        assertThatThrownBy(() -> {
            var executor = new RacingCarExecutor(List.of());
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("racing car list is empty");
    }

    @DisplayName("경주차량이 비어있음")
    @Test
    void failed2() {
        assertThatThrownBy(() -> {
            var executor = new RacingCarExecutor(new String[] {""});
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong car name");
    }

    @DisplayName("경주차량이 비어있음")
    @Test
    void failed3() {
        assertThatThrownBy(() -> {
            var executor = new RacingCarExecutor(new String[] {" "});
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong car name");
    }
}