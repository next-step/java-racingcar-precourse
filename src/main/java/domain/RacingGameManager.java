package domain;

import io.InputCarRacing;
import io.OutputCarRacing;

import java.util.Arrays;
import java.util.List;

import static util.CarRacingMessage.RUN_RESULT;

public class RacingGameManager {
    private InputCarRacing inputCarRacing = new InputCarRacing();
    private RacingPlayer racingPlayer = new RacingPlayer();
    private static int turnCnt = 0;
    private List<String> carNameList;


    public void setup() {

        carNameList = Arrays.asList(inputCarRacing.inputCarNames());
        racingPlayer = new RacingPlayer(carNameList);
        turnCnt = inputCarRacing.inputTurnCnt();
    }

    public void start() {
        System.out.println("\n\n" + RUN_RESULT);
        for (int i = 0; i < turnCnt; i++) {
            racingPlayer.turn();
            OutputCarRacing.printTurn(racingPlayer);
        }

    }

    public void result() {
        OutputCarRacing.winnerPrint(racingPlayer);
    }

}
