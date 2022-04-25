package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RaceGame {
    private static final int MOVING_FORWARD = 4;
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int STOP = 3;

    public String inputCarName(){
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String temp = Console.readLine();
            splitValidation(temp);
            for(String item : inputArray(temp)){
                lengthValidation(item);
            }
            return temp;
        }catch(IllegalArgumentException e){
            System.out.println(throwErrorMessage(e.getMessage()));
            return inputCarName();
        }
    }
    public String[] inputArray(String inputString){
        return inputString.split(",");
    }
    public String throwErrorMessage(String message){
        return ERROR_MESSAGE+message;
    }

    public void lengthValidation(String inputString ) throws IllegalArgumentException{
        if(lengthCondition(inputString)) throw new IllegalArgumentException("자동차 이름을 5자를 넘지않게 해주세요.");
    }

    private boolean lengthCondition(String inputString) {
        return inputString.length() > 5;
    }

    public void splitValidation(String inputString) throws IllegalArgumentException{
        if(stringCondition(inputString)) throw new IllegalArgumentException ("입력 형식이 맞지 않습니다.");
    }

    private boolean stringCondition(String inputString) {
        return !Pattern.matches("^[,a-zA-Z]*$", inputString)
                || inputString.startsWith(",")
                || inputString.endsWith(",");
    }

    public int inputRandomNumber() {
        return pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public int inputGameCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }catch(Exception e){
            throwErrorMessage("숫자가 아닙니다.");
            return inputGameCount();
        }
    }
}
