import java.util.List;
import java.util.Scanner;

public class GameManager {
    private final InputManager inputManager = new InputManager();
    private final Race race = new Race();
    private final ResultEvaluator resultEvaluator = new ResultEvaluator();

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // 유효한 자동차 이름 입력 받기
        List<Car> cars = inputManager.getCars(scanner);

        // 유효한 이동 횟수 입력 받기
        int attempts = inputManager.getAttempts(scanner);

        // 경주 진행
        for (int i = 0; i < attempts; i++) {
            race.moveCars(cars);
            race.printCars(cars);
        }

        // 결과 출력
        List<String> winners = resultEvaluator.getWinners(cars);
        System.out.println("최종 우승자: " + String.join(",", winners));
    }
}
