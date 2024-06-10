package service;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getCarNames() {
        return scanner.nextLine();
    }

    public int getTryCount() {
        while (true) {
            try {
                int tryCount = Integer.parseInt(scanner.nextLine());
                if (tryCount < 1) {
                    throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 정수로 입력 가능합니다.다시 입력해주세요");
                }
                return tryCount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 시도 횟수는 1 이상의 정수로 입력 가능합니다. 다시 입력해주세요.");
            }
        }
    }
}
