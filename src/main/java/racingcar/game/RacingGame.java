package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.RacingCar;
import racingcar.car.RacingCarDTO;
import racingcar.car.RacingCarName;
import racingcar.car.RacingCars;
import racingcar.game.strategy.DefaultRacingCarWinnerFindStrategy;
import racingcar.game.strategy.RacingCarWinnerFindStrategy;
import racingcar.view.RacingGameView;

public class RacingGame {
    private static final String EMPTY_RACING_CAR_MESSAGE = "최소 1대의 자동차 이름을 입력해 주세요.";
    private static String CAR_NAME_DELIMITER = ",";
    private RacingGameView racingGameView;
    private RacingCars racingCars = new RacingCars();
    private RacingStageCount racingStageCount;
    private RacingCarWinnerFindStrategy racingCarWinnerFindStrategy = new DefaultRacingCarWinnerFindStrategy();

    public RacingGame(RacingGameView racingGameView) {
        this.racingGameView = racingGameView;
    }

    public void start() {
        initGame();
        racingGameView.printStageStart();
        for (int i = 0; i < racingStageCount.getStageCount(); i++) {
            doStage();
        }
        List<RacingCarName> winners = racingCarWinnerFindStrategy.pickWinners(racingCars);
        racingGameView.printWinner(winners);
    }

    private void initGame() {
        try {
            setRacingCars();
            setRacingStageCount();
        } catch (IllegalArgumentException | IllegalStateException e) {
            racingGameView.printErrorMessage(e);
            racingCars.reset();
            initGame();
        }
    }

    private void setRacingCars() {
        List<RacingCarName> racingCarNameList = getRacingCarNameList();
        for (RacingCarName name : racingCarNameList) {
            racingCars.addRacingCar(new RacingCar(name));
        }
    }

    private List<RacingCarName> getRacingCarNameList() {
        String carNamesInput = racingGameView.takeRacingCarNames();
        String[] names = carNamesInput.split(CAR_NAME_DELIMITER);
        List<RacingCarName> racingCarNameList = new ArrayList<>();
        for (String name : names) {
            racingCarNameList.add(new RacingCarName(name));
        }
        checkRacingCarNameListEmpty(racingCarNameList);
        return racingCarNameList;
    }

    private void checkRacingCarNameListEmpty(List<RacingCarName> racingCarNameList) {
        if (racingCarNameList.size() == 0) {
            throw new IllegalStateException(EMPTY_RACING_CAR_MESSAGE);
        }
    }

    private void setRacingStageCount() {
        String stageCountInput = racingGameView.takeRacingStageCount();
        racingStageCount = new RacingStageCount(stageCountInput);
    }

    private void doStage() {
        racingCars.tryMove();
        List<RacingCar> racingCarList = racingCars.getRacingCarList();
        racingGameView.printStageResult(getRacingCarDTOs(racingCarList));
    }

    private List<RacingCarDTO> getRacingCarDTOs(List<RacingCar> racingCarList) {
        List<RacingCarDTO> racingCarDTOList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            racingCarDTOList.add(RacingCarDTO.of(racingCar));
        }
        return racingCarDTOList;
    }
}
