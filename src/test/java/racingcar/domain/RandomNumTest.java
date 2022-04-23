package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class RandomNumTest {
    private static final int RANDOM_START_NUM = 0;
    private static final int RANDOM_END_NUM = 9;

    @DisplayName("랜덤 숫자 4 이상 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6", "8"})
    void randomNumMoreTest(int num) {
        MockedStatic<Randoms> randomsMockedStatic = mockStatic(Randoms.class);
        randomsMockedStatic.when(() -> Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM)).thenReturn(num);
        RandomNum randomNum = RandomNum.generateRandomNum();
        randomsMockedStatic.close();
        assertThat(randomNum.isMoreNumber()).isTrue();
    }

    @DisplayName("랜덤 숫자 4 이하 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "2", "1"})
    void randomNumUnderTest(int num) {
        MockedStatic<Randoms> randomsMockedStatic = mockStatic(Randoms.class);
        randomsMockedStatic.when(() -> Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM)).thenReturn(num);
        RandomNum randomNum = RandomNum.generateRandomNum();
        randomsMockedStatic.close();
        assertThat(randomNum.isMoreNumber()).isFalse();
    }

    @DisplayName("랜덤 숫자 범위 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "11", "10", "100"})
    void randomNumRangeTest(int num) {
        MockedStatic<Randoms> randomsMockedStatic = mockStatic(Randoms.class);
        randomsMockedStatic.when(() -> Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM)).thenReturn(num);
        assertThatIllegalStateException()
                .isThrownBy(RandomNum::generateRandomNum);
        randomsMockedStatic.close();
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("랜덤 숫자 반복 범위 테스트")
    void ComputerRandomInitSizeTest() {
        RandomNum randomNum = RandomNum.generateRandomNum();
        assertThat(randomNum.getNumber() >= RANDOM_START_NUM || randomNum.getNumber() <= RANDOM_END_NUM).isTrue();
    }
}
