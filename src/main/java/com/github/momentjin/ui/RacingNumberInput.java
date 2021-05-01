package com.github.momentjin.ui;

import java.util.Scanner;

public class RacingNumberInput {

    public int execute(Scanner sc) {
        System.out.println("시도할 회수는 몇 회인가요?");
        int gameTryCount = sc.nextInt();
        sc.nextLine();

        return gameTryCount;
    }
}
