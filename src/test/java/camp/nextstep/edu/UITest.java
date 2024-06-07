package camp.nextstep.edu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UITest {

    private Scanner scanner;
    private UI ui;

    @BeforeEach
    public void init() {
        this.scanner = new Scanner(System.in);
        this.ui = new UI(scanner);
    }

    @AfterEach
    public void cleanUp() {
        scanner.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c, d,  e,f  ,g ",
            "aaaaa, bbbbb"
    })
    public void checkCarNamesTest(String carNames) {
        String[] expected = carNames.split(",");
        String[] checkedResult = ui.checkCarNames(carNames);
        assertThat(expected).contains(checkedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abcdefg,b,c, d,  e,f  ,g ",
            "aaaaa, bbbbb, CCCCCCC"
    })
    public void checkCarNamesExceptionTest(String carNames) {
        assertThatThrownBy(() -> {
            ui.checkCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @ParameterizedTest
    @ArgumentsSource(CarNamesArgumentsProvider.class)
    public void prepareRacingCarTest(List<String> carNames) {
        List<Car> list = ui.prepareRacingCar(carNames.toArray(new String[]{}));
        assertThat(list)
                .hasSize(carNames.size())
                .first()
                .matches(car -> car.getName().equals(carNames.get(0)));
    }

    public static class CarNamesArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    List.of("a", "b", "c"),
                    List.of("ab", "bc", "cd"),
                    List.of("aaa", "bbb", "ccc")
            ).map(Arguments::of);
        }
    }

    @ParameterizedTest
    @ArgumentsSource(RaceArgumentsProvider.class)
    public void raceTest(List<Car> carNames, int raceCount) {
        ui.race(carNames, raceCount);
    }

    public static class RaceArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            Object [][] data = {
                    {
                        List.of(new Car("a-0"), new Car("a-1"), new Car("a-2")), 1
                    },
                    {
                            List.of(new Car("b-0"), new Car("b-1"), new Car("b-2")), 5
                    },
                    {
                            List.of(new Car("c-0"), new Car("c-1"), new Car("c-2")), 10
                    },
            };
            return Stream.of(data).map(Arguments::of);
        }
    }
}
