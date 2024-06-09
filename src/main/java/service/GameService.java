package service;

import domain.Car;
import domain.CarRepository;

import java.util.*;

public class GameService {
    CarRepository carRepository = CarRepository.getInstance();

    public void createCars(String[] carNames){
        //Arrays.stream(carNames).forEach(name -> carRepository.save(new Car(name)));
        Arrays.stream(carNames).map(Car::new).forEach(carRepository::save);
    }

    public Map<String,Integer> moveCars(String[] names){
        Map<String,Integer> dto = new LinkedHashMap<>();
        for(String name:names){
            Car car = carRepository.findByName(name);
            car.move();
            dto.put(name,car.getPosition());
        }
        return dto;
    }

//    public void findWinner(){
//        ArrayList<Car> cars = carRepository.findAll();
//        int maxPosition = cars.stream()
//                .max(Comparator.comparingInt(Car::getPosition))
//                .map(Car::getPosition)
//                .orElseThrow(() -> new IllegalStateException("레이싱카가 존재하지 않습니다."));
//    }
}
