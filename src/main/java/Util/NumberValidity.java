package Util;

import VIew.OutputView;

import java.io.IOException;

public class NumberValidity {

    private NumberValidity() {

    }

    // 올바른 숫자인지 아닌지 체크하는 최종 메소드
    public static boolean checkNumberValidity(String number)throws IOException {
       try {
           makeErrorIfNumberIsFalse(number);
           return true;
       }catch (IllegalArgumentException illegalArgumentException){
           OutputView.outputLine("[Error]올바른 숫자가 아닙니다. 다시 입력하세요");
           return false;
       }
    }
    // 올바른 숫자가 아니면 에러 발생시키는 메소드
    private static void  makeErrorIfNumberIsFalse(String number) {
        if(!checkTotalValidity(number)){
            throw new IllegalArgumentException("[Error]올바른 숫자가 아닙니다.");
        }
    }
    // int 형과 음수 체크하는 메소드
    private static boolean checkTotalValidity(String number) {
        if (!checkNumberIsInt(number)) { //int형이 아닌경우
            return false;
        }
        if (!checkNumberRange(number)) { //음수인 경우
            return false;
        }
        return true; //올바른 값
    }

    // int 자료형인지 확인하는 메소드
    private static boolean checkNumberIsInt(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 1이상인 int형 정수인지 확인하는 메소드, checkNumberIsInt이후에 쓰이므로 음수인지만 체크
    private static boolean checkNumberRange(String number) {
        int changedNumber = Integer.parseInt(number);
        return 1 <= changedNumber;
    }

}
