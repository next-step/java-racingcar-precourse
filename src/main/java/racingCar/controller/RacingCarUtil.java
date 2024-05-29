package racingCar.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import racingCar.customException.SinglePlayIsProhibitedException;
import racingCar.customException.TooLongNameException;
import racingCar.customException.TooLowNameLengthException;
import racingCar.model.RacingCarModel;
import racingCar.service.RacingCarService;
import racingCar.view.UI;

public class RacingCarUtil {

    private final int MAX_NAME_LENGTH = 5;

    public String[] filterInput(String[] input) { //인풋 다듬기
        RacingCarUtil racingCarUtil = new RacingCarUtil();
        if (input.length < 2) {
            throw new SinglePlayIsProhibitedException("[ERROR] 혼자서 레이싱 경주를 할 수 없습니다. 다시 입력하세요.");
        }
        return Arrays.stream(input)
                .map(String::trim).filter(racingCarUtil::exceptIllegalLength)
                .toArray(String[]::new);
    }

    private boolean exceptIllegalLength(String carName) { //길이가 5 초과되거나 빈칸이 있을 경우 throw Exception
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new TooLongNameException("[ERROR] 차 이름이 너무 긺니다. 1 ~ 5자만 가능합니다.");
        }
        if(carName.isBlank()){
            throw new TooLowNameLengthException("[ERROR] 차 이름이 너무 짧습니다. 1 ~ 5자만 가능합니다.");
        }
        return true;
    }

    public String[] getUserInputCarName(UI ui) {
        String[] userInputCarNameArr;
        while (true) {
            try {
                userInputCarNameArr = this.filterInput(ui.userInputCarName().split(","));
                break;
            } catch (IllegalArgumentException e) {
                ui.printIllegalArgumentException(e);
            } catch (Exception e) {
                ui.printCriticalException(e);
                return null;
            }
        }
        return userInputCarNameArr;
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

    public void iterateRace(RacingCarModel racingCarModel, UI ui) {
        RacingCarService racingCarService = new RacingCarService();
        Map<String, Integer> carStatus = racingCarModel.getCarStatus();

        for (int i = 0; i < racingCarModel.getAttempts(); i++) {
            Iterator<String> keys = carStatus.keySet().iterator();
            racingCarService.doRaceOneTurn(carStatus, keys);
            ui.printCarStatus(carStatus);
            try{
                racingCarService.sleep();
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

}
