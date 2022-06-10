package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("랜덤 1부터 9 사이의 숫자")
    void 랜덤_1부터_9_사이의_숫자() {
        // given
        // when
        // then
        final int i = Randoms.pickNumberInRange(1, 9);
        System.out.println("i = " + i);
    }

    @Test
    @DisplayName("자동차 이름 입력")
    void 자동차_이름_입력() {

        // given
        String names = "name1, name2, name3";

        // when
        String[] strings = nameSplit(names);

        // then
        System.out.println("strings = " + Arrays.toString(strings));
    }

    static String[] nameSplit(String name) {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        validateNameConvention(name);
        String[] split = name.replace(" ", "").split(",");
        System.out.println("split = " + split);

        for (int i = 0; i < split.length; i++) {
            try {
                validateNameLength(split[i]);
            } catch (IllegalArgumentException e) {
                nameSplit(name);
            }
        }
        return split;
    }

    static void validateNameConvention(String names) {
        if(!names.contains(",")) {
            throw new IllegalArgumentException("아니야");
        }
    }

    static void validateNameLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 넘길수 없다");
        }
    }

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
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
