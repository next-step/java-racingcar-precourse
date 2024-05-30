package Controller;

import Model.Info;
import View.InputView;
import View.ProgressView;
import View.WinnerView;

public class RaceController {
    private final Validator validator = new Validator();
    private final InputView inputView = new InputView();
    private final ProgressView progressView = new ProgressView();
    private final WinnerView winnerView = new WinnerView();
    private final Info info = new Info();

    public void inputName(){
        while(true) {
            try {
                String names = inputView.inputCarNames();
                validator.InputValidator(names);
                validator.DuplicationValidator(names);
                info.insertNames(names);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                inputView.printError(e.getMessage());
            }
        }
    }

    public void inputCount(){
        while(true) {
            try {
                String count = inputView.inputCount();
                validator.InputCountMissMatchValidator(count);
                validator.InputCountValidator(Integer.parseInt(count));
                info.insertCount(Integer.parseInt(count));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                inputView.printError(e.getMessage());
            }
        }
    }

    public void round(){
        System.out.println("실행 결과");
        while(!info.isFinish()){
            info.round();
            progressView.printProgress(info.getProgressList());
        }
    }
    public void finish(){
        winnerView.PrintWinner("최종 우승자 : " + info.getWinner());
    }
}
