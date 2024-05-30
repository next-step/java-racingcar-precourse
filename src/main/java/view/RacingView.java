package view;

import java.util.Scanner;

public class RacingView {

    private static Scanner sc = new Scanner(System.in);

    public static String printInputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return sc.nextLine();
    }
    public static String printInputTryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextLine();
    }

}
