package view;

import java.util.Map;

public class MoveView {

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(Map<String, Integer> positions) {
        for (Map.Entry<String, Integer> entry : positions.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }
}
