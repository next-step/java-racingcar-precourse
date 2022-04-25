package racingcar.controller;

import racingcar.constant.MessageConst;
import racingcar.constant.NumberConst;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.UserInput;
import racingcar.validation.RacingCarValidation;
import racingcar.view.RacingCarConsoleView;
import utils.CommonUtils;
import java.util.List;

public class RacingCarController {
    public void start(){
        String[] carNames = inputCarNames();
        String tryCount = inputTryCount();
        UserInput userInput = new UserInput(carNames, Integer.parseInt(tryCount));

        Cars cars = new Cars();
        addCar(cars, userInput);
        playGame(cars, userInput);
    }

    private String inputTryCount() {
        String tryCount = RacingCarConsoleView.printInputMessage(MessageConst.INPUT_TRY_COUNT);
        try {
            validateTryCountInput(tryCount);
        } catch(IllegalArgumentException e){
            RacingCarConsoleView.printMessageLine(e.getMessage());
            return inputTryCount();
        }
        return tryCount;
    }

    private String[] inputCarNames() {
        String[] carNames = CommonUtils.getNamesArray(RacingCarConsoleView.printInputMessage(MessageConst.INPUT_CAR_NAMES));
        try{
            validateCarNamesInput(carNames);
        } catch (IllegalArgumentException e){
            RacingCarConsoleView.printMessageLine(e.getMessage());
            return inputCarNames();
        }
        return carNames;
    }

    public void playGame(Cars cars, UserInput userInput){
        RacingCarConsoleView.printMessageLine(MessageConst.OUTPUT_RESULT);
        for (int i = 0; i < userInput.getTryCount(); i++) {
            moveOrStopCars(cars);
        }
        int winnersDistance = cars.getWinnersDistance();
        List<Car> winners = cars.getCarsByDistance(winnersDistance);
        cars.printWinnersList(winners);

    }

    public void moveOrStopCars(Cars cars){
        for (int i = 0; i < cars.size(); i++) {
            if(CommonUtils.getRandomValue() >= NumberConst.MOVING_FORWARD_NUMBER){
                cars.get(i).movingForward(NumberConst.MOVING_DISTANCE_PER_TIME);
            }
            RacingCarConsoleView.printMovingDistanceEveryCar(cars.get(i));
        }
        RacingCarConsoleView.printMessageLine("");
    }

    public void addCar(Cars cars, UserInput input){
        for (int i = 0; i < input.getCarNames().length; i++) {
            cars.addCar(new Car(input.getCarNames()[i], 0));
        }
    }

    private void validateCarNamesInput(String[] carNames) {
        RacingCarValidation.validateCarNames(carNames);
        RacingCarValidation.validateCarCount(carNames);
        RacingCarValidation.validateUniqueCarName(carNames);
    }
    private void validateTryCountInput(String tryCount) {
        RacingCarValidation.validateTryCount(tryCount);
    }
}
