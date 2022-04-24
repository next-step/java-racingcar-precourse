package racingcar.service;

import racingcar.UI.RacingCarUI;
import racingcar.domain.CarListManagement;
import racingcar.domain.CarObject;

import java.util.List;

public class RacingCarGameService {
    private RacingCarUI racingCarUI= new RacingCarUI();
    private CarListManagement carListManagement;
    private Integer userTryNumber = -1;
    public RacingCarGameService(){

    }

    public Boolean startRacingGame(){
        List<CarObject> winners = null;
        String resultWinners = null;
        carListManagement = initCarListManagement(racingCarUI);
        userTryNumber = initTryNumber(racingCarUI);

        progressGame();

        {//승리자 선택
            winners = carListManagement.getMaxCarObjects();
            resultWinners = racingCarUI.extractNamesFromCarObjects(winners);
        }
        racingCarUI.printGameSystemMessage("최종 우승자: " + resultWinners);
        return true;
    }
    private void playEachPlayerGame(CarObject car){
        car.setCurrentRoundNumber(RandomGenerateService.generateRandomInteger());
        if(car.getCurrentRoundNumber()>3)
            car.setForwardCount(car.getForwardCount()+1);
    }
    private void progressOneRound(){
        for (CarObject car:carListManagement.getCarsList()) {
            playEachPlayerGame(car);
        }
        racingCarUI.printCurrentRound(carListManagement.getCarsList());
    }
    private void progressGame(){
        for(Integer i = 0 ; i < userTryNumber ; i++){ // 입력 횟수만큼 트라이
            progressOneRound();
        }
    }

    private Integer initTryNumber(RacingCarUI racingCarUI)
    {   //시도 횟수 입력
        //실패시 해당 위치부터 다시 시작
        racingCarUI.printGameSystemMessage(RacingCarUI.INPUT_TRY_NUMBER_MESSAGE);
        String userTryNumberStr;
        try{
            userTryNumberStr = racingCarUI.getUserInput();
            return racingCarUI.parseNumber(userTryNumberStr);
        }
        catch (IllegalArgumentException e){
            racingCarUI.printGameSystemMessage(e.getMessage());
            return initTryNumber(racingCarUI);
        }
    }

    public CarListManagement initCarListManagement(RacingCarUI racingCarUI)
    {   //carList 생성
        //실패시 해당 위치부터 다시 시작
        racingCarUI.printGameSystemMessage(RacingCarUI.INPUT_NAME_MESSAGE);
        String userNamesStr;
        List<String> userNames;
        try {
            userNamesStr  = racingCarUI.getUserInput();
            userNames = racingCarUI.parseNames(userNamesStr);
            return new CarListManagement(userNames);
        }
        catch (IllegalArgumentException e){
            racingCarUI.printGameSystemMessage(e.getMessage());
            return initCarListManagement(racingCarUI);
        }
    }

}
