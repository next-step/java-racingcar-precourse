package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
    private static final Integer KEY_NAME = 1;
    private static final Integer KEY_FORWARD_COUNT = 2;
    private static final Integer KEY_FORWARD_STRING = 3;
    private static final Integer KEY_RANDOM_NUM = 4;
    private static final Integer KEY_ANSWER_FORWARD_COUNT = 5;
    private static final Integer KEY_ANSWER_FORWARD_STRING = 6;

    @DisplayName("여러 케이스 테스트")
    @ParameterizedTest
    @MethodSource(value = "testCaseProvider")
    void test(Map<Integer, Object> testCase) {
        Car car = new Car((Name) testCase.get(KEY_NAME), (ForwardCount) testCase.get(KEY_FORWARD_COUNT),
                (ForwardString) testCase.get(KEY_FORWARD_STRING));
        Integer randomNum = (Integer) testCase.get(KEY_RANDOM_NUM);
        car.setForwardResultByRandomNum(new RandomNum(randomNum));
        long answerForwardCount = (long) testCase.get(KEY_ANSWER_FORWARD_COUNT);
        String answerForwardString = (String) testCase.get(KEY_ANSWER_FORWARD_STRING);

        assertThat(car.getForwardCount().getCount()).isEqualTo(answerForwardCount);
        assertThat(car.getForwardString().getString()).isEqualTo(answerForwardString);
    }

    static List<Map<Integer, Object>> testCaseProvider() {
        List<Map<Integer, Object>> testCases = new ArrayList<>();
        testCases.add(newMap("전진1", 1L, "-", 4));
        testCases.add(newMap("전진2", 1L, "-", 5));
        testCases.add(newMap("전진3", 1L, "-", 6));
        testCases.add(newMap("전진4", 1L, "-", 7));
        testCases.add(newMap("전진5", 1L, "-", 9));
        testCases.add(newMap("멈춤1", 0L, "", 0));
        testCases.add(newMap("멈춤2", 0L, "", 1));
        testCases.add(newMap("멈춤3", 0L, "", 2));
        testCases.add(newMap("멈춤4", 0L, "", 3));
        return testCases;
    }

    static Map<Integer, Object> newMap(String carName, long answerForwardCount, String answerForwardString,
                                       int randomNum) {
        Map<Integer, Object> m = new HashMap<>();
        m.put(KEY_NAME, new Name(carName));
        m.put(KEY_FORWARD_COUNT, new ForwardCount());
        m.put(KEY_FORWARD_STRING, new ForwardString());
        m.put(KEY_RANDOM_NUM, randomNum);
        m.put(KEY_ANSWER_FORWARD_COUNT, answerForwardCount);
        m.put(KEY_ANSWER_FORWARD_STRING, answerForwardString);
        return m;
    }
}