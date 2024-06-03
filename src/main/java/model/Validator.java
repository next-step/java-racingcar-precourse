package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public boolean checkNames(List<String> names) throws IllegalArgumentException{
        for (String name : names) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("리스트에 빈 문자열이 포함되어 있습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("리스트에 길이가 5를 초과하는 문자열이 포함되어 있습니다.");
            }
        }
        checkDuplicatedNames(names);
        return true;
    }
    public boolean checkAttemps(String attemps) throws IllegalArgumentException{
        try {
            int checkAttempts = Integer.parseInt(attemps);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다. 다시 입력하세요.");
        }
        return true;
    }
    private void checkDuplicatedNames(List<String> names){
        // 리스트를 Set으로 변환한다
        Set<String> nameSet = new HashSet<>(names);

        // 리스트와 Set의 크기를 비교한다
        if(names.size() > nameSet.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
