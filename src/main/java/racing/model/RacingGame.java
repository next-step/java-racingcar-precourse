package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 경주 게임 클래스.
 * 여러 대의 자동차를 관리하고 게임을 진행.
 */
public class RacingGame {
    private final List<Car> cars; // 자동차 목록
    private final int rounds; // 시도할 회수

    /**
     * 생성자.
     * @param carNames 자동차 이름 배열
     * @param rounds 시도할 회수
     */
    public RacingGame(String[] carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    /**
     * 자동차 목록 생성.
     * @param carNames 자동차 이름 배열
     * @return 자동차 목록
     */
    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    /**
     * 게임을 진행.
     * 지정된 회수만큼 모든 자동차를 전진시킴.
     */
    public void play() {
        for (int i = 0; i < rounds; i++) {
            playRound();
        }
    }

    /**
     * 한 라운드 진행.
     */
    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    /**
     * 모든 자동차의 현재 상태를 반환.
     * @return 자동차 상태 리스트
     */
    public List<String> getCarStatuses() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }

    /**
     * 우승자 반환.
     * 가장 멀리 간 자동차(들)의 이름을 반환.
     * @return 우승자 이름 문자열
     */
    public String getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    /**
     * 가장 멀리 간 위치 반환.
     * @return 가장 멀리 간 위치
     */
    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
