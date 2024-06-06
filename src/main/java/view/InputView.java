package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        for (String carName : carNames) {
            if(carName.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
            }
        }
        return carNames;
    }

    public static int getNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
