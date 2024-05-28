package view;

import java.util.*;

/**
 * 출력을 담당하는 클래스
 */
public class OutputView {

    private static final String RESULT_STRING = "\n실행 결과";
    private static final String WINNER_STRING = "최종 우승자 : ";

    /**
     * "실행 결과" 문자열을 출력하는 클래스
     */
    public static void printResultString() {
        System.out.println(RESULT_STRING);
    }

    /**
     * 게임 진행 상황을 출력하는 메서드
     * @param carPosition 자동차 이름과 위치 정보
     */
    public static void printProcess(Map<String, String> carPosition) {
        for (String carName : carPosition.keySet()) {
            System.out.println(carName + " : " + carPosition.get(carName));
        }
        System.out.println();
    }

    /**
     * 우승자를 출력하는 메서드
     * @param winners 우승자 목록
     */
    public static void printWinners(List<String> winners) {

        System.out.print(WINNER_STRING);
        System.out.print(winners.get(0));

        if (winners.size() == 1) {
            return;
        }

        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i));
        }

        System.out.println();
    }
}
