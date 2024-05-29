package Controller;

import Model.Car;
import Service.CarService;
import java.util.ArrayList;

public class CarController {
    private CarService carService;

    public CarController() {
        this.carService = new CarService();
    }

}
