package dev.heowc.car;

import dev.heowc.condition.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("경주차들의 우승 그룹에 대해 테스트한다.")
class WinnerGroupTest {

    public static final Condition CONDITION = Condition.of(0);

    @DisplayName("모두 움직이지 않은 그룹에 대해서는 모두가 우승이다.")
    @Test
    void notMove() {
        final RacingCarGroup group = RacingCarGroup.create("a,b,c", CONDITION);
        final WinnerGroup winnerGroup = WinnerGroup.create(group);
        assertThat(winnerGroup.names()).isEqualTo("a, b, c");
    }

    @DisplayName("하나의 경주차만 전진하면 그룹에서 움직인 하나의 경주차만 우승이다.")
    @ParameterizedTest
    @CsvSource(
            delimiter = '|',
            value = {
                    "a,b,c|0|a",
                    "a,b,c|1|b",
                    "a,b,c|2|c"
            }
    )
    void onlyOneCarMove(String carNames, int index, String expected) {
        final RacingCarGroup group = RacingCarGroup.create(carNames, CONDITION);
        group.cars().get(index).tryMove(Condition.of(9));

        final WinnerGroup winnerGroup = WinnerGroup.create(group);

        assertThat(winnerGroup.names()).isEqualTo(expected);
    }

    @DisplayName("두 경주차가 전진하면 그룹에서 움직인 두 경주차만 우승이다.")
    @ParameterizedTest
    @CsvSource(
            delimiter = '|',
            value = {
                    "a,b,c|0|0|a",
                    "a,b,c|1|1|b",
                    "a,b,c|2|2|c",
                    "a,b,c|0|1|a, b",
                    "a,b,c|1|2|b, c",
                    "a,b,c|2|0|a, c"
            }
    )
    void onlyTwoCarMove(String carNames, int firstIndex, int secondIndex, String expected) {
        final RacingCarGroup group = RacingCarGroup.create(carNames, CONDITION);
        group.cars().get(firstIndex).tryMove(Condition.of(9));
        group.cars().get(secondIndex).tryMove(Condition.of(9));

        final WinnerGroup winnerGroup = WinnerGroup.create(group);

        assertThat(winnerGroup.names()).isEqualTo(expected);
    }
}