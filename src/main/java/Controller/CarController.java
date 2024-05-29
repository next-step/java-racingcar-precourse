package Controller;

import Service.CarService;
import View.InputView;
import View.OutputView;

public class CarController {
    private CarService carService;
    private InputView inputView;
    private OutputView outputView;

    public CarController() {
        this.carService = new CarService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void setCars(String carNames){
        for(String carName : carNames.split(",")){
            carService.addCar(carName);
        }
    }

    public void run(){
        outputView.printQuestCarName();
        setCars(inputView.readCarName());

        outputView.printQuestRound();
        int round = inputView.readRound();

        outputView.printExeResult();
        for(int i = 0; i < round; i++){
            carService.raceCar();
            outputView.printCarDistance(carService.getCars());
        }

        outputView.printWinner(carService.getWinner());
    }

}
