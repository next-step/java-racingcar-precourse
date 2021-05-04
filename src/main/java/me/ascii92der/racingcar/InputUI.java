package me.ascii92der.racingcar;

import java.util.Scanner;

public class InputUI {

    private static final Scanner scanner =new Scanner(System.in);
    private  static final String REQUEST_RACING_COUNT = "시도할 회수는 몇회인가요?";
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";


    public static String inputCarNames() {
        System.out.print(REQUEST_CAR_NAMES);
        return scanner.nextLine();
    }

    public static int inputRacingCount() {
        System.out.print(REQUEST_RACING_COUNT);
        return scanner.nextInt();
    }
}
