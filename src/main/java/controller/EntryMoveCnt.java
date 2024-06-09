package controller;

import java.util.*;

public class EntryMoveCnt {
    public static int getMoveCnt() {
        int moveCnt;
        while (true) {
            try {
                moveCnt = input();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moveCnt;
    }

    public static int input() throws IllegalArgumentException {//사용자에게 시도 횟수를 입력받는 기능
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        int moveCnt;
        try {
            moveCnt = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR] : 시도 횟수는 숫자가 와야합니다");
        }

        if (moveCnt <= 0 )
            throw new IllegalArgumentException("[ERROR] : 시도 횟수는 숫자 1이상이여야 합니다");


        return moveCnt;
    }
}