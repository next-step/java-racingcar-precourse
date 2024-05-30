package com.mini.caracing.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class GameView {

    public String getCarNamesInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return scanner.nextLine();
    }

    public String getTotalMoveInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");

        return scanner.nextLine();
    }

    public void displayRaceStart() {
        System.out.println("\n실행 결과");
    }

    public void displayCarDistances(LinkedHashMap<String, Integer> carMoves) {
        for (Map.Entry<String, Integer> entry : carMoves.entrySet()) {
            displayOneDistance(entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public void displayOneDistance(String carName, int move) {
        System.out.print(carName + " : ");
        System.out.println("-".repeat(move));
    }

    public void displayWinner(List<String> winnerList) {
        System.out.println("최종 우승자 : " + winnerList.stream().collect(Collectors.joining(", ")));
    }
}
