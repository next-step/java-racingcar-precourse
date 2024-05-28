package racingCar.controller;

import racingCar.model.RacingCarModel;
import racingCar.service.RacingCarService;
import racingCar.view.UI;

public class RacingCarController {
    UI ui;
    RacingCarModel racingCarModel;
    String[] UserInputCarName;
    RacingCarService racingCarService;
    RacingCarUtil racingCarUtil;

    public RacingCarController(){
        this.ui = new UI();
        this.racingCarModel = new RacingCarModel();
        this.racingCarService = new RacingCarService();
        this.racingCarUtil = new RacingCarUtil();
    }

    public void doGame(){
        this.UserInputCarName = racingCarUtil.getUserInputCarName(ui); // 차 이름 입력 받기
        if (UserInputCarName == null) {
            ui.notifyExit(); // 예기치 못한 예외시 프로그램을 종료하겠다고 알리기
            return;
        }
        racingCarModel.initCarStats(UserInputCarName); //차 이름 입력 받은거 가지고 carStats들 초기화 시키기
        if(!racingCarUtil.setAttempts(racingCarModel, ui)) { // 시도 횟수를 입력 받아서 모델에 저장
            ui.notifyExit(); // 예기치 못한 예외시 (반환값 -> false 일때) 프로그램을 종료하겠다고 알리기
            return;
        }
        ui.notifyThisIsResult(); // 앞으로 결과를 출력하겠다고 알리기
        racingCarService.doRacing(racingCarModel.getCarStatus(), racingCarModel.getAttempts(), ui); //레이싱 진행하기
        ui.printWinner(racingCarService.retWinner(racingCarModel.getCarStatus())); //승자 출력하기
        ui.close(); //ui의 scanner 닫기
    }

}


