package racingcar.view;

import racingcar.domain.Code;
import racingcar.domain.Validate;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarName() {

        try {
            System.out.print(Code.INPUT_NAME_MSG);
            String carNames = scanner.nextLine();
            Validate.carNameChk(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarName();
        }
    }

    public static int inputTurn() {

        try {
            System.out.print(Code.INPUT_TURN_MSG);
            String turn = scanner.nextLine();
            return Integer.parseInt(turn);
        } catch (IllegalArgumentException e) {
            System.out.println(Code.NOT_NUM_ERROR);
            return inputTurn();
        }
    }
}
