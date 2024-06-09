package katecam.racingcar.application.port.in.command;

import katecam.racingcar.application.dto.command.GameInitializationReq;

public interface GameInitializationUseCase {
    void initialize(GameInitializationReq req);
}
