package com.mini.caracing.view;

import java.util.Scanner;

public class GameView {

    public String getCarNamesInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return scanner.nextLine();
    }

}
