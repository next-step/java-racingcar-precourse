package domain;

import util.Message;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int BASIC_NUM = 4;

    private static final int LIMIT_NUMBER_SIZE = 9;

    private static final String SPLIT_MARK = ",";

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

    public void moveForward(Cars cars) {
        for(Car car : cars.getCars()){
            if(isGreaterThanCheckValue()) car.moveCar();
        }
    }

    public boolean isGreaterThanCheckValue() {
        return getRandomValue() >= BASIC_NUM;
    }

    public int getRandomValue(){
        return (int) (Math.random() * LIMIT_NUMBER_SIZE);
    }

    public void getWinnerCar(){
        List<Car> winnerCars = new ArrayList<>();
        int maxDistance = 0;
        for(Car playingCar : cars){

            if(maxDistance == playingCar.getCarDistance().getDistance()){
                winnerCars.add(playingCar);
            }

            if (maxDistance < playingCar.getCarDistance().getDistance()) {
                maxDistance = playingCar.getCarDistance().getDistance();
                winnerCars.clear();
                winnerCars.add(playingCar);

            }
        }
        printWinner(winnerCars);
    }

    public void printWinner(List<Car> winnerCars){
        StringBuilder sb = new StringBuilder();
        for(Car winnerCar : winnerCars){
            sb.append(winnerCar.getCarName().getName());

            if(winnerCars.indexOf(winnerCar) != winnerCars.size()-1){
                sb.append(", ");
            }

        }
        System.out.println(sb + Message.OUTPUT_MSG_WINNER_COMMENT);
    }

}
