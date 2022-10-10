package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Winner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ViewUtilsTest {

    @DisplayName("자동차의 이동 위치에 따라 '-' 라인을 그린다.")
    @ParameterizedTest
    @CsvSource(value = {"3,---", "4,----"}, delimiter = ',')
    void drawLine(int number, String line) {
        assertThat(ViewUtils.drawLine(number)).isEqualTo(line);
    }

    @DisplayName("우승자를 찾아 이름을 출력한다.")
    @Test
    void printWinners() {
        List<Winner> winnerList = new ArrayList<>();
        winnerList.add(new Winner("car1"));
        winnerList.add(new Winner("car2"));

        assertThat(ViewUtils.printWinners(winnerList)).isEqualTo("car1, car2");
    }
}