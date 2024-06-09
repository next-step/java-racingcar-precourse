package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import observer.Observer;
import observer.Subject;
import service.CarService;
import service.CarServiceInterface;

// model과 service를 분리해서 model에 관련된 로직만 갖도록 함.
public class Race implements Subject, RaceModelInterface {

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

    private void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    // 제대로 된 입력이 들어왔는지 확인하는 메서드
    private void verifyNumberOfCars(String[] carsName) throws IllegalArgumentException {
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
        verifyNumberOfCars(carsName);
        // 검사가 끝났으면 객체 리스트를 생성
        List<CarService> cars = Arrays.stream(carsName).map(carName -> new CarService(carName, 0))
            .collect(Collectors.toList());
        // 추가
        this.cars.addAll(cars);
    }

    // 경주 시작 전 round 설정하는 메서드
    @Override
    public void prepareRace(String rounds) throws IllegalArgumentException {
        // 수로 변환.
        int numberOfRounds = Integer.parseInt(rounds);
        // 유효성 검사
        verifyNumberOfRounds(numberOfRounds);
        // setter를 통해 값 설정
        setNumberOfRounds(numberOfRounds);
    }

    private void verifyNumberOfRounds(int numberOfRounds) throws IllegalArgumentException {
        // 100보다 큰 입력이 들어온 경우
        if (numberOfRounds > 100) {
            throw new IllegalArgumentException();
        }
    }

    // observer를 추가하는 메서드
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // observer를 삭제하는 메서드
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // observer들을 update하는 메서드
    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.update());
    }
}
