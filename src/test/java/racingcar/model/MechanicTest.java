package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("model - Mechanic")
class MechanicTest {
    private Mechanic mechanic;
    private GameErrors gameErrors;

    @BeforeEach
    void setUp() {
        mechanic = new Mechanic();
        gameErrors = new GameErrors();
    }

    @DisplayName("레이싱카에 올바른 이름이 할당되는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"phobi,jun,jion", "nago", "nugu,1234,578,uni,una"})
    void initializing_cars_test(String racingCarName) {
        // Given
        int racingCarsNumber = racingCarName.split(",").length;

        // when
        mechanic.initializingCars(racingCarName, gameErrors);

        // Then
        assertThat(mechanic.racingCarCenter.getRacingCars().size()).isEqualTo(racingCarsNumber);
    }
}