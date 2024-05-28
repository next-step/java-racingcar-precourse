package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Car;
import model.Cars;
import service.GameService;
import util.RandomGenerator;
import view.InputView;

public class GameController {

    private final GameService gameService;

    private static final String DEL = ",";
    private static final int MAX_LENGTH_INPUT = 60;
    private static final int MAX_LENGTH_NAME = 5;
    private static final int MAX_CARS = 10;

    public GameController() {
        this.gameService = new GameService();
    }

    public void startGame() {
        String line1 = InputView.inputFirstLine();
        List<String> carNames = getCarNames(line1);

        String line2 = InputView.inputSecondLine();
        int trials = getTrial(line2);

        Cars cars = createCars(carNames);
        gameService.playGame(cars, trials);
    }

    public List<String> getCarNames(String input) {

        if (input.isEmpty() || input.length() > MAX_LENGTH_INPUT ) {
            throw new IllegalArgumentException("[ERROR] 입력 길이가 맞지 않습니다.");
        }

        StringTokenizer st = new StringTokenizer(input, DEL);
        List<String> cars = new ArrayList<>();

        isContainsEmptyString(input);

        while (st.hasMoreTokens()) {
            String s = st.nextToken().trim(); //쉼표 양옆 공백을 제거
            checkName(s, cars); // 파싱 전 검사 작업, 도중 오류가 있으면 예외를 뱉고 종료
            cars.add(s);
        }

        isValidCounts(cars); //차 입력 개수는 2~10개
        return cars;
    }

    public int getTrial(String input) {
        try {
            int trial = Integer.parseInt(input);
            isValidTrial(trial);

            return trial;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 양식입니다.");
        }
    }

    public Cars createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name:names) {
            cars.add(new Car(name));
        }

        return new Cars(cars);
    }



    private void isValidTrial(int trial) {
        if (trial < 1 || trial > 100) {
            throw new IllegalArgumentException("[ERROR] 1~100 범위 내의 숫자를 입력해주세요.");
        }
    }

    private void checkName(String s, List<String> cars) {
        isValidLength(s); //차 이름은 1~5자
        isDuplicateName(s,cars); //차 이름 중복 불가
    }

    private void isValidCounts(List<String> cars) {
        if (cars.size() < 2 || cars.size() > MAX_CARS) {
            throw new IllegalArgumentException("[ERROR] 입력 가능한 개수를 초과하였습니다.");
        }
    }

    private void isDuplicateName(String s, List<String> cars) {
        if (cars.contains(s)) {
            throw new IllegalArgumentException("[ERROR] 차 이름을 중복되게 입력할 수 없습니다.");
        }
    }

    private void isContainsEmptyString(String input) {
        if (input.startsWith(DEL) || input.endsWith(DEL) || input.contains(DEL+DEL)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 양식입니다.");
        }
    }

    private void isValidLength(String s) {
        if (s.isEmpty() || s.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 양식입니다.");
        }
    }

}
