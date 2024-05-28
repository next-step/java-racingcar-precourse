package racingCar.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import racingCar.customException.TooLongNameException;
import racingCar.customException.TooLowNameLengthException;
import racingCar.model.RacingCarModel;
import racingCar.service.RacingCarService;
import racingCar.view.UI;

public class RacingCarUtil {

    private final int MAX_NAME_LENGTH = 5;

    public String[] trimInput(String[] input) { //인풋 다듬기
        RacingCarUtil racingCarUtil = new RacingCarUtil();
        return Arrays.stream(input)
                .map(String::trim).filter(racingCarUtil::exceptIllegalLength)
                .toArray(String[]::new);
    }

    private boolean exceptIllegalLength(String carName) { //길이가 5 초과되거나 빈칸이 있을 경우 throw Exception
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new TooLongNameException("[Error] 차 이름이 너무 긺니다. 1 ~ 5자만 가능합니다.");
        }
        if(carName.isBlank()){
            throw new TooLowNameLengthException("[Error] 차 이름이 너무 짧습니다. 1 ~ 5자만 가능합니다.");
        }
        return true;
    }

    public String[] getUserInputCarName(UI ui) {
        String[] UserInputCarName;
        while (true) {
            try {
                UserInputCarName = ui.userInputCarName().split(",");
                UserInputCarName = this.trimInput(UserInputCarName);
                break;
            } catch (IllegalArgumentException e) {
                ui.printIllegalArgumentException(e);
            } catch (Exception e) {
                ui.printCriticalException(e);
                return null;
            }
        }
        return UserInputCarName;
    }

    public boolean setAttempts(RacingCarModel racingCarModel, UI ui) {
        while (true) {
            try {
                racingCarModel.setAttempts(ui.userInputAttempts());
                return true;
            } catch (IllegalArgumentException e) {
                ui.printIllegalArgumentException(e);
            } catch (Exception e) {
                ui.printCriticalException(e);
                return false;
            }
        }
    }

    public void iterateRace(Map<String, Integer> carStats, int attempts, UI ui) {
        RacingCarService racingCarService = new RacingCarService();

        for (int i = 0; i < attempts; i++) {
            Iterator<String> keys = carStats.keySet().iterator();
            racingCarService.doRaceOneTurn(carStats, keys);
            ui.printCarStatus(carStats);
        }
    }

}
