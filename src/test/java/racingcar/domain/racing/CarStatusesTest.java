package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.domain.Fixtures.carStatusesOf;
import static racingcar.domain.Fixtures.createCarStatus;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Distance;

class CarStatusesTest {
    @ParameterizedTest(name = "자동차 현재 상태 목록은 null이 아니어야 한다.")
    @NullSource
    void carStatusListShouldNotBeNull(List<CarStatus> elements) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarStatuses(elements))
                .withMessage("The car status list should not be null!");
    }

    @DisplayName("가지고 있는 요소들이 같으면 동일하다.")
    @Test
    void equality() {
        final CarStatuses one = carStatusesOf(2, "pobi", "crong");
        final CarStatuses another = carStatusesOf(2, "pobi", "crong");

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("자동차 현재 상태 리스트를 받을 수 있다.")
    @Test
    void toList() {
        final CarStatuses statuses = carStatusesOf(1, "a", "b");
        final List<CarStatus> expected = Arrays.asList(
                new CarStatus(new CarName("a"), new Distance(1)),
                new CarStatus(new CarName("b"), new Distance(1))
        );

        final List<CarStatus> actual = statuses.toList();

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @DisplayName("현재 위치가 가장 높은 자동차 상태만을 받을 수 있다.")
    @Test
    void filterHighestDistanceStatuses() {
        final List<CarStatus> carStatusList = Arrays.asList(
                createCarStatus("aWin", 4),
                createCarStatus("bLose", 2),
                createCarStatus("cLose", 0),
                createCarStatus("dWin", 4)
        );
        final CarStatuses carStatuses = new CarStatuses(carStatusList);
        final List<CarStatus> expected = Arrays.asList(
                createCarStatus("aWin", 4),
                createCarStatus("dWin", 4)
        );

        final CarStatuses actual = carStatuses.filterHighestDistanceCars();

        assertThat(actual.toList()).containsExactlyInAnyOrderElementsOf(expected);
    }
}
