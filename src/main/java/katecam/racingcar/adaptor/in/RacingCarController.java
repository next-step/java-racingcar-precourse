package katecam.racingcar.adaptor.in;

import java.util.List;
import katecam.racingcar.application.dto.command.GameInitializationReq;
import katecam.racingcar.application.port.in.command.GameInitializationUseCase;
import katecam.racingcar.application.port.in.command.GameTurnPlayUseCase;
import katecam.racingcar.application.port.in.query.GameStatusQuery;

public class RacingCarController {
    private final GameInitializationUseCase gameInitializationUseCase;
    private final GameTurnPlayUseCase gameTurnPlayUseCase;
    private final GameStatusQuery gameStatusQuery;

    public RacingCarController(GameInitializationUseCase gameInitializationUseCase,
            GameTurnPlayUseCase gameTurnPlayUseCase, GameStatusQuery gameStatusQuery) {
        this.gameInitializationUseCase = gameInitializationUseCase;
        this.gameTurnPlayUseCase = gameTurnPlayUseCase;
        this.gameStatusQuery = gameStatusQuery;
    }

    public void initGame(List<String> carNames, int numberToAttempt){
        gameInitializationUseCase.initialize(new GameInitializationReq(carNames, numberToAttempt));
    }
    public void playTurn(){
        gameTurnPlayUseCase.playTurn();
    }
    public boolean isEnded(){
        return gameStatusQuery.isEnded();
    }
    public String getTurnResult(){
        return gameStatusQuery.getTurnResult().toString();
    }
    public String getTotalResult(){
        return gameStatusQuery.getTotalResult().toString();
    }
}