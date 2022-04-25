package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Cars cars = getCars();
        int tryNumber = getInputTryNumber();

        Game game = new Game(cars);
        game.setTryNumber(tryNumber);
        game.start();

    }

    public static Cars makeCars(String inputString) {
        List<String> carNames = Util.splitComma(inputString);
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            carList.add(car);
        }

        return new Cars(carList);
    }

    private static Cars getCars() {
        String carNames = inputCarNames();
        Cars cars;

        try {
            cars = makeCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하여야 한다.");
            return getCars();
        }

        return cars;
    }

    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int getInputTryNumber() {

        String inputNumberString = inputTryNumber();

        try {
            validateInputTryNumber(inputNumberString);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return getInputTryNumber();
        }

        return Integer.parseInt(inputNumberString);
    }


    private static String inputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    private static void validateInputTryNumber(String inputNumberString) {
        for (char c : inputNumberString.toCharArray()) {
            if (c > 57 || c < 48) {
                throw new IllegalArgumentException();
            }
        }
    }
}
