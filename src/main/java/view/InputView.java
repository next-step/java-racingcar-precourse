package view;

import java.util.Scanner;

public class InputView {
    public static void printCarInputQuestion() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printIterationInputQuestion() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static String inputCarName() {
        Scanner scanner = new Scanner(System.in);
        String carsName = scanner.nextLine();
        scanner.close();
        return carsName;
    }

    public static int inputGameIteration() {
        Scanner scanner = new Scanner(System.in);
        int iteration = scanner.nextInt();
        scanner.close();
        return iteration;
    }


}
