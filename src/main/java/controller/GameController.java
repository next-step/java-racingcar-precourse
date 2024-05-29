package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Car;
import model.Cars;
import service.GameService;
import view.InputView;

public class GameController {

    private final GameService gameService;
    public static final String DEL = ",";
    public static final int MAX_LENGTH_INPUT = 60;


    public GameController() {
        this.gameService = new GameService();
    }

    public void startGame() {
        List<String> carNames = getFirstLine();
        int trials = getSecondLine();

        Cars cars = Cars.createCars(carNames);
        gameService.playGame(cars, trials);
    }

    public List<String> getFirstLine() {
        List<String> carNames;

        while (true) {
            try {
                String line1 = InputView.inputFirstLine();
                carNames = getCarNames(line1);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + '\n');
            }
        }

        return carNames;
    }

    private int getSecondLine() {
        int trials;

        while (true) {
            try {
                String line2 = InputView.inputSecondLine();
                trials = getTrial(line2);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + '\n');
            }
        }

        return trials;
    }

    public List<String> getCarNames(String input) {

        if (input.isEmpty() || input.length() > MAX_LENGTH_INPUT ) {
            throw new IllegalArgumentException("[ERROR] 입력 길이가 맞지 않습니다.");
        }

        StringTokenizer st = new StringTokenizer(input, DEL);
        List<String> cars = new ArrayList<>();

        Car.checkContainsEmpty(input);

        while (st.hasMoreTokens()) {
            String s = st.nextToken().trim(); //쉼표 양옆 공백을 제거
            Car.isValidCarNames(s, cars); // 파싱 전 검사 작업, 도중 오류가 있으면 예외를 뱉고 종료
            cars.add(s);
        }

        Car.checkCarsCount(cars); //차 입력 개수는 2~10개
        return cars;
    }

    public int getTrial(String input) {
        try {
            int trial = Integer.parseInt(input);
            checkTrialBoundary(trial);

            return trial;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 양식입니다.");
        }
    }

    private void checkTrialBoundary(int trial) {
        if (trial < 1 || trial > 100) {
            throw new IllegalArgumentException("[ERROR] 1~100 범위 내의 숫자를 입력해주세요.");
        }
    }


}
