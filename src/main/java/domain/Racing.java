package domain;

import java.util.List;
import java.util.Random;
import model.CarRepository;

public class Racing {
    private final CarRepository carRepository;
    private final Random random;
    public Racing(){
        carRepository=new CarRepository();
        random=new Random();
    }
    public void makeCars(List<String> names){
        for(String name:names) {
            Car car=new Car(name);
            carRepository.addCar(car);
        }
    }
    public void round(){
        List<Car> cars=carRepository.getCars();
        for(Car car:cars){
            int num=random.nextInt(10);
            if(num>=4){
                car.forward();
            }
        }
    }
    public StringBuilder createRoundResult() {
        StringBuilder roundRaceResult = new StringBuilder();
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            roundRaceResult.append(car.roundResult()).append("\n");
        }
        return roundRaceResult;
    }
    public int findWinnerDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
    public List<Car> winnerCars(List<Car> cars, int winnerScore) {
        return cars.stream()
                .filter(car -> car.getDistance() == winnerScore)
                .toList();
    }
    public List<Car> getCarList(){
        return carRepository.getCars();
    }



}
