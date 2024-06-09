package utills;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    /**
     * 사용자가 입력한 자동차의 이름이 유효한지 판단하는 메서드
     *
     * @param carNames 사용자가 입력한 이름 배열
     * @throws IllegalArgumentException 유효하지 않은 이름 입력시 발생
     */
    public static void validCheckCarNames(String[] carNames){
        checkLength(carNames);
        checkCount(carNames);
        checkDuplicate(carNames);
        checkAlphaOnly(carNames);
    }

    /**
     * 사용자가 입력한 횟수가 요효한지 판단하는 메서드
     *
     * @param count 사용자가 입력한 횟수
     * @throws IllegalArgumentException 유효하지 않은 이름 입력시 발생
     */
    public static void validCheckCount(String count){
        checkIsInt(count);
        checkRange(count);
    }

    /**
     * 자동차의 이름들의 길이가 5이하인지 체크하는 메서드
     *
     * @param carNames 사용자가 입력한 자동차이름 배열
     */
    private static void checkLength(String[] carNames){
        for(String name:carNames){
            int MAX_LENGTH = 5;
            if (name.isBlank() || name.length() > MAX_LENGTH){
                throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하여야합니다.");
            }
        }
    }

    /**
     * 사용자가 입력한 자동차 이름의 개수가 2개이상 5개 이하인지 체크하는 메서드
     *
     * @param carNames 사용자가 입력한 이름 배열
     */
    private static void checkCount(String[] carNames){
        if (carNames.length <= 1 || carNames.length >= 6){
            throw new IllegalArgumentException("자동차의 개수는 2개 이상 5개 이하여야합니다.");
        }
    }

    /**
     * 사용자가 입력한 자동차의 이름이 알파벳으로만 이루어졌는지 체크하는 메서드
     *
     * @param carNames 사용자가 입력한 이름 배열
     */
    private static void checkAlphaOnly(String[] carNames){
        for (String name:carNames){
            if (!name.matches("^[a-zA-Z]*$")){
                throw new IllegalArgumentException("자동차의 이름은 알파벳으로만 이루어져야합니다.");
            }
        }
    }

    /**
     * 사용자가 입력한 이름 중에 중복된 이름이 있는지 체크하는 메서드
     *
     * @param carNames 사용자가 입력한 이름 배열
     */
    private static void checkDuplicate(String[] carNames){
        Set<String> nameSet = new HashSet<>();
        for (String name:carNames){
            if (!nameSet.add(name)){
                throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
            }
        }
    }

    /**
     *사용자가 입력한 횟수가 숫자로 이루어져있는지 체크하는 메서드
     *
     * @param count 사용자가 입력한 횟수
     */
    private static void checkIsInt(String count){
        if (!count.matches("^[0-9]+$")){
            throw new IllegalArgumentException("횟수는 숫자로 입력해야합니다.");
        }
    }

    /**
     * 용자가 입력한 횟수가 유효한 크기인지 체크하는 메서드
     * @param count 사용자가 입력한 횟수
     */
    private static void checkRange(String count){
        int countInt = Integer.parseInt(count);
        if (countInt < 2 || countInt > 100){
            throw new IllegalArgumentException("이동횟수는 2회 이상 100회 이하여야합니다.");
        }
    }
}
