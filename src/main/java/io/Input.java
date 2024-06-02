package io;

import java.util.Scanner;

import utils.InputValidator;

public class Input {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static String[] getCarNames() {
        String[] carNames = {};
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
                carNames = scanner.nextLine().split(",");
                InputValidator.validateCarNames(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNames;
    }

    public static int getMoves() {
        String moves;
        
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                moves = scanner.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(moves);
    }
}
