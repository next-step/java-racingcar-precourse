package view;

import java.util.List;

public class WinnerView {
    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

