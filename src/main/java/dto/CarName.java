package dto;

import java.util.List;

public record CarName (
        List<String> nameList
){
    public CarName(String nameList) {
        this(List.of(nameList.split(",")));
    }

    public CarName(List<String> nameList) {
        nameList.forEach(this::validateName);
        this.nameList = nameList;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
