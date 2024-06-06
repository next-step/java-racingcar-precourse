package view;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static void printCarInputQuestion() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void printIterationInputQuestion() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static List<String> inputCarName() {
        while (true) {
            printCarInputQuestion();
            List<String> splitedCarNames = inputName();
            if (splitedCarNames != null) return splitedCarNames;
        }
    }

    private static List<String> inputName() {
        try {
            List<String> splitedCarNames = List.of(scanner.nextLine()
                    .split(","));
            splitedCarNames = splitedCarNames.stream()
                    .map(String::strip)
                    .toList();
            validateSplitedCarName(splitedCarNames);
            return splitedCarNames;
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return null;
    }

    private static void validateSplitedCarName(List<String> splitCarNmae) {
        for (String s : splitCarNmae) {
            validateCarNameNull(s);
            validateCarNameLength(s);
        }
    }

    private static void validateCarNameNull(String s) {
        if (s.isEmpty()) {
            // System.out.println(s);
            throw new IllegalArgumentException("공백은 허용 되지 않습니다.");
        }
    }


    private static void validateCarNameLength(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static int inputGameIteration() {
        printIterationInputQuestion();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }


}
