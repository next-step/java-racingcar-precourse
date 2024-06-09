package service;

import domain.Car;
import domain.CarRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GameService {
    CarRepository carRepository = CarRepository.getInstance();

    public void createCars(String[] carNames){
        //Arrays.stream(carNames).forEach(name -> carRepository.save(new Car(name)));
        Arrays.stream(carNames).map(Car::new).forEach(carRepository::save);
    }

    public void findWinner(){
        ArrayList<Car> cars = carRepository.findAll();
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(() -> new IllegalStateException("레이싱카가 존재하지 않습니다."));
    }
}
