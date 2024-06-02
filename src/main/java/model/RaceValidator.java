package model;

import java.util.HashSet;
import java.util.Set;

public class RaceValidator {
    private static final int TRY_NUM_MIN_BOUND = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String SPLIT_CHARACTER = ",";

    public String[] checkSplitCarsName(String carsName){
        String[] names = carsName.split(SPLIT_CHARACTER);
        Set<String> checkDuplication = new HashSet<>();
        for (String carName : names) {
            if (carName.length() > MAX_NAME_LENGTH || carName.isEmpty()){
                throw new IllegalArgumentException("자동차 이름은 1 ~ 5자 입니다.");
            }
            checkDuplication.add(carName);
        }
        if (checkDuplication.size() != names.length){
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        return names;
    }

    public int checkValidTryNumber(String tryNum){
        int returnNumber;

        try{
            returnNumber = Integer.parseInt(tryNum);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("1 이상 2,147,483,647 이하의 자연수만 입력 가능합니다.");
        }

        if(TRY_NUM_MIN_BOUND > returnNumber){
            throw new IllegalArgumentException("1 이상 자연수만 입력 가능합니다.");
        }

        return returnNumber;
    }


}
