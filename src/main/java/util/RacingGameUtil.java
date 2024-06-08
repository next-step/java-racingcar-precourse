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


    public static int setRounds (String inputValue ) throws IllegalArgumentException{
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException("라운드 횟수가 빈 값이다.");
        }
        if (!inputValue.matches("\\d+")) {
            throw new IllegalArgumentException("라운드 횟수는 정수여야합니다.");
        }
        int rounds = Integer.parseInt(inputValue);
        if (rounds < 1 || rounds > 12) {
            throw new IllegalArgumentException("라운드 횟수는 1~12 사이의 값이어야합니다.");
        }
        return rounds;
    }

}
