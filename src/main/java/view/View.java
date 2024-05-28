package view;

import java.util.LinkedList;
import java.util.Scanner;
import model.GameModel;

public class View {
    public View() {}

    public String requestCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public int requestRepeatCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        int repeatCount = scanner.nextInt();
        scanner.nextLine();
        return repeatCount;
    }

    public void printResultText() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printProgress(GameModel gameModel) {
        for (int idx = 0; idx < gameModel.getCarsCount(); ++idx) {
            System.out.print(gameModel.getCar(idx).getName() + " : ");
            StringBuilder distBuf = new StringBuilder();
            for (int dist = 0; dist < gameModel.getCar(idx).getPos(); ++dist) {
                distBuf.append("-");
            }
            System.out.println(distBuf.toString());
        }
        System.out.println();
    }

    public void printWinners(LinkedList<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size() - 1; ++i) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.println(winners.get(winners.size() - 1));
    }
}

