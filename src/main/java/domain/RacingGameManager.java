package domain;

import io.InputCarRacing;

import java.util.Arrays;
import java.util.List;

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
        for (int i = 0; i < turnCnt; i++) {
            racingPlayer.turn();
        }

    }

    public RacingPlayer getRacingPlayer() {
        return this.racingPlayer;
    }


}
