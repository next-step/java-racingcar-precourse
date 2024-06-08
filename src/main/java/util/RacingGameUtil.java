package util;

public class RacingGameUtil {

    public static String checkIfCarnameIsValid(String carname) throws NullPointerException, IllegalArgumentException {
        if  (carname ==null){
            throw new NullPointerException(" 자동차의 이름이 비어있음");
        }if (carname.contains(" ")) {
            throw new  IllegalArgumentException("자동차 이름에 공백이 포함됌");
        }if (carname.length() > 5) {
            throw new  IllegalArgumentException("자동차 이름이 5자를 넘어감");
        }

        return carname;
    }


}
