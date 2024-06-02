package View;

import java.util.Scanner;

public class Input {
    private static final Scanner sc =  new Scanner(System.in);

    public static String[] getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine().split(",");
    }

    public static int getMoveNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        int number = Integer.parseInt(sc.nextLine());
        try{
            if(number < 1 ){
                throw new IllegalArgumentException("[ERROR] 횟수는 1보다 커야합니다.");
            }
            return number;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("다시 입력해주세요.");
        }
    }
}
