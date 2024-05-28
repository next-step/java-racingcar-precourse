package view;

import java.util.*;

public class OutputView {

    private static final String RESULT_STRING = "\n실행 결과";

    public static void printResultString() {
        System.out.println(RESULT_STRING);
    }

    public static void printProcess(Map<String, String> carPosition) {
        for (String carName : carPosition.keySet()) {
            System.out.println(carName + " : " + carPosition.get(carName));
        }
        System.out.println();
    }

}
