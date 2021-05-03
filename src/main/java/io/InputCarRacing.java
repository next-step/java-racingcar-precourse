package io;

import java.util.Scanner;

import static util.CarRacingMessage.*;

public class InputCarRacing {

    private String carNames;
    private int turnCnt = 0;
    private final Scanner scan = new Scanner(System.in);


    public String[] inputCarNames() {
        do {
            System.out.println(START_MESSAGE);
            carNames = scan.nextLine().trim();

        } while (!validSpaceInName(carNames));

        return spiltCarName(carNames);
    }

    public static String[] spiltCarName(String carNames) {

        return carNames.split(",");
    }

    public boolean validSpaceInName(String carNames) {
        if (carNames.contains(" ")) {
            System.out.println(SPACE_IS_NOT_ALLOW);
            return false;
        }
        return true;
    }

    public int inputTurnCnt() {
        do {
            System.out.println(INPUT_NUMBER_MESSAGE);
        } while (isInputTurnCntAgain());
        return this.turnCnt;
    }

    public boolean isInputTurnCntAgain() {

        try {
            turnCnt = scan.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_NUMBER_AGAIN_MESSAGE);
            return true;
        } catch (ArithmeticException e) {
            System.out.println(OVER_INT_RANGE);
        }

        return false;
    }



}
