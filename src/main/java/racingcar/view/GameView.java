package racingcar.view;

import java.util.List;

public class GameView {

    public GameView() {
    }

    public void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCarPosition(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinnerCars(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

}
