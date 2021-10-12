package racinggame.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.Car;
import racinggame.model.Score;
import racinggame.utils.Validation;
import racinggame.view.InputView;
import racinggame.view.OutputView;
import racinggame.view.View;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameControllerTest {

    private ArrayList<Car> carArrayList = new ArrayList<>();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private View view = new View(inputView, outputView);

    RacingGameController racingGameController = new RacingGameController(carArrayList, view);

    @BeforeEach
    void setUp() {
        carArrayList = new ArrayList<>();
        inputView = new InputView();
        outputView = new OutputView();
        view = new View(inputView, outputView);

        racingGameController = new RacingGameController(carArrayList, view);
    }

    @Test
    void 가장많이_전진한_우승자_검증() {
        Car car = new Car("pobi",new Score(5));
        racingGameController.getCarArrayList().add(car);
        car = new Car("nana",new Score(2));
        racingGameController.getCarArrayList().add(car);
        String winners = racingGameController.checkWinner();

        Assertions.assertThat(winners).isEqualTo("pobi");

        racingGameController.getCarArrayList().clear();
        car = new Car("pobi",new Score(5));
        racingGameController.getCarArrayList().add(car);
        car = new Car("runa",new Score(5));
        racingGameController.getCarArrayList().add(car);
        car = new Car("nana",new Score(2));
        racingGameController.getCarArrayList().add(car);
        winners = racingGameController.checkWinner();

        Assertions.assertThat(winners).isEqualTo("pobi,runa");
    }

}