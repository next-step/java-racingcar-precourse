package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class ResultGameService {

    private String[] carNames;
    private int[] gameCount;
    private int max = -1;

    public ResultGameService(String[] carNames, int[] gameCount) {
        this.carNames = carNames;
        this.gameCount = gameCount;
    }

    public void resultGame() {
        System.out.println("각 차수별 실행 결과");
        for (int i = 0; i < carNames.length; i++) {
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(carNames[i]).append(" : ");
            executeGame(resultBuilder, i);
            System.out.println(resultBuilder);
        }
    }

    public void resultGameWin() {
        List<Integer> list = resultWinner();
        soloWinner(list);
        coWinner(list);
    }

    private void coWinner(List<Integer> list) {
        if (list.size() > 1) {
            System.out.println("공동 우승자 안내 문구");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("최종 우승자: ");
            coWinnerNames(stringBuilder, list);
            System.out.println(stringBuilder);
        }
    }

    private void coWinnerNames(StringBuilder stringBuilder, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            firstWinnerName(stringBuilder, list, i);
            secondWinnerName(stringBuilder, list, i);
        }
    }

    private void firstWinnerName(StringBuilder stringBuilder, List<Integer> list, int i) {
        if (i == 0) {
            stringBuilder.append(carNames[list.get(i)]);
        }
    }

    private void secondWinnerName(StringBuilder stringBuilder, List<Integer> list, int i) {
        if (i > 0) {
            stringBuilder.append(", ").append(carNames[list.get(i)]);
        }
    }

    private void soloWinner(List<Integer> list) {
        if (list.size() == 1) {
            System.out.println("단독 우승자 안내 문구");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("최종 우승자: ");
            stringBuilder.append(carNames[list.get(0)]);
            System.out.println(stringBuilder);
        }
    }

    private List<Integer> resultWinner() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < gameCount.length; i++) {
            list = newWinner(list, i);
        }
        return list;
    }

    private List<Integer> newWinner(List<Integer> list, int i) {
        if (max < gameCount[i]) {
            list = new ArrayList<>();
            max = gameCount[i];
            list.add(i);
            return list;
        }
        sameWinner(list, i);
        return list;
    }

    private void sameWinner(List<Integer> list, int i) {
        if (max == gameCount[i]) {
            list.add(i);
        }
    }

    private StringBuilder executeGame(StringBuilder resultBuilder, int i) {
        for (int j = 0; j < gameCount[i]; j++) {
            resultBuilder.append("-");
        }
        return resultBuilder;
    }


}
