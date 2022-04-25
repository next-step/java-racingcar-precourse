package racingcar.controller;

import org.junit.platform.commons.util.StringUtils;
import racingcar.model.*;
import racingcar.view.RacingCarGameInputReader;
import racingcar.view.RacingCarGameOutputWriter;

public class RacingCarGame {
    private RacingCars racingCars;
    private RacingCarGameValidator racingCarGameValidator;
    private RacingCarGameReferee racingCarGameReferee;
    private GameRoundRandomNumberGanerator gameRoundRandomNumberGanerator;
    private RacingCarGameOutputWriter racingCarGameOutputWriter;
    private RacingCarGameRule racingCarGameRule;
    private RacingCarGameError racingCarGameError;

    public RacingCarGame() {
        this.racingCars = new RacingCars();
        this.racingCarGameValidator = new RacingCarGameValidator();
        this.racingCarGameReferee = new RacingCarGameReferee();
        this.gameRoundRandomNumberGanerator = new GameRoundRandomNumberGanerator();
        this.racingCarGameOutputWriter = new RacingCarGameOutputWriter();
        this.racingCarGameRule = new RacingCarGameRule();
        this.racingCarGameError = new RacingCarGameError();
    }

    public void start() {
        settingRacingCars();
        decideRacingCarGameRound();
        racingCarGameReferee.racingCarGameRoundsProcessing(racingCars, racingCarGameRule.getRacingCarGameRound(), gameRoundRandomNumberGanerator);
        RacingCars winnerRacingCars = racingCarGameReferee.calculateRacingCarGameResult(racingCars);
        racingCarGameOutputWriter.answerRacingCarGameResult(winnerRacingCars);
    }

    private void settingRacingCars() {
        decideRacingCarNames();

        for (String racingCarName : racingCarGameRule.getRacingCarGameNames().split(",")) {
            racingCars.addRacingCar(new RacingCar(racingCarName));
        }
    }

    private void decideRacingCarNames() {
        String racingCarNames = new String();
        racingCarGameValidator.initValidator();

        while (!racingCarGameValidator.isValid()) {
            racingCarNames = RacingCarGameInputReader.inquireRacingCarNames();
            racingCarGameValidator.racingCarNamesValidate(racingCarNames, racingCarGameError);
            processRacingGameError();
        }
        racingCarGameRule.setRacingCarGameNames(racingCarNames);
    }

    private void decideRacingCarGameRound() {
        String racingCarGameRound = new String();
        racingCarGameValidator.initValidator();

        while (!racingCarGameValidator.isValid()) {
            racingCarGameRound = RacingCarGameInputReader.inquireRacingCarGameRounds();
            racingCarGameValidator.racingCarGameRoundsValidate(racingCarGameRound, racingCarGameError);
            processRacingGameError();
        }
        racingCarGameRule.setRacingCarGameRound(Integer.parseInt(racingCarGameRound));
    }

    private void processRacingGameError() {
        if (StringUtils.isNotBlank(racingCarGameError.getDefaultMessage())) {
            racingCarGameOutputWriter.answer(racingCarGameError.getDefaultMessage());
            racingCarGameError.initErorr();
        }
    }
}
