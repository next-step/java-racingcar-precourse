package racingcar.view;

import static racingcar.TestConstants.RIGHT_NAME;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class PromptTest {

    private Prompt prompt;
    private List<Car> cars;
    private List<String> cars_name;

    @Test
    void printInterimResults() {
        prompt.printInterimResults(cars);
    }

    @Test
    void printFinalResults() {
        prompt.printFinalResults(cars_name);
    }

    @BeforeEach
    void setUp() {
        prompt = Prompt.getInstance();
        cars = new ArrayList<>(Collections.singletonList(new Car(RIGHT_NAME)));
        cars_name = new ArrayList<>(Collections.singletonList(RIGHT_NAME));
    }
}