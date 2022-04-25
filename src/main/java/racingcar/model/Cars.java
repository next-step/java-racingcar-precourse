package racingcar.model;

import racingcar.constant.MessageConst;
import racingcar.view.RacingCarConsoleView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<Car>();
    }

    public List<Car> getCars() {
        return carList;
    }

    public void setCars(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public int size(){
        return carList.size();
    }

    public Car get(int index){
        return carList.get(index);
    }

    public int getWinnersDistance(){
        int max = 0;
        for (int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getMovingDistance() > max){
                max = carList.get(i).getMovingDistance();
            }
        }
        return max;
    }

    public void printWinnersList(List<Car> winners){
        RacingCarConsoleView.printMessage(MessageConst.OUTPUT_WINNERS);
        int size = winners.size();
        for (int i = 0; i < size; i++) {
            RacingCarConsoleView.printMessage(winners.get(i).getName());
            if(i < size-1){
                RacingCarConsoleView.printMessage(", ");
            }
        }
    }

    public List<Car> getCarsByDistance(int winnersDistance) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < this.getCars().size(); i++) {
            if(this.get(i).getMovingDistance() == winnersDistance){
                cars.add(this.get(i));
            }
        }
        return cars;
    }
}
