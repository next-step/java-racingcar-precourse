package racingcar.controller;

import racingcar.model.racingCar;
import racingcar.service.racingcarService;
import racingcar.service.racingcarServiceImple;
import racingcar.utils.inputOutputMessage;
import racingcar.view.racingcarView;

import java.util.List;


public class racingcarController {
    private racingcarService service = new racingcarServiceImple();
    private racingcarView view = new racingcarView();
    private inputOutputMessage message = new inputOutputMessage();
    private String resultWineer = "";
    public void run(){
        ready();
        play();
        end();
    }
    public void ready(){
        service.inputracingCars();
        service.inputracingCount();
    }
    public void play(){
        List<racingCar> listCar;
        int moveCount = service.getMoveCount();
        for(int i = 0; i<moveCount; i++){
            message.executionMessage();
            listCar = service.inputracingPosition();
            view.printMatchResult(listCar);
            System.out.println();
        }
    }
    public void end(){
        resultWineer = service.racingWinner();
        view.printMatchResultWinner(resultWineer);
    }
}
