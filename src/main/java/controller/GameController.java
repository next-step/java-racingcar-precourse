package controller;

import service.GameService;
import utills.Validator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private static final GameService gameService = GameService.getInstance();
    private static String[] carsName;
    private static int count;

    public void startGame(){
        getUserInput();
        gameService.createCars(carsName);
        playGame();
        getWinner();
    }

    /**
     * 게임을 진행하는 메서드 (사용자가 입력한 횟수만큼 진행)
     */
    private void playGame(){
        Map<String,Integer> result;
        outputView.outputText();
        //count 횟수만큼 움직이고 출력
        for (int i = 0; i<count; i++){
            result = gameService.moveCars(carsName);
            outputView.printResult(result);
        }
    }

    private void getWinner(){
        List<String> winnerNames = gameService.findWinner();
        outputView.printWinner(winnerNames);
    }


    private void getUserInput(){
        carsName = getCarsName();
        count = getCount();
    }

    private String[] getCarsName(){
        while(true){
            try {
                String[] names = inputView.getCarsName();
                Validator.validCheckCarNames(names);
                return names;
            } catch(IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getCount(){
        while(true){
            try {
                String count = inputView.getCount();
                Validator.validCheckCount(count);
                return Integer.parseInt(count);
            } catch(IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
