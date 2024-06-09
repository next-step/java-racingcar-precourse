package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import observer.Observer;
import service.CarService;
import service.CarServiceInterface;

// model과 service를 분리.
public class Race implements RaceModelInterface {

    private int numberOfRounds;
    private List<CarServiceInterface> cars;
    private List<Observer> observers;

    public Race() {
        this.numberOfRounds = 0;
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

    @Override
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    @Override
    public List<CarServiceInterface> getCars() {
        return cars;
    }

    @Override
    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    // 제대로 된 입력이 들어왔는지 확인하는 메서드
    private void verifyNumberOfRounds(String[] carsName) throws IllegalArgumentException {
        // 빈 입력이 들어온 경우도 예외를 반환
        if (carsName.length == 0) {
            throw new IllegalArgumentException();
        }

        // cars의 원소 중에 길이가 5 이상인 것이 있다면 예외를 반환
        boolean isWrongArgument = Arrays.stream(carsName).anyMatch(car -> car.length() > 5);
        if (isWrongArgument) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    // 차를 추가하는 메서드
    public void addCars(String[] carsName) throws IllegalArgumentException {
        // 유효성 검사부터
        verifyNumberOfRounds(carsName);
        // 검사가 끝났으면 객체 리스트를 생성
        List<CarService> cars = Arrays.stream(carsName).map(carName -> new CarService(carName, 0))
            .collect(Collectors.toList());
        // 추가
        this.cars.addAll(cars);
    }

}
