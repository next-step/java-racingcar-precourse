package Controller;

import Service.RacingService;
import Service.RacingServiceImpl;
import Utils.SystemMessage;
import Views.InputView;
import Views.Result;

public class RacingController {

    private static RacingController instance = new RacingController();
    private RacingService racingService = RacingServiceImpl.getInstance();

    // Adapting Singleton Design Pattern
    private RacingController() {}
    public static RacingController getInstance() {
        return instance;
    }


    public void run() {
        setRace();      // 자동차 정보 입력, 이동횟수 입력
        race();         // 입력된 정보를 바탕으로 레이싱 진행
        raceOver();     // 우승자 출력 (단, 우승자는 여러명일 수 있다)
    }

    private void raceOver() {
        Result.printResult(racingService.getResult());
    }

    private void race() {
        System.out.println(SystemMessage.BEFORE_RACE);
        racingService.play();
    }

    private void setRace() {
        String names = InputView.requestName();
        String time = InputView.requestTime();
        try{
            racingService.setRace(names, time);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setRace();
        }
    }

}