package controller;

import service.GameService;
import utills.Validator;
import view.InputView;
import view.OutputView;

public class GameController {
    //TODO
    // 2.자동차 모델 생성
    // 3.게임 진행
    // 4.승자 탐색
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void playGame(){
        //TODO
    }
    public void getUserInput(){
        String[] carsName = getCarsName();
        int count = getCount();
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
            } catch(IllegalArgumentException e){
                outputView.printError(e.getMessage());
            }
        }
    }
}
