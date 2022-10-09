package racingcar.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 컬렉션 관련 기능")
class EntryTest {
    public static Stream<Arguments> winnerArguments() {
        return Stream.of(
                Arguments.of(Entry.from("car1,car2,car3"), new Boolean[]{true, false, false}, new String[]{"car1"}),
                Arguments.of(Entry.from("car1,car2,car3"), new Boolean[]{true, false, true}, new String[]{"car1", "car3"}));
    }

    @DisplayName("1대 이상 자동차 컬렉션을 생성한다.")
    @ParameterizedTest
    @CsvSource({"'car1',1", "'car1,car2',2"})
    void create(String carNames, int expectedSize) {
        // when
        Entry entry = Entry.from(carNames);

        // then
        assertThat(entry).extracting("cars")
                .asList()
                .hasSize(expectedSize);
    }

    @DisplayName("유효하지 않은 이름으로 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {",", ",car1", "car1,", "car1,car1", "car123"})
    void duplicate(String carNames) {
        // when
        ThrowingCallable throwingCallable = () -> Entry.from(carNames);

        // then
        assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전체 자동차가 1회 경주한다.")
    @Test
    void race() {
        // given
        Entry entry = Entry.from("car1,car2,car3");
        Movement movement = new LinkedList<>(Arrays.asList(true, false, true))::poll;

        // when
        List<String> carPositions = entry.race(movement);

        // then
        assertThat(carPositions).containsExactly("car1 : -", "car2 : ", "car3 : -");
    }

    @DisplayName("우승자를 확인한다.")
    @ParameterizedTest
    @MethodSource("winnerArguments")
    void winners(Entry entry, Boolean[] movements, String[] expected) {
        // given
        Movement movement = new LinkedList<>(Arrays.asList(movements))::poll;
        entry.race(movement);

        // when
        List<String> winners = entry.winners();

        // then
        assertThat(winners).containsExactly(expected);
    }
}
