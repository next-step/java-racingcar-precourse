package service;

import java.util.List;
import model.CarModelInterface;

// 여러 대의 차가 배치된 경기에 대한 비즈니스 로직을 담은 service
public interface RaceServiceInterface {

    // model로부터 car의 총 개수를 받아서 다시 반환하는 메서드
    int getNumberOfCars();

    // model로부터 round의 총 횟수를 받아서 다시 반환하는 메서드
    int getNumberOfRounds();

    // model로부터 car의 정보를 받아서 다시 반환하는 메서드
    List<CarModelInterface> getCars();

    // 비즈니스 로직: model로부터 여러 정보를 받아 winner를 뽑아내는 메서드.
    // 이 부분은 model의 내부 구조에 대해 자세히 알 필요도 없고
    // setter를 사용해서 값을 변경하지도 않으므로, service에 배치했다.
    List<CarModelInterface> getWinners();

    // model에게 차의 이름 목록을 넘겨주어 차를 추가하는 메서드
    void addCars(String[] carsName);

    // model에게 round의 횟수를 넘겨주어 경기를 준비하는 메서드
    void prepareRace(String rounds);

    // model에게 요청하여 실제로 경기를 시작하게 하는 메서드
    void startRace();
}
