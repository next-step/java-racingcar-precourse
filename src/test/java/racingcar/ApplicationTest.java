package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    static class generateWinnerTestCase {
        public String description;
        public HashMap<String, Integer> car;
        public String winner;
    }

    @Test
    void 최종우승자_출력_테스트() {
        generateWinnerTestCase[] tests = new generateWinnerTestCase[]{
            new generateWinnerTestCase() {
                {
                    description = "pobi, woni 우승";
                    car = new HashMap<>();
                    car.put("pobi", 2);
                    car.put("woni", 2);
                    winner = "pobi, woni";
                }
            },
            new generateWinnerTestCase() {
                {
                    description = "pobi 우승";
                    car = new HashMap<>();
                    car.put("pobi", 2);
                    car.put("woni", 1);
                    winner = "pobi";
                }
            },
            new generateWinnerTestCase() {
                {
                    description = "woni 우승";
                    car = new HashMap<>();
                    car.put("pobi", 1);
                    car.put("woni", 2);
                    winner = "woni";
                }
            },
            new generateWinnerTestCase() {
                {
                    description = "pobi, woni 우승";
                    car = new HashMap<>();
                    car.put("pobi", 0);
                    car.put("woni", 0);
                    winner = "pobi, woni";
                }
            },
        };

        Application.RacingCarGameModel racingCarGameModel = new Application.RacingCarGameModel();

        for (generateWinnerTestCase test : tests) {
            String winner = racingCarGameModel.generateWinner(test.car);

            assertEquals(winner, test.winner, test.description);
        }
    }

    @Test
    void 자동차이름_중복체크_테스트() {
        for (String[] testCase : new String[][]{
            {"pobi", "pobi"},
            {"pobi", "pobi", "woni"},
            {"pobi", "crong", "honux", "pobi"},
            {"jun", "jun"},
        }
        ) {
            assertThatIllegalArgumentException().isThrownBy(() -> Application.Utils.checkDuplicateCarName(testCase));
        }
    }

    @Test
    void 자동차이름_길이검증_테스트() {
        for (String[] testCase : new String[][]{
            {"hannah", "pobi"},
            {"pobi", "pororo", "woni"},
            {"pobi", "crong", "honux", "christina"},
            {"joannes", "jun"},
        }
        ) {
            assertThatIllegalArgumentException().isThrownBy(() -> Application.Utils.checkCarNameLength(testCase));
        }
    }

    static class isContainCommaTestCase {
        public String description;
        public String given;
        public String[] want;
    }

    @Test
    void 자동차이름_콤마포함여부확인_테스트() {
        isContainCommaTestCase[] tests = new isContainCommaTestCase[]{
            new isContainCommaTestCase() {
                {
                    description = "pobi,woni";
                    given = "pobi,woni";
                    want = new String[]{"pobi", "woni"};
                }
            },
            new isContainCommaTestCase() {
                {
                    description = "hannah,christina,joannes";
                    given = "hannah,christina,joannes";
                    want = new String[]{"hannah", "christina", "joannes"};
                }
            },
        };

        for (isContainCommaTestCase test : tests) {
            for (int i = 0; i < test.want.length; i++) {
                assertEquals(test.want[i], Application.Utils.isContainComma(test.given)[i], test.description);
            }
        }

        for (String testCase : Arrays.asList("pobi woni", "pobiwoni woni")) {
            assertThatIllegalArgumentException().isThrownBy(() -> Application.Utils.isContainComma(testCase));
        }
    }

    static class isNumberTestCase {
        public String description;
        public String given;
        public boolean want;
    }

    @Test
    void 정수파싱_테스트() {
        isNumberTestCase[] tests = new isNumberTestCase[]{
            new isNumberTestCase() {
                {
                    description = "양수 파싱 테스트";
                    given = "12345";
                    want = true;
                }
            },
            new isNumberTestCase() {
                {
                    description = "음수 파싱 테스트";
                    given = "-12345";
                    want = true;
                }
            },
        };

        for (isNumberTestCase test : tests) {
            assertEquals(test.want, Application.Utils.isNumber(test.given), test.description);
        }

        for (String testCase : Arrays.asList("number", "hannah", "christina", "joannes")) {
            assertThatIllegalArgumentException().isThrownBy(() -> Application.Utils.isNumber(testCase));
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
