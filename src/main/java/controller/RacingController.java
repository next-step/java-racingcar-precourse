package controller;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.CarList;
import service.RacingService;
import validation.Validation;
import view.InputView;
import view.PrintView;

public class RacingController {
    private CarList carList;
    private PrintView printView;
    private InputView inputView;
    private RacingService racingService;
    public RacingController(){
        carList = new CarList();
        printView = new PrintView();
        inputView = new InputView();
        racingService = new RacingService();
    }

    public void run(){

        // 이름 입력
        carList.setCarList(inputView.inputCarNames());
        // 횟수 입력
        int cnt = inputView.inputCount();

        // 경주 진행
        for(int i=0; i< cnt; i++){
            racingService.race(carList);
            printView.printDriveView(i, carList);
        }

        // 우승자 구하기
        printView.printWinnerView(racingService.getWinner(racingService.getMaxDistance(carList), carList));

    }
}
