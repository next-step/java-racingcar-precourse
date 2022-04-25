package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

public class CarsTest {
    private Cars cars;
    private final String[] carNames = {"pobi", "crong"};

    @BeforeEach
    public void setUp() {
        cars = new Cars(getCarArrayBy(carNames));
    }

    @DisplayName("Cars 는 Car Array 를 입력받는다.")
    @Test
    public void creatCars() {
        assertThat(cars).isNotNull();
        assertThat(cars.isNumberOfParticipants(carNames.length)).isTrue();
    }

    private Car[] getCarArrayBy(String... name) {
        Car[] cars = new Car[name.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(new Name(name[i]), new Energy(3), new Position(0));
        }
        return cars;
    }

    @DisplayName("EnergyGenerator 를 인자로 받고 Car Array 크기 만큼 create 메소드를 호출한다.")
    @Test
    public void play() {
        EnergyGenerator spyGenerator = spy(new EnergyGenerator(1, 9));
        cars.play(spyGenerator);
        verify(spyGenerator, times(carNames.length)).create();
    }

    @DisplayName("play 함수에서 Generator 가 null 이면 에러를 발생한다.")
    @Test
    public void playInvalidParam() {
        assertThatThrownBy(() -> cars.play(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("winner 함수는 우승자 또는 우승자들의 Car 을 넘겨준다.")
    @ParameterizedTest
    @MethodSource("provideCarsAndWinners")
    public void winner(final Cars cars , final String[] names) {
        Name[] winners = cars.winner();
        Name[] expectedNames = createNameBy(names);
        assertThat(winners.length).isEqualTo(expectedNames.length);
        assertThat(winners).contains(expectedNames);
    }

    @DisplayName("car 정보가 없는 상태에서 winner 호출시 에러를 발생한다.")
    @Test
    public void invalidState() {
        Cars cars = new Cars();
        assertThatThrownBy(cars::winner).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    private static Stream<Arguments> provideCarsAndWinners() {
        return Stream.of(
            Arguments.of(createCars(new String[]{"pobi", "crong", "honux"}, new int[] {1,2,3}),new String[]{"honux"}),
            Arguments.of(createCars(new String[]{"pobi", "crong", "honux"}, new int[] {1,3,1}),new String[]{"crong"}),
            Arguments.of(createCars(new String[]{"pobi", "crong", "honux"}, new int[] {3,1,1}),new String[]{"pobi"}),
            Arguments.of(createCars(new String[]{"pobi", "crong", "honux"}, new int[] {2,2,1}),new String[]{"pobi","crong"}),
            Arguments.of(createCars(new String[]{"pobi", "crong", "honux"}, new int[] {2,2,2}),new String[]{"pobi", "crong", "honux"})
        );
    }

    private static Cars createCars(final String[] names, final int[] positions) {
        if (names.length != positions.length) {
            throw new IllegalArgumentException("[ERROR] difference size");
        }
        Car[] cars = new Car[names.length];
        for (int i=0; i < names.length; i++) {
            cars[i] = new Car(new Name(names[i]),new Energy(0),new Position(positions[i]));
        }
        return new Cars(cars);
    }

    private Name[] createNameBy(String[] names) {
        Name[] res = new Name[names.length];
        for (int i=0; i < names.length; i++) {
            res[i] = new Name(names[i]);
        }
        return res;
    }
}
