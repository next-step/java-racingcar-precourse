package racinggame.ui;

import racinggame.domain.*;

public class ResultView {

    private static final String EXECUTION_RESULT = "실행 결과";

    public static void finish(Racing racing) {
        System.out.println(EXECUTION_RESULT);

        Cars resultGame = racing.start();

        printWinners(new Winners(resultGame));
    }

    private static void printWinners(Winners winners){
        System.out.println("최종 우승자는 " + winners.getWinners() + " 입니다.");
    }

    public static void lineBreak(){
        System.out.println("");
    }


    public static void printPlayResult(Name name, MoveCount moveCount) {
        System.out.print(name.getName() + " : ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < moveCount.getMoveCount(); i++) {
            sb.append("-");
        }

        System.out.print(sb);
    }
}
