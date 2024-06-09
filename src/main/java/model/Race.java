package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import observer.Observer;
import observer.Subject;

// model과 service를 분리해서 model에 관련된 로직만 갖도록 함.
public class Race implements Subject, RaceModelInterface {

    private int numberOfRounds;
    private List<CarModelInterface> cars;
    private List<Observer> observers;

    public Race() {
        this.numberOfRounds = 0;
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    // getter
    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

    // getter
    @Override
    public List<CarModelInterface> getCars() {
        return cars;
    }

    // setter
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
        List<Car> cars = Arrays.stream(carsName).map(carName -> new Car(carName, 0))
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

    // 차들의 정보가 바뀐 후에 실행되는 메서드.
    private void carsChanged() {
        // 옵저버들에게 알림
        // 지금은 하나의 역할만 수행하지만, 단일 책임 + 확장을 위해 메서드를 분리
        notifyObservers();
    }

    // cars를 하나씩 출발시키는 작업을 n번 반복하는 메서드
    @Override
    public void startRace() {
        // 횟수만큼 반복
        for (int i = 0; i < numberOfRounds; i++) {
            // 모든 차들에 대해 경주 시작
            cars.stream().forEach(car -> car.moveOrNot());
            // 차들의 변경이 일어났으므로 이를 처리하는 메서드를 호출
            carsChanged();
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
