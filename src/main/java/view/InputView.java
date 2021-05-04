package view;

import message.Message;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String carNames() {
        System.out.println(Message.GET_CAR_NAMES);
        return scanner.nextLine();
    }

    public static String tryCount() {
        System.out.println(Message.GET_TRY_NUMBER);
        return scanner.nextLine();
    }
}
