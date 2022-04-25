package racingcar.util;

public class Validation {
    public static String[] checkDriverName(String[] userInput){
        try{
            for(String driverName : userInput){
                Validation.driverName(driverName);
            }

            return userInput;
        }catch(IllegalArgumentException iae){
            System.out.println("[ERROR] 자동차 이름은 소문자 영문 4자리 쉼표로 구분해서 입력해주세요.");
            return null;
        }
    }

    public static int checkRound(String userInput){
        try{
            int round = Integer.parseInt(userInput);

            round(round);

            return round;
        }catch(IllegalArgumentException iae){
            System.out.println("[ERROR] 0이상 정수로 입력해주세요.");
            return 0;
        }
    }


    public static void driverName(String name) throws IllegalArgumentException {
        if(!name.matches("[a-z]{4}")){
            throw new IllegalArgumentException("invalid user name");
        }
    }

    public static void round(int round) {
        if(round<0){
            throw new IllegalArgumentException("invalid user name");
        }
    }
}
