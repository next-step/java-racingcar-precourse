package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.Race;
import model.RaceModelInterface;
import observer.Observer;
import observer.Subject;

public class RaceService implements Subject, RaceServiceInterface {

    private RaceModelInterface race;

    // 생성자:
    public RaceService() {
        race = new Race();
    }

    @Override
    public int getNumberOfCars() {
        return race.getNumberOfCars();
    }

    @Override
    public int getNumberOfRounds() {
        return race.getNumberOfRounds();
    }

    @Override
    public List<CarServiceInterface> getCars() {
        return race.getCars();
    }

    // controller가 넘겨준 차 목록을 추가하는 메서드
    @Override
    public void addCars(String[] cars) throws IllegalArgumentException {
        List<CarServiceInterface> carList = race.getCars();

        // 빈 입력이 들어온 경우도 예외를 반환
        if (cars.length == 0) {
            throw new IllegalArgumentException();
        }

        // cars의 원소 중에 길이가 5 이상인 것이 있다면 예외를 반환
        boolean isWrongArgument = Arrays.stream(cars).anyMatch(carName -> carName.length() > 5);
        if (isWrongArgument) {
            throw new IllegalArgumentException();
        }

        // 그렇지 않다면 차 목록을 추가
        List<CarService> tempList = Arrays.stream(cars).map(carName -> new CarService(carName, 0))
            .collect(Collectors.toList());
        carList.addAll(tempList);
    }

    // 우승자의 진행도를 반환하는 메서드
    private int getWinnersProgress() {
        // 차들의 정보를 가져와서
        List<CarServiceInterface> carList = race.getCars();

        // 진행도의 최댓값을 구한다.
        int winnersProgress = 0;
        for (CarServiceInterface car : carList) {
            winnersProgress = Math.max(winnersProgress, car.getProgress());
        }

        return winnersProgress;
    }

    // 우승자의 목록을 반환한다.
    @Override
    public List<CarServiceInterface> getWinners() {
        // 차들의 정보를 가져오고
        List<CarServiceInterface> carList = race.getCars();
        // 우승자의 진행도를 가져온다.
        int winnersProgress = getWinnersProgress();

        // 우승자의 진행도를 바탕으로 우승자 목록을 stream으로 가져온다.
        List<CarServiceInterface> winners = carList.stream()
            .filter(car -> car.getProgress() == winnersProgress).collect(Collectors.toList());

        return winners;
    }

    // controller에게 받은 round 정보를 설정하는 메서드
    @Override
    public void setNumberOfRounds(String rounds)
        throws IllegalArgumentException {
        // 수가 아닌 경우
        int numberOfRounds = Integer.parseInt(rounds);

        // 100보다 큰 입력이 들어온 경우
        if (numberOfRounds > 100) {
            throw new IllegalArgumentException();
        }

        race.setNumberOfRounds(numberOfRounds);
    }

    // observer를 추가하는 메서드
    @Override
    public void addObserver(Observer observer) {
        List<Observer> observers = race.getObservers();
        observers.add(observer);
    }

    // observer를 삭제하는 메서드
    @Override
    public void removeObserver(Observer observer) {
        List<Observer> observers = race.getObservers();
        observers.remove(observer);
    }

    // observer들을 update하는 메서드
    @Override
    public void notifyObservers() {
        List<Observer> observers = race.getObservers();
        observers.stream().forEach(observer -> observer.update());
    }
}
