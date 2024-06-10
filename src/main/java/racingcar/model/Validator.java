package racingcar.model;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public void checkCarsName(String carsName){
        if (carsName.endsWith(",")) {
            throw new IllegalArgumentException("입력 문자열의 마지막 문자가 ','일 수 없습니다.");
        }
        String[] names = carsName.split(",");
        Set<String> carSet = new HashSet<>();
        for (String name : names) {
            if (name.trim().isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1 ~ 5글자로 입력해주세요.");
            }
            if (!carSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public void checkTrialNumber(String trialNumberInput){
        int trialNumber;
        try{
            trialNumber = Integer.parseInt(trialNumberInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("1 이상 2,147,483,647 이하의 자연수를 입력해주세요.");
        }
        if(trialNumber < 1){
            throw new IllegalArgumentException("1 이상 2,147,483,647 이하의 자연수를 입력해주세요.");
        }
    }
}
