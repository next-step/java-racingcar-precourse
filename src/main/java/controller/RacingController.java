package controller;

import java.util.Random;
import model.CarList;
import service.RacingService;
import view.InputView;
import view.PrintView;

public class RacingController {
    private CarList carList;
    private PrintView printView;
    private InputView inputView;
    private RacingService racingService;
    private Random random;
    public RacingController(){
        carList = new CarList();
        printView = new PrintView();
        inputView = new InputView();
        racingService = new RacingService();
        random = new Random();
    }

    public void run(){

        // 이름 입력
        carList.setCarList(inputView.inputCarNames());
        // 횟수 입력
        int cnt = inputView.inputCount();

        // 경주 진행
        for(int i=0; i< cnt; i++){
            racingService.race(()->(random.nextInt(10)),carList);
            printView.printRaceView(i, carList);
        }

        // 우승자 구하기
        printView.printWinnerView(racingService.getWinner(racingService.getMaxDistance(carList), carList));

    }
}
