package com.tjnam.racingcargame;

import java.util.Scanner;

public class RacingTimeInputGetter {
    private static final Scanner racingTimeScanner = new Scanner(System.in);

    public int getUserInput(){
        boolean inputResult = false;
        int userInput;
        this.printRacingInputGuideMessage();

        do {
            userInput = this.getUserRacingTimeInput();
            inputResult = isValidateRacingTime(userInput);
        } while (inputResult);

        return userInput;
    }

    private int getUserRacingTimeInput(){
        return racingTimeScanner.nextInt();
    }

    private void printRacingInputGuideMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private boolean isValidateRacingTime(int userInput){
        return userInput <= 0;
    }



}
