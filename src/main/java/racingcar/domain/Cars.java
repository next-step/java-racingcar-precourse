package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList = new ArrayList<>();

    public Cars(String carNames) {
        generateCar(carNames);
    }

    public List<Car> getCarList(){
        return carList;
    }

    public void generateCar(String carNames){
        String[] carStrings = carNames.split(",");
        for(String carName : carStrings){
            carList.add(new Car(carName));
        }
    }

    public List<String> getWinnerName(){
        List<Car> winnerCars = getWinner();
        List<String> winnerCarsName = new ArrayList<>();
        for(Car car : winnerCars){
            winnerCarsName.add(car.getCarName());
        }
        return winnerCarsName;
    }

    public List<Car> getWinner(){
        List<Car> winnerCars = new ArrayList<>();
        int max = 0;
        for(Car car : carList){
            max = AddWinner(winnerCars,car,max);
        }
        return winnerCars;
    }

    private int AddWinner(List<Car> winnerCars, Car car, int max) {
        if(car.getCarDistance() == max) winnerCars.add(car);

        if(car.getCarDistance() > max){
            winnerCars.clear();
            winnerCars.add(car);
            max = car.getCarDistance();
        }

        return max;
    }

    public void CarsNextStep(){
        for(Car car : carList){
            car.nextStep();
        }
    }
}
