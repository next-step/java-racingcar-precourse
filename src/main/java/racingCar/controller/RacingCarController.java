package racingCar.controller;

import racingCar.model.RacingCarModel;
import racingCar.view.UI;

public class RacingCarController {

    public static void main(String[] args) {
        UI ui = new UI();
        String[] UserInputCarName;
        RacingCarModel racingCarModel;
        RacingCarUtil racingCarUtil = new RacingCarUtil();

        UserInputCarName = racingCarUtil.getUserInputCarName(ui); // 차 이름 입력 받기
        if (UserInputCarName == null) {
            ui.notifyExit(); // 예기치 못한 예외시 프로그램을 종료하겠다고 알리기
            return;
        }

        racingCarModel = new RacingCarModel();
        racingCarModel.initCarStats(UserInputCarName); //차 이름 입력 받은거 가지고 carStats들 초기화 시키기
        boolean isSuccess = racingCarUtil.setAttempts(racingCarModel, ui); //시도 횟수 입력 받기

        if(!isSuccess) {
            ui.notifyExit(); // 예기치 못한 예외시 프로그램을 종료하겠다고 알리기
            return;
        }

        ui.notifyThisIsResult(); // 앞으로 결과를 출력하겠다고 알리기

        racingCarUtil.doRacing(racingCarModel.getCarStatus(), racingCarModel.getAttempts(), ui); //레이싱 진행하기
        
        ui.printWinner(racingCarUtil.retWinner(racingCarModel.getCarStatus())); //승자 출력하기
        ui.close(); //ui의 scanner 닫기

    }

}


