package view;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static String[] getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine().split(",");
    }

    public static int getRound() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                int round = Integer.parseInt(sc.nextLine());
                if (round <= 0) {
                    throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다");
                }
                return round;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
