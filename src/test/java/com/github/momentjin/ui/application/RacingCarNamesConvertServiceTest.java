package com.github.momentjin.ui.application;

import com.github.momentjin.ui.RacingCarNameList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarNamesConvertServiceTest {

    private final RacingCarNamesConvertService service = new RacingCarNamesConvertService();

    @DisplayName("구분자 사이로 공백을 입력하면 모두 필터링 된다")
    @Test
    void convert1() {

        // given
        String delimiter = ",";
        String inputCarNames = "a,b,,c,,,,,d";

        // then
        RacingCarNameList racingCarNameList = service.convert(inputCarNames, delimiter);

        // then\
        assertThat(racingCarNameList.size()).isEqualTo(4);
        assertThat(racingCarNameList.get(0)).isEqualTo("a");
        assertThat(racingCarNameList.get(1)).isEqualTo("b");
        assertThat(racingCarNameList.get(2)).isEqualTo("c");
        assertThat(racingCarNameList.get(3)).isEqualTo("d");

    }

    @DisplayName("빈 값을 입력하면 IllegalArgumentException이 발생한다")
    @Test
    void convert2() {

        // given
        String inputCarNames = "";

        // when & then
        assertThatThrownBy(() -> service.convert(inputCarNames, ","))
                .isInstanceOf(IllegalArgumentException.class);
    }
}