package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ExceptionMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private final static int testRepeat = 1000;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("3라운드 - 3명 참여 - 단독 우승 ( 1. ( 전진, 스톱, 전진 ), 2. ( 전진, 전진, 전진 ), 3. ( 스톱, 스톱, 전진 ) )")
    void racing_game_three_round_three_join_solo_win_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,bio", "3");
                    assertThat(output()).contains(
                            "pobi : -", "pobi : --",
                            "woni : -", "woni : --", "woni : ---",
                            "bio : ", "bio : -",
                            "최종 우승자 : woni"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("3라운드 - 3명 참여 - 2명 공동 우승 ( 1. ( 전진, 스톱, 전진 ), 2. ( 전진, 전진, 전진 ), 3. ( 전진, 전진, 전진 ) )")
    void racing_game_three_round_three_join_double_win_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,bio", "3");
                    assertThat(output()).contains(
                            "pobi : -", "pobi : --",
                            "woni : -", "woni : --", "woni : ---",
                            "bio : -", "bio : --", "bio : ---",
                            "최종 우승자 : woni, bio"
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Test
    @DisplayName("3라운드 - 3명 참여 - 3명 전부 우승 ( 1. ( 스톱, 스톱, 전진 ), 2. ( 스톱, 전진, 스톱 ), 3. ( 전진, 스톱, 스톱 ) )")
    void racing_game_three_round_three_join_three_win_test() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,bio", "3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : -",
                            "bio : -",
                            "최종 우승자 : pobi, woni, bio"
                    );
                },
                STOP, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP
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

    @DisplayName("[레이싱 카 이름] - 특수문자에 대한 예외 처리 ( 빈문자값 포함 ) ")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", " ", "phob!", "@bio", "phobi, bio"})
    void car_name_special_character_exception_test(String carName) {
        assertSimpleTest(
                () -> {
                    runException(carName);
                    assertThat(output()).contains(ExceptionMessage.CONTAIN_SPECIAL_CHARACTER_EXCEPTION_MESSAGE);
                }
        );
    }

    @DisplayName("[레이싱 카 이름] - 5글자 초과한 이름에 대한 예외 처리")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"123456", "phobia", "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"})
    void car_name_length_exception_test(String carName) {
        // Then
        assertSimpleTest(
                () -> {
                    runException(carName);
                    assertThat(output()).contains(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
                }
        );
    }

    @DisplayName("[라운드 넘버] - 숫자를 제외한 문자에 대한 예외 처리")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"~@123", "phobia"})
    void round_not_contain_only_number_exception_test(String roundNumber) {
        // Given
        String carName;

        // When
        carName = "phobi,bio";

        // Then
        assertSimpleTest(
                () -> {
                    runException(carName, roundNumber);
                    assertThat(output()).contains(ExceptionMessage.NOT_CONTAIN_ONLY_NUMBER_EXCEPTION_MESSAGE);
                }
        );
    }

    @DisplayName("[라운드 넘버] - 1000라운드를 초과하는 경우에 대한 예외 처리")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"1001", "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"})
    void max_round_length_exception_test(String roundNumber) {
        // Given
        String carName;

        // When
        carName = "phobi,bio";

        // Then
        assertSimpleTest(
                () -> {
                    runException(carName, roundNumber);
                    assertThat(output()).contains(ExceptionMessage.MAX_ROUND_NUMBER_EXCEPTION_MESSAGE);
                }
        );
    }

    @DisplayName("[라운드 넘버] - 1라운드 미만인 경우에 대한 예외 처리")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"0"})
    void min_round_length_exception_test(String roundNumber) {
        // Given
        String carName;

        // When
        carName = "phobi,bio";

        // Then
        assertSimpleTest(
                () -> {
                    runException(carName, roundNumber);
                    assertThat(output()).contains(ExceptionMessage.MIN_ROUND_NUMBER_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("[레이싱 카] - 할당 가능한 레이싱카 초과할 경우 예외 처리")
    void racing_car_max_size_exception_test() {
        // Given
        StringBuilder stringBuilder = new StringBuilder();

        // When
        for (int i = 0; i < testRepeat; i++) {
            stringBuilder.append("A,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);

        // Then
        assertSimpleTest(
                () -> {
                    runException(stringBuilder.toString(), "1");
                    assertThat(output()).contains(ExceptionMessage.RACING_CAR_MAX_SIZE_EXCEPTION_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("[레이싱 카] - 레이싱카가 중복된 이름을 가질 경우 예외 처리")
    void racing_car_duplication_name_exception_test() {
        // Given
        String carName;

        // When
        carName = "phobi,phobi";

        // Then
        assertSimpleTest(
                () -> {
                    runException(carName, "1");
                    assertThat(output()).contains(ExceptionMessage.RACING_CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
