package racingcar.controller;

import racingcar.model.CarGroup;
import racingcar.model.GameCount;
import racingcar.view.GameManager;

import java.util.ArrayList;

public class RacingGame {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private CarGroup carGroup;
    private GameCount gameCount;

    public RacingGame() {
        this.carGroup = new CarGroup();
        this.gameCount = new GameCount();
    }

    public void execution() {
        inputCarGroup();
        inputGameCount();
        runARace();
        GameManager.reportWinners(carGroup.getWinnerGroups());
    }

    private void inputGameCount() {
        GameManager.inputGameCount();
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        if(!gameCount.setGameCount(input)){
            inputGameCount();
        }
    }

    private void runARace() {
        for (int i = 0; i < gameCount.getGameCount(); i++) {
            carGroup.move(camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
            GameManager.reportGameResult(carGroup);
        }
    }

    private void inputCarGroup() {
        ArrayList<Boolean> addCarResults = new ArrayList<>();
        while (addCarResults.isEmpty() || addCarResults.contains(false)) {
            addCarResults.clear();
            carGroup.getCars().clear();
            GameManager.inputCarNames();
            inputNames(addCarResults);
        }
    }

    private void inputNames(ArrayList<Boolean> addCarResults) {
        String[] names = carNamesToArray(camp.nextstep.edu.missionutils.Console.readLine());
        for (String name : names) {
            addCarResults.add(carGroup.addCar(name));
        }
    }

    private String[] carNamesToArray(String carNames) {
        return carNames.split(",");
    }
}
