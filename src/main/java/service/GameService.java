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

    /**
     * 사용자로부터 유효한 자동차 이름을 입력 받았을 때 Car 객체 생성하는 메서드
     * @param carNames 사용자로부터 입력 받은 자동차 이름
     */
    public void createCars(String[] carNames){
        //Arrays.stream(carNames).forEach(name -> carRepository.save(new Car(name)));
        Arrays.stream(carNames).map(Car::new).forEach(carRepository::save);
    }

    /**
     * 각각의 자동차가 전진하거나 멈출 수 있는 메서드
     * @param names 자동차 이름
     * @return {이름 : 전진횟수}
     */
    public Map<String,Integer> moveCars(String[] names){
        Map<String,Integer> dto = new LinkedHashMap<>();
        for(String name:names){
            Car car = carRepository.findByName(name);
            car.move();
            dto.put(name,car.getPosition());
        }
        return dto;
    }

    /**
     * 가장 멀리 전진한 우승자 이름을 반환하는 메서드
     * @return 우승자 이름 리스트
     */
    public List<String> findWinner(){
        ArrayList<Car> cars = carRepository.findAll();
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(() -> new IllegalStateException("레이싱카가 존재하지 않습니다."));
        return cars.stream().filter(c -> c.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }
}
