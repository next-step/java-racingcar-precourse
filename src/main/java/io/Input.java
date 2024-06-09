package io;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return scanner.next();
    }

    public String getRaceCount(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.next();
    }

    public String deleteSpace(String raceInput){
        return raceInput.replace(" ", "");
    }
}
