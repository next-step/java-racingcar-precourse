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
}
