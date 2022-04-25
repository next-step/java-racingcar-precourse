package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] userName(){
        while(true){
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");

            String[] userInput = Validation.checkDriverName(Console.readLine().split(","));
            if(userInput!=null){
                return userInput;
            }
        }
    }

    public static int round(){
        while(true){
            System.out.println("시도할 횟수 : ");

            int userInput = Validation.checkRound(Console.readLine());
            if(0!=userInput){
                return userInput;
            }
        }
    }
}