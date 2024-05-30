package controller;

import static model.Car.*;
import static model.Cars.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
        Cars cars = createCars(getCarNames());
        Trial trial = getTrial();

        gameService.playGame(cars, trial);
    }

    public List<String> getCarNames() {
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

    private Trial getTrial() {
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

        if (input.isEmpty() || input.length() > MAX_LENGTH_INPUT) {
            throw new IllegalArgumentException("[ERROR] 입력 길이가 맞지 않습니다.");
        }

        StringTokenizer st = new StringTokenizer(input, DEL);
        List<String> carNames = new ArrayList<>();

        checkContainedEmpty(input);//입력 문자열 사이에 빈 문자열이 있는지 검사
        parsing(st, carNames);
        checkCarsCount(carNames); //최종적으로 파싱된 차 개수는 2~10개이여야 한다.

        return carNames;
    }

    private void parsing(StringTokenizer st, List<String> carNames) {
        while (st.hasMoreTokens()) {
            String s = st.nextToken().trim(); //쉼표 양옆 공백을 제거
            isValidCarNames(s, carNames); // 파싱 전 검사 작업, 도중 오류가 있으면 예외를 뱉고 종료
            carNames.add(s);
        }
    }


}
