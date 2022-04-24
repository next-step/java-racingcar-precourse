package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constants.NameMessage;
import racingcar.constants.RepeatMessage;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자: pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @ParameterizedTest(name = "사용자로부터 올바르지 않는 이름({0})을 입력")
    @ValueSource(strings = {"\n", " ", ",", "banana"})
    void inputInvalidFormatNamesByUser(String names) {
        assertSimpleTest(
                () -> {
                    runException(names);
                    assertThat(output()).containsAnyOf(NameMessage.EMPTY_INPUT_NAMES, NameMessage.INVALID_NAME_LENGTH);
                }
        );
    }

    @Test
    @DisplayName("사용자로부터 이름중에 5자를 넘어가는 이름을 포함해서 입력")
    void inputInclusionInvalidNameByUser() {
        assertSimpleTest(
                () -> {
                    runException("mond,banana,latte");
                    assertThat(output()).containsAnyOf(NameMessage.INVALID_NAME_LENGTH);
                }
        );
    }

    @ParameterizedTest(name = "사용자로부터 올바르지 않은 횟수({0})가 입력")
    @ValueSource(strings = {"mond", "-1", "0", "2147483648"})
    void inputInvalidRepeatNumberByUser(String repeatNumber) {
        assertSimpleTest(
                () -> {
                    runException("mond,bana,latte", repeatNumber);
                    assertThat(output()).containsAnyOf(RepeatMessage.INVALID_POSITIVE_NUMBER_FORMAT,
                            RepeatMessage.INVALID_NUMBER_RANGE);
                }
        );
    }

    @ParameterizedTest(name = "자동차 경주 게임 시작({3})")
    @MethodSource("provideRacingGameParameters")
    void startRacingGame(String names, String repeatNumber, List<Integer> moving, String champion) {
        assertRandomNumberInRangeTest(
                () -> {
                    run(names, repeatNumber);
                    assertThat(output()).contains(champion);
                },
                moving.get(0), moving.get(1)
        );
    }

    private static Stream<Arguments> provideRacingGameParameters() {
        Arguments testCase1 = Arguments.of(
                "mond,apple",
                "1",
                Arrays.asList(MOVING_FORWARD, MOVING_FORWARD),
                "최종 우승자: mond, apple"
        );

        Arguments testCase2 = Arguments.of(
                "mond,apple",
                "1",
                Arrays.asList(MOVING_FORWARD, STOP),
                "최종 우승자: mond"
        );

        Arguments testCase3 = Arguments.of(
                "mond,apple",
                "1",
                Arrays.asList(STOP, MOVING_FORWARD),
                "최종 우승자: apple"
        );

        return Stream.of(
                testCase1,
                testCase2,
                testCase3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
