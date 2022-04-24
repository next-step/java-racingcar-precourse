package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;
    private final int carCount;

    public List<Car> getCarList() {
        return carList;
    }

    public Cars(String inputName) {
        this.carList = makeCarList(inputName);
        this.carCount = carList.size();
    }

    private static List<Car> makeCarList(String inputName){
        List<Car> list = new ArrayList<>();

        String[] names = inputName.split(",");
        for(String name :names){
            list.add(new Car(name));
        }

        return list;
    }

    public int getCarCount() {
        return carCount;
    }

    public Car getIndexOfCar(int index){
        return carList.get(index);
    }

    public List<String> getWinnerName(List<Boolean> winnerIndexList) {
        List<String> winnerNameList = new ArrayList<>();
        for(int i = 0; i<carCount; ++i){
            addWinnerCarName(winnerNameList, carList.get(i), winnerIndexList.get(i));
        }

        return winnerNameList;
    }

    private void addWinnerCarName(List<String> winnerNameList, Car car, Boolean isWinner) {
        if(isWinner){
            winnerNameList.add(car.getName());
        }
    }
}
