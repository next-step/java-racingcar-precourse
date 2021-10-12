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
    private static final Integer ADD_RUN_NUMBER = 1;
    private static ArrayList<Car> carArrayList;
    private static InputView inputView;
    private static OutputView outputView;
    private static View view;
    private static RacingGameController racingGameController;
    private static int gameCount;

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

            // 이동 횟수를 입력
            validated = inputRunNumber();
            if (!validated) {
                racingGameController.getView().getOutputView().printOutputErrorMessage();
                continue;
            }

            // 이동횟수 동안 자동차 전진 및 출력
            racingGameController.getView().getOutputView().printOutputRacingResultTitle();
            racingGame();


        }
    }

    /**
     * 기능3 : 전진 횟수만큼 전진하는 자동차 만들기
     */
    private static void racingGame() {
        int carsSize = racingGameController.getCarArrayList().size();

        for (int i = 0; i < gameCount; i++) {
            for(int j = 0; j < carsSize; j++) {
                makeScore(j);
            }
            racingGameController.updateRacingResult();
        }
    }

    private static void makeScore(int index) {
        if(Validation.checkRunCar())
            racingGameController.getCarArrayList().get(index).setScore(
                    new Score(racingGameController.getCarArrayList().get(index).getScore().getRunNumber()+ADD_RUN_NUMBER,false));
    }

    /**
     * 기능2 : 사용자가 이동횟수를 입력하는 기능구현
     */
    private static Boolean inputRunNumber() {
       String inputRunNumber = racingGameController.readInputRunNumber();
       if(!Validation.validateRunNumber(inputRunNumber))
           return false;
        gameCount = Integer.parseInt(inputRunNumber);
        return true;
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

        for (int i = 0; i < carNames.length; i++) {
            if(!Validation.validateCarNameLength(carNames[i])) {
                racingGameController.getCarArrayList().clear();
                return false;
            }

            Score score = new Score(INITIAL_RUN_NUMBER, INITIAL_VICTORY_VALUE);
            Car car = new Car(carNames[i], score);
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
