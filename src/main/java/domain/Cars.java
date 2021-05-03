package domain;

import util.Message;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String SPLIT_MARK = ",";

    private MoveCalculator moveCalculator = new MoveCalculator();

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        getDeviceValue(carNames);
    }

    public void getDeviceValue(String carNames) {

        String [] array = carNames.split(SPLIT_MARK);
        for(String carNm : array){
            cars.add(new Car(carNm));
        }
        new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void printWinner(){
        List<Car> winnerCars = moveCalculator.getWinnerCar(cars);
        StringBuilder sb = new StringBuilder();
        for(Car winnerCar : moveCalculator.getWinnerCar(cars)){
            sb.append(winnerCar.getCarName().getName());

            if(winnerCars.indexOf(winnerCar) != winnerCars.size()-1){
                sb.append(", ");
            }

        }
        System.out.println(sb + Message.OUTPUT_MSG_WINNER_COMMENT);
    }

    public void moveForward(Cars cars) {
        moveCalculator.moveForward(cars);
    }
}
