package racing.view;

import java.util.List;

/**
 * 게임 결과를 출력하는 클래스.
 */
public class ResultView {
    public void printRoundResult(List<String> carStatuses) {
        for (String status : carStatuses) {
            System.out.println(status);
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
