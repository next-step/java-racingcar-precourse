package service;

import domain.Car;
import io.Input;
import io.Output;
import java.util.ArrayList;
import java.util.List;
import repository.CarRepository;
import validate.Validator;

public class Race {

    private int raceNum;
    private String raceInput;
    private static final int CAR_NAME_NUM = 5;
    private static final char INPUT_SYMBOL = ',';
    private final Input input;
    private final Output output;
    private final Validator validator;

    private final CarRepository carRepository;

    public Race(Input input, Output output, Validator validator, CarRepository carRepository) {
        this.input = input;
        this.output = output;
        this.validator = validator;
        this.carRepository = carRepository;
    }

    public void execute() {
        raceInput = input.getCarName();
        while (!validator.validateRaceInput(input.deleteSpace(raceInput), INPUT_SYMBOL,
            CAR_NAME_NUM)) {
            raceInput = input.getCarName();
        }
        registCar(raceInput);

        String stringRaceNum = input.getRaceCount();
        while (!validator.validateRaceCount(stringRaceNum)) {
            stringRaceNum = input.getRaceCount();
        }
        raceNum = Integer.parseInt(stringRaceNum);
        List<Car> carList = carRepository.findAllCar();

        output.print("실행 결과");
        raceStart(carList);

        List<Car> winnerList = getWinner();
        output.printWinner(winnerList);
    }

    public void registCar(String raceInput) {
        String[] carList = raceInput.split(Character.toString(INPUT_SYMBOL));
        for (String stringCar : carList) {
            Car car = new Car(stringCar);
            carRepository.saveCar(car);
        }
    }

    public void raceStart(List<Car> carList) {
        for (int i = 0; i < raceNum; i++) {
            carList.stream().forEach(car -> {
                car.move();
                output.printRace(car.getName(), car.getLocation());
            });
            output.print("");
        }
    }

    public List<Car> getWinner() {
        List<Car> winnerList = new ArrayList<>();
        List<Car> carList = carRepository.findAllCar();
        int maxLocation = findMaxLocation();
        for (Car car : carList) {
            if (car.getLocation() == maxLocation) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    private int findMaxLocation() {
        int maxLocation = 0;
        List<Car> carList = carRepository.findAllCar();
        for (Car car : carList) {
            int carLocation = car.getLocation();
            if (maxLocation < carLocation) {
                maxLocation = carLocation;
            }
        }
        return maxLocation;
    }
}
