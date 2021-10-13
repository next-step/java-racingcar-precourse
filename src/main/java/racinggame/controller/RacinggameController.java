package racinggame.controller;

import racinggame.model.CarList;
import racinggame.model.RacinggameResult;
import racinggame.service.RacinggameService;

public class RacinggameController {

    public static void start() {
        CarList carList = RacinggameService.inputCarList();
        Integer round = RacinggameService.inputRound();
        RacinggameResult racinggameResult = RacinggameService.racing(round, carList);
        RacinggameService.gameResult(racinggameResult.getFirstPlace());
    }
}
