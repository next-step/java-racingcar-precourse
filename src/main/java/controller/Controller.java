package controller;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Race;
import view.Input;
import view.Output;

public class Controller {
    private List<Car> createCars() {
        while (true) {
            try {
                String[] names = Input.getCarName();
                List<Car> cars = new ArrayList<>();
                for (String carName : names) {
                    cars.add(new Car(carName));
                }
                return cars;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public void play() {
        List<Car> cars = createCars();
        int round = Input.getRound();
        Race race = new Race(cars, round);

        race.start();
        Output.printWinner(race.getWinner());
    }
}
