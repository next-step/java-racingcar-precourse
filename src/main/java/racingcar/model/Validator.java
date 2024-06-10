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
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1 ~ 5글자로 입력해주세요.");
            }
            if (!carSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
