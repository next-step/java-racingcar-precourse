package racinggame;

public class Validation {


    public static final String ERROR_MSG = "[ERROR] 자동차 이름은 5글자 이하로 해주세요";

    public Boolean checkCarNmaeLen(String carName) {
        if (carName.length() <= 5) {
            return true;
        }
        System.out.println(ERROR_MSG);
        return false;
    }
}
