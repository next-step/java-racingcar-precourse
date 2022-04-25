package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collection;

public class GameView {

    /**
     * 차량 위치 출력 함수
     *
     * @param name     차량 이름
     * @param location 차량 위치
     */
    public void printCarLocation(String name, Integer location) {
        System.out.print(name + " : ");
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * 엔딩 출력 함수
     *
     * @param winnerNames 승자 이름 리스트
     */
    public void printEnding(Collection<String> winnerNames) {
        System.out.print("최종 우승자: " + String.join(", ", winnerNames));
    }

    /**
     * 자동차 이름 입력 화면 출력 함수
     *
     * @return 입력된 콘솔 값
     */
    public String queryCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    /**
     * 턴 입력 화면 출력 함수
     *
     * @return 입력된 콘솔 값
     */
    public String queryTurnCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
