package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Car;
import model.Cars;
import model.Trial;
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
        Trial trial = getSecondLine();

        Cars cars = Cars.createCars(carNames);
        gameService.playGame(cars, trial);
    }

    public List<String> getFirstLine() {
        List<String> carNames;

        while (true) {
            try {
                String line1 = InputView.inputFirstLine();
                carNames = parsingCarNames(line1);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + '\n');
            }
        }

        return carNames;
    }

    private Trial getSecondLine() {
        Trial trial;

        while (true) {
            try {
                String line2 = InputView.inputSecondLine();
                trial = Trial.getTrial(line2);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + '\n');
            }
        }

        return trial;
    }

    public List<String> parsingCarNames(String input) {

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


}
