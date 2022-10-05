package racingcar.ui;

import static java.lang.System.in;
import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.UserCarRacingRequest;
import racingcar.model.UserTrialRequest;
import racingcar.service.RacingCarService;

public class BasicView {

    private final RacingCarService racingCarService;

    public BasicView(RacingCarService racingCarService){
        this.racingCarService = racingCarService;
    }

    /**
     * print RegisterCarListView
     */
    public void printRegisterCarListView(){
        try {
            out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            racingCarService.registerCarList(UserCarRacingRequest.valueOf(input));
        }catch (IllegalArgumentException ex){
            out.println(ex.getMessage());
            printRegisterCarListView();
        }

    }

    /**
     * print RegisterTrialView
     */
    public void printRegisterTrialView(){
        try{
            out.println("시도할 횟수는 몇회인가요?");
            String input = Console.readLine();
            racingCarService.registerLaps(UserTrialRequest.valueOf(input));
            out.println();
        }catch (IllegalArgumentException ex){
            out.println(ex.getMessage());
            printRegisterTrialView();
        }

    }
}
