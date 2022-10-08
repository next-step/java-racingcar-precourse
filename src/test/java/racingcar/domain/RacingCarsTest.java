package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

class RacingCarsTest {

    private static MockedStatic<Randoms> randomsMock;

    @BeforeAll
    static void before() {
        randomsMock = mockStatic(Randoms.class);
    }

    @AfterAll
    static void after() {
        randomsMock.close();
    }

    @ParameterizedTest
    @MethodSource("getDuplicateNames")
    @DisplayName("차량의 이름들중 중복이 있을 경우 에러가 발생된다")
    void 차량의_이름들중_중복이_있을_경우_에러가_발생된다(List<String> carNames) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.of(carNames))
                .withMessage("[ERROR] 동일한 이름의 차량을 등록할 수 없습니다");
    }

    @ParameterizedTest
    @MethodSource("getOnlyOneName")
    @DisplayName("차량의 이름이 1개 이하일 경우 에러가 발생된다")
    void 차량의_이름이_1개_이하일_경우_에러가_발생된다(List<String> carNames) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.of(carNames))
                .withMessage("[ERROR] 차량을 1대이하로 등록할 수 없습니다");
    }

    @ParameterizedTest
    @MethodSource("getNames")
    @DisplayName("차량의 이름들이 모두 정상적일 경우 정상적으로 생성되어야 한다")
    void 차량의_이름들이_모두_정상적일_경우_정상적으로_생성되어야_한다(List<String> carNames) {

        // when
        RacingCars racingCars = RacingCars.of(carNames);

        // then
        assertThat(racingCars.getCars()).hasSize(carNames.size());
    }

    @Test
    @DisplayName("각 차량의 이동 회술르 비교하여 가장 높은 이동 회수 차량이 2개 이상이면 쉼표로 구분하여 반환해야 한다")
    void 각_차량의_이동_회수를_비교하여_가장_높은_이동_회수_차량이_2개_이상이면_쉼표로_구분하여_반환해야한다() {
        // given
        when(Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        RacingCars racingCars = RacingCars.of(Arrays.asList("aa", "bb"));
        racingCars.moveAll();

        // when
        String winnersName = racingCars.getWinnersName();

        // then
        assertThat(winnersName).isEqualTo("aa, bb");
    }

    private static List<Arguments> getDuplicateNames() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(arguments(Arrays.asList("aa", "aa")));
        arguments.add(arguments(Arrays.asList("aa", "bb", "aa")));
        arguments.add(arguments(Arrays.asList("cc", "ca", "ab", "aa", "cc")));
        return arguments;
    }

    private static List<Arguments> getOnlyOneName() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(arguments(Collections.singletonList("aa")));
        arguments.add(arguments(Collections.singletonList("bb")));
        arguments.add(arguments(Collections.singletonList("cc")));
        return arguments;
    }

    private static List<Arguments> getNames() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(arguments(Arrays.asList("aa", "bb")));
        arguments.add(arguments(Arrays.asList("aa", "bb", "cc")));
        arguments.add(arguments(Arrays.asList("aa", "bb", "cc", "dd")));
        return arguments;
    }
}
