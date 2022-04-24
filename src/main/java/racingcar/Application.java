package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Controller.Controller;
import racingcar.model.Car;
import racingcar.util.Validation;

import java.util.List;

public class Application {
    private static Validation validation = new Validation();
    private static Controller controller = new Controller();
    private static List<Car> carList;

    public static void main(String[] args) {
        callMakeGameCarList();
        callStartGame();
    }

    private static void callStartGame() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String numberOfExecution = Console.readLine();
        try {
            controller.startGame(carList, numberOfExecution);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            callStartGame();
        }
    }

    private static void callMakeGameCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분");
        String[] names = Console.readLine().split(",");
        try {
            validation.hasNotEnoughParticipant(names);
            validation.isDuplicated(names);
            carList = controller.makeCarList(names);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            callMakeGameCarList();
        }
    }
}
