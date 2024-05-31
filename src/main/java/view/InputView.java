package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CARLIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarList() {
        System.out.println(INPUT_CARLIST_MESSAGE);
        return scanner.nextLine();
    }
}