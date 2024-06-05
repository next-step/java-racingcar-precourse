package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    public ArrayList<CarServiceInterface> getCars() {
        return race.getCars();
    }

    // controller가 넘겨준 차 목록을 추가하는 메서드
    @Override
    public void addCars(String[] cars) throws IllegalArgumentException {
        ArrayList<CarServiceInterface> carList = race.getCars();

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

    @Override
    public String getWinners() {
        return null;
    }

    @Override
    public void setNumberOfRounds(String rounds)
        throws IllegalArgumentException, NumberFormatException {
        // 수가 아닌 경우
        int numberOfRounds = Integer.parseInt(rounds);

        // 100보다 큰 입력이 들어온 경우
        if (numberOfRounds > 100) {
            throw new IllegalArgumentException();
        }

        race.setNumberOfRounds(numberOfRounds);
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}
