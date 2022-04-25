package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EnergyGeneratorTest {
    private EnergyGenerator energyGenerator;
    private final int MIN = 1;
    private final int MAX = 9;

    @BeforeEach
    void setUp() {
        energyGenerator = new EnergyGenerator(MIN, MAX);
    }

    @DisplayName("EnergyGenerator 는 생성 범위를 가지며 사용자 입력 숫자만큼 Energy 를 생성한다.")
    @Test
    public void createTest() {
        Energy createdEnergy = energyGenerator.create();
        assertThat(createdEnergy).isNotNull();
        assertThat(new Energy(MAX).compareTo(createdEnergy) >= 0).isTrue();
        assertThat(new Energy(MIN).compareTo(createdEnergy) <= 0).isTrue();
    }

    @DisplayName("생성범위는 잘못 입력시 에러 발생")
    @ParameterizedTest
    @CsvSource(value = {"9:1","-2:-9","2:2"}, delimiter = ':')
    public void invalidRange(final int rangeMin, final int rangeMax) {
        assertThatThrownBy(() -> new EnergyGenerator(rangeMin, rangeMax))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 초과한 Energy 를 생성시 에러를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,10})
    public void createInvalidRangeEnergy(final int mockReturnValue) {
        try (MockedStatic<Randoms> mockRandoms = Mockito.mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(MIN, MAX)).thenReturn(mockReturnValue);
            assertThatThrownBy(() -> energyGenerator.create()).isInstanceOf(IllegalStateException.class);
        }
    }

}
