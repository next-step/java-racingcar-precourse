package racingcar;

public class ValidationUtils {

    public void valiName(String name){

        if(name.length() >= 6){
            throw new IllegalArgumentException(ErrorMessages.LONG_NAME);
        }
    }

    public void tryNumber(String tryNum){
        if(!tryNum.matches("[0-9]+")){
            throw new IllegalArgumentException(ErrorMessages.NOT_TRY_NUMBER);
        }
    }




}
