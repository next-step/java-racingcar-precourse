package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Message;
import racingcar.model.Car;

public class Prompt {

    //Instance
    private static Prompt instance;

    //private construct
    private Prompt() {
    }

    public static Prompt getInstance() {
        if (instance == null) {
            instance = new Prompt();
        }
        return instance;
    }

    public void printInterimResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void printFinalResults(List<String> car_names) {
        System.out.print(Message.WINNER.getValue() + String.join(",", car_names));
    }

    public String getCarNames() {
        System.out.println(Message.REQUEST_CAR_NAME.getValue());
        return Console.readLine();
    }

    public int getGameCount() {
        System.out.println(Message.REQUEST_GAME_COUNT.getValue());
        return Integer.parseInt(Console.readLine());
    }
}