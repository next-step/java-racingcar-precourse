package racingcar;

public class ValidationUtil {
    public static boolean checkRacingGameNameInput(String inputName) {
        String[] inputNames = inputName.split(",");

        for (String name : inputNames){
            try{
                checkNameLength(name);
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 사용자 이름은 5글자 미만이어야 합니다.");
                return false;
            }
        }

        return true;
    }

    private static void checkNameLength(String name) {
        if(name.length() >= 5){
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkGameCount(String inputGameCount) {
        try{
            checkGameCountNumberFormat(inputGameCount);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 시도 횟수는 숮자여야 합니다.");
            return false;
        }

        return true;
    }

    private static void checkGameCountNumberFormat(String inputGameCount) {
        try{
            Integer.parseInt(inputGameCount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
