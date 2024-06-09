package service;

import domain.Car;
import domain.CarRepository;

import java.util.*;
import java.util.stream.Collectors;

public class GameService {
    CarRepository carRepository = CarRepository.getInstance();

    private static GameService gameService;
    private GameService(){}

    public static GameService getInstance(){
        if(gameService == null)
            gameService = new GameService();
        return gameService;
    }

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

    public List<String> findWinner(){
        ArrayList<Car> cars = carRepository.findAll();
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(() -> new IllegalStateException("레이싱카가 존재하지 않습니다."));
        return cars.stream().filter(c -> c.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }
}
