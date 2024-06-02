package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printCarInputQuestion() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printIterationInputQuestion() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static String[] inputCarName() {
        while (true) {
            String[] splitedCarNames = inputName();
            if (splitedCarNames != null) return splitedCarNames;
        }
    }

    private static String[] inputName() {
        try {
            String[] splitedCarNames = scanner.nextLine()
                    .split(",");
            validateSplitedCarName(splitedCarNames);
            return splitedCarNames;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            printCarInputQuestion();
        }
        return null;
    }

    private static void validateSplitedCarName(String[] splitCarNmae) {
        for (String s : splitCarNmae) {
            validateCarName(s);
        }
    }

    private static void validateCarName(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static int inputGameIteration() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }


}
