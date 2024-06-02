package Racing.controller;

import Racing.domain.Car;
import Racing.domain.Cars;
import Racing.service.GenerateCarService;
import Racing.service.ResultService;
import Racing.service.ScoreService;
import Racing.view.InputView;
import Racing.view.ResultView;
import Racing.view.ScoreView;
import java.util.List;

public class GameController {

    //Service
    private GenerateCarService generateCarService = new GenerateCarService();
    private ScoreService scoreService = new ScoreService();
    private ResultService resultService = new ResultService();

    //View
    private InputView inputView = new InputView();
    private ScoreView scoreView = new ScoreView();
    private ResultView resultView = new ResultView();

    //Domain

    private Cars cars;


    public void startGame() {
        initGame();
        playGame();
        finishGame();
    }

    private void initGame() {
        inputView.printCarNameInput();
        List<String> carNames = inputView.getCarNameModel();
        cars = generateCarService.generate(carNames);
    }

    private void playGame() {
        inputView.printTryInput();
        int tryNumber = inputView.getTryModel();
        for (int i = 0; i < tryNumber; i++) {
            scoreService.saveScore(cars);
            scoreView.printScore(cars);

        }
    }

    private void finishGame() {
        resultView.printResult(resultService.result(cars));
    }

}
