package Util;

public class CheckNumberValidity {

    private CheckNumberValidity() {

    }

    //int자료형으로 변환 할 수 있는지와 1이상인 자연수인지 확인하는 메소드
    public static boolean checkNumberValidity(String number) {
        if (!checkNumberIsInt(number)) { //int형이 아닌경우
            return false;
        }
        if (!checkNumberRange(number)) { //음수인 경우
            return false;
        }
        return true; //올바른 값
    }

    //int 자료형인지 확인하는 메소드
    private static boolean checkNumberIsInt(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //1이상인 int형 정수인지 확인하는 메소드, checkNumberIsInt이후에 쓰이므로 음수인지만 체크
    private static boolean checkNumberRange(String number) {
        int changedNumber = Integer.parseInt(number);
        return 1 <= changedNumber;
    }

}
