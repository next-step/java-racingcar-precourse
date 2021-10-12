package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.model.Car;
import racinggame.model.Score;
import racinggame.utils.Validation;
import racinggame.view.InputView;
import racinggame.view.OutputView;
import racinggame.view.View;

import java.util.ArrayList;

public class Application {

    private static final Integer INITIAL_RUN_NUMBER = 0;
    private static final Boolean INITIAL_VICTORY_VALUE = false;
    private static final String INITIAL_CAR_NAME = "";
    private static ArrayList<Car> carArrayList;
    private static InputView inputView;
    private static OutputView outputView;
    private static View view;
    private static RacingGameController racingGameController;

    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현

        // 셋업
        setUp();

        while(true) {

            // 자동차 이름 입력
            Boolean validated = inputCarNames();
            if (!validated) {
                racingGameController.getView().getOutputView().printOutputErrorMessage();
                continue;
            }

        }
    }

    /**
     * 기능1 : 자동차에 이름을 입력하는 기능 구현
     */
    protected static Boolean inputCarNames() {

        String inputCarNames = racingGameController.readInputCarNames();
        String[] carNames = Validation.DivideCarNames(inputCarNames);

        return validateCarNames(carNames);
    }

    private static Boolean validateCarNames(String[] carNames) {
        Score score = new Score(INITIAL_RUN_NUMBER, INITIAL_VICTORY_VALUE);
        Car car = new Car(INITIAL_CAR_NAME, score);

        for (int i = 0; i < carNames.length; i++) {
            if(!Validation.validateCarNameLength(carNames[i])) {
                racingGameController.getCarArrayList().clear();
                return false;
            }
            car.setName(carNames[i]);
            racingGameController.getCarArrayList().add(car);
        }
        return true;
    }

    protected static void setUp() {

        carArrayList = new ArrayList<>();
        inputView = new InputView();
        outputView = new OutputView();
        view = new View(inputView, outputView);

        racingGameController = new RacingGameController(carArrayList, view);
    }
}
