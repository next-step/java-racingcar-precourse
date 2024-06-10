package model;

import java.util.List;

// 여러 대의 차가 배치된 경기에 대한 model
public interface RaceModelInterface {

    // 차의 총 개수를 반환하는 메서드
    int getNumberOfCars();

    // 라운드 횟수를 반환하는 메서드
    int getNumberOfRounds();

    // race 시작 전, controller를 통해 받은 round의 횟수를 저장하는 메서드
    // 조건 검사가 들어 있고, setter를 지양하기 위해
    // 해당 메서드에서는 조건 검사를 마치고 private으로 선언된 setter를 이용해 round를 설정한다.
    void prepareRace(String rounds);

    // car 목록을 반환하는 메서드
    List<CarModelInterface> getCars();

    // car 목록을 추가하는 메서드
    // 마찬가지로 조건 검사 및 setter 지양 목적
    void addCars(String[] carsName);

    // race를 시작하는 메서드
    // service와 model 중 어디에 배치할지 고민했지만,
    // model의 변수(cars)에 값의 변경을 요구하기 때문에 책임을 분리하고자 model에 배치했다.
    void startRace();
}
