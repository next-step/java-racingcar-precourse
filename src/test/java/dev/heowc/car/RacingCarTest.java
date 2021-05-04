package dev.heowc.car;

import dev.heowc.condition.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주차에 대해 테스트한다.")
class RacingCarTest {

    public static final Condition CONDITION = Condition.of(4);

    @DisplayName("이름의 길이가 " + RacingCar.NAME_LENGTH_LIMIT + " 이하만 생성할 수 있습니다.")
    @Test
    void successfulFrom() {
        final RacingCar car = RacingCar.from("abcde", CONDITION);

        assertThat(car).hasFieldOrPropertyWithValue("name", "abcde");
        assertThat(car).hasFieldOrPropertyWithValue("condition", Condition.of(4));
        assertThat(car).hasFieldOrPropertyWithValue("position", RacingCar.INIT_COUNT);
    }

    @DisplayName("이름이 비었으면 생성할 수 없습니다.")
    @Test
    void failureFrom() {
        final String name = null;

        assertThatThrownBy(() -> {
            RacingCar.from(name, CONDITION);
        }).isInstanceOf(NullPointerException.class).hasMessage("name is empty");
    }

    @DisplayName("이름의 길이가 " + RacingCar.NAME_LENGTH_LIMIT + " 초과면 생성할 수 없습니다.")
    @Test
    void failureFrom2() {
        final String name = "abcdef";

        assertThatThrownBy(() -> {
            RacingCar.from(name, CONDITION);
        }).isInstanceOf(LengthLimitExceededException.class)
        .hasMessage(String.format("길이를 %d를 넘을 수 없습니다. (입력값 길이: %d)",
                                    RacingCar.NAME_LENGTH_LIMIT, name.length()));
    }

    @DisplayName("조건에 따라 경주차는 전진/정지할 수 있습니다.")
    @ParameterizedTest
    @MethodSource("provideTryMoveMethodArguments")
    void tryMove(List<Condition> conditions, int expected) {
        final RacingCar car = RacingCar.from("abcde", CONDITION);
        for (Condition condition : conditions) {
            car.tryMove(condition);
        }
        assertThat(car).hasFieldOrPropertyWithValue("position", expected);
    }

    private static Stream<? extends Arguments> provideTryMoveMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Collections.emptyList(),
                        0
                ),
                Arguments.of(
                        Collections.singletonList(Condition.of(Condition.MIN)),
                        0
                ),
                Arguments.of(
                        Collections.singletonList(Condition.of(4)),
                        1
                ),
                Arguments.of(
                        Collections.singletonList(Condition.of(Condition.MAX)),
                        1
                ),
                Arguments.of(
                        Arrays.asList(Condition.of(Condition.MIN), Condition.of(Condition.MAX)),
                        1
                ),
                Arguments.of(
                        Arrays.asList(Condition.of(Condition.MIN), Condition.of(4), Condition.of(Condition.MAX)),
                        2
                ),
                Arguments.of(
                        Arrays.asList(Condition.of(Condition.MIN), Condition.of(3), Condition.of(Condition.MAX)),
                        1
                )
        );
    }
}