package view;

import java.util.Scanner;

public class RacingView {

    private static Scanner sc = new Scanner(System.in);

    public static String printInputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return sc.nextLine();
    }

}
