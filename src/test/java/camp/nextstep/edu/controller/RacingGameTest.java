package camp.nextstep.edu.controller;

import camp.nextstep.edu.domain.Car;
import camp.nextstep.edu.view.Input;
import camp.nextstep.edu.view.Output;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private Input input;
    private Output output;
    private RacingGame racingGame;
    private final InputStream originalIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    void init() {
        String simulatedUserInput = "Car1,Car2,Car3\n5\n";
        testIn = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(testIn);

        input = new Input(new Scanner(System.in));
        output = new Output();
        racingGame = new RacingGame(input, output);
    }

    @AfterEach
    public void restoreSystemIn() {
        System.setIn(originalIn);
    }

    @DisplayName("입력 받은 자동차 이름을 바탕으로 경주할 자동차 객체 리스트를 만든다.")
    @Test
    void prepare() {
        racingGame.prepareRace();

        List<Car> expected = List.of(
                new Car("Car1"),
                new Car("Car2"),
                new Car("Car3")
        );
        List<Car> cars = racingGame.getCars();

        assertThat(cars).hasSize(expected.size())
                .extracting(Car::getName)
                .containsExactlyInAnyOrder(
                        "Car1",
                        "Car2",
                        "Car3"
                );
    }
}
