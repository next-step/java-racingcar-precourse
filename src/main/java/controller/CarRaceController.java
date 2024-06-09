package controller;

import java.util.List;
import model.Car;
import service.CarRaceService;
import service.InputHandler;
import view.CarRaceView;


public class CarRaceController {
    private CarRaceView view;
    private InputHandler inputHandler;
    private CarRaceService carRace;

    public CarRaceController() {
        this.view = new CarRaceView();
        this.inputHandler = new InputHandler();
        this.carRace = new CarRaceService();
    }

    public void run() {
        while (true) {
            try {
                view.printWelcomeMessage();
                String carNames = inputHandler.getCarNames();
                carRace.createCars(carNames);
                break;
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }

        int tryCount = 0; // 시도 횟수
        while (true) {  // 시도 횟수 입력 받음, 오류 발생 시 재입력 받음
            try {
                view.printTryCountMessage();
                tryCount = inputHandler.getTryCount();
                break;
            } catch (IllegalArgumentException e) {
                view.printErrorMessage(e.getMessage());
            }
        }

        carRace.race(tryCount); // 시도 횟수만큼 레이스 진행
        view.printCars(carRace.getCars()); // 진행된 레이스 결과바 보여줌

        List<Car> winners = carRace.findWinners();
        view.printWinners(winners);
    }
}