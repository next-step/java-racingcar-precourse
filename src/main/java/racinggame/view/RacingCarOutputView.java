package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.enums.MessageEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingCarOutputView {
    private static final String COMMA = ",";

    private RacingCarOutputView() {

    }

    public static void printCarInputMessage() {
        System.out.println(MessageEnum.INITIAL_INPUT_MESSAGE.getMessage());
    }

    public static void printTryCountInputMessage() {
        System.out.println(MessageEnum.INITIAL_INPUT_NUMBER_OF_ATTEMPTS.getMessage());
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printCarStatus(Map<String, String> statusMap) {
        System.out.println(MessageEnum.EXECUTION_RESULT_MESSAGE.getMessage());

        for (String name : statusMap.keySet()) {
            System.out.println(name + " : " + statusMap.get(name));
        }

        System.out.println();
    }

    public static void printWinners(Cars cars) {
        List<String> winnersName = new ArrayList<>();

        for (Car car : cars.getCars()) {
            winnersName.add(car.getName());
        }

        String winnersNames = String.join(COMMA, winnersName);

        System.out.println(MessageEnum.WINNERS_MESSAGE.getMessage() + winnersNames
                + MessageEnum.END_OF_SENTENCE_MESSAGE.getMessage());
    }

}
