package domain.race.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final int round;
    private int currRound = 0;
    private final List<Car> carList;

    public Race(List<Car> carList, int round) {
        this.carList = carList;
        this.round = round;
    }

    // 입력받은 라운드만큼 라운드가 진행되었는지 판단하는 함수
    public boolean isFinished() {
        return currRound == round;
    }

    // 현재 경주에 참여중인 모든 자동차에 대해서 한번씩 move() 함수를 수행
    public void game() {
        for (Car car : carList) {
            car.move();
        }
        currRound++;
    }

    // 현재 경주에 참여중인 자동차 인스턴스를 List 로 모아 반환하는 함수
    public List<Car> getCarList() {
        return carList;
    }

    // 현재 cars 중에 가장 앞선 자동차의 이름은 무엇인지 찾아내는 함수
    public List<String> getWinner() {
        List<Car> cars = new ArrayList<>(carList.stream().toList());
        cars.sort((a, b) -> b.getPosition() - a.getPosition());

        List<String> winnerList = new ArrayList<>();
        winnerList.add(cars.get(0).getName());

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == cars.get(0).getPosition()) {
                winnerList.add(cars.get(i).getName());
                continue;
            }
            break;
        }

        return winnerList;
    }
}
