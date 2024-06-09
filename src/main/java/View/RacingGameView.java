package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Model.RacingGameCar;

public class RacingGameView {
    public void printStartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRepeatMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExceptionMessage(){
        System.out.println("[ERROR] 잘못된 입력입니다.");
    }

    // 입력받고 올바른 문자열일때까지 반복 후 parsing + return
    public String[] inputCarName(){
        RacingGameExceptionHandler handler = new RacingGameExceptionHandler();
        while(true) {
            Scanner scanner = new Scanner(System.in);
            printStartMessage();
            String input = scanner.nextLine();
            try{
                if(!handler.isRightString(input)) throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
                return input.split(",");
            }catch(IllegalArgumentException e){
                printExceptionMessage();
            }
        }
    }

    // 입력받고 올바른 정수일때까지 반복 후 parsing + return
    public int inputRepeatCount(){
        RacingGameExceptionHandler handler = new RacingGameExceptionHandler();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            printRepeatMessage();
            try {
                String repeatCount = scanner.nextLine(); // 문자 입력 받기
                if (!handler.isInt(repeatCount) || Integer.parseInt(repeatCount)<=0) throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
                return Integer.parseInt(repeatCount);
            } catch (IllegalArgumentException e) {
                printExceptionMessage(); // 입력 버퍼를 비워줌
            }
        }
    }

    public void printState(RacingGameCar[] list){
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
    }
}
