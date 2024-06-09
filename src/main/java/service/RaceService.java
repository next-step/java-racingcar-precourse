package service;

import java.util.List;
import java.util.stream.Collectors;
import model.RaceModelInterface;
import observer.Observer;
import observer.Subject;

// model과 service를 분리해서 service는 비즈니스 로직만 갖도록 함.
public class RaceService implements Subject, RaceServiceInterface {

    private RaceModelInterface race;
    private Subject subject;

    // 생성자
    public RaceService(RaceModelInterface race, Subject subject) {
        this.race = race;
        this.subject = subject;
    }

    // model의 getter
    @Override
    public int getNumberOfCars() {
        return race.getNumberOfCars();
    }

    // model의 getter
    @Override
    public List<CarServiceInterface> getCars() {
        return race.getCars();
    }

    // controller가 넘겨준 차 목록을 추가하는 메서드
    @Override
    public void addCars(String[] carsName) throws IllegalArgumentException {
        race.addCars(carsName);
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

    // 비즈니스 로직: 우승자의 목록이 필요하다.
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
    public void prepareRace(String rounds)
        throws IllegalArgumentException {
        // rounds를 전달.
        race.prepareRace(rounds);
    }

    // cars를 하나씩 출발시키는 작업을 n번 반복하는 메서드
    @Override
    public void startRace() {
        race.startRace();
    }

    // observer를 추가하는 메서드
    @Override
    public void addObserver(Observer observer) {
        subject.addObserver(observer);
    }

    // observer를 삭제하는 메서드
    @Override
    public void removeObserver(Observer observer) {
        subject.removeObserver(observer);
    }

    // observer들을 update하는 메서드
    @Override
    public void notifyObservers() {
        subject.notifyObservers();
    }
}
