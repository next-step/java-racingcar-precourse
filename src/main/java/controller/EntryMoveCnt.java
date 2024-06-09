package controller;

import java.util.*;

public class EntryMoveCnt {
    public static int getMoveCnt() {
        int moveCnt;
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                Scanner scanner = new Scanner(System.in);
                String in = scanner.nextLine();
                moveCnt = input(in);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moveCnt;
    }

    public static int input(String in) throws IllegalArgumentException {//사용자에게 시도 횟수를 입력받는 기능
        int moveCnt=-1;
        try {
            moveCnt= Integer.parseInt(in);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 시도 횟수는 숫자가 와야합니다");
        }

        if (moveCnt <= 0 )
            throw new IllegalArgumentException("[ERROR] : 시도 횟수는 숫자 1이상이여야 합니다");


        return moveCnt;
    }
}